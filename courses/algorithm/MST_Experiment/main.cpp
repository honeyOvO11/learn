#include <bits/stdc++.h>
using namespace std;
using namespace chrono;

// 定义无穷大
const int INF = 1e9;

// ---------- 边的结构体（用于Kruskal） ----------
struct Edge {
    int u, v, w;
    // 重载小于号，用于按权值排序
    bool operator<(const Edge& other) const {
        return w < other.w;
    }
};

// ---------- 并查集（用于Kruskal） ----------
class DSU {
public:
    vector<int> parent, rank;
    DSU(int n) {
        parent.resize(n);
        rank.resize(n, 0);
        for(int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]); // 路径压缩
        return parent[x];
    }
    bool unite(int x, int y) {
        int rx = find(x), ry = find(y);
        if(rx == ry) return false;
        // 按秩合并
        if(rank[rx] < rank[ry]) parent[rx] = ry;
        else if(rank[rx] > rank[ry]) parent[ry] = rx;
        else {
            parent[ry] = rx;
            rank[rx]++;
        }
        return true;
    }
};

// ---------- 生成随机连通图（邻接矩阵） ----------
// 参数：n个顶点，density为密度（0~1），返回邻接矩阵
vector<vector<int>> generateGraph(int n, double density) {
    // 初始化矩阵，全部设为INF（无边）
    vector<vector<int>> graph(n, vector<int>(n, INF));
    
    // 随机数生成器
    random_device rd;
    mt19937 gen(rd());
    uniform_int_distribution<> weightDist(1, 100); // 边权1~100
    uniform_real_distribution<> probDist(0.0, 1.0);

    // 【关键】为了保证图一定是连通的，先构造一个“生成树骨架”（i 连 i+1）
    for(int i = 0; i < n - 1; i++) {
        int w = weightDist(gen);
        graph[i][i+1] = w;
        graph[i+1][i] = w;
    }

    // 再根据密度概率添加额外的边（无向图）
    for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
            // 如果已经有边了（骨架上的）就跳过
            if(graph[i][j] != INF) continue;
            // 根据密度概率决定是否加边
            if(probDist(gen) < density) {
                int w = weightDist(gen);
                graph[i][j] = w;
                graph[j][i] = w;
            }
        }
    }
    return graph;
}

// ---------- 将邻接矩阵转换为边列表（供Kruskal使用） ----------
vector<Edge> matrixToEdges(const vector<vector<int>>& graph, int n) {
    vector<Edge> edges;
    for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
            if(graph[i][j] != INF) {
                edges.push_back({i, j, graph[i][j]});
            }
        }
    }
    return edges;
}

// ---------- Prim算法（邻接矩阵版，O(n^2)） ----------
// 返回：总权值
int primMST(const vector<vector<int>>& graph, int n) {
    vector<int> key(n, INF);
    vector<bool> inMST(n, false);
    key[0] = 0;
    int totalWeight = 0;

    for(int count = 0; count < n; count++) {
        // 1. 在未加入的顶点中找 key 最小的顶点 u
        int u = -1;
        int minKey = INF;
        for(int i = 0; i < n; i++) {
            if(!inMST[i] && key[i] < minKey) {
                minKey = key[i];
                u = i;
            }
        }
        if(u == -1) break; // 防止非连通图报错

        // 2. 加入生成树
        inMST[u] = true;
        totalWeight += key[u];

        // 3. 更新邻接点的 key 值
        for(int v = 0; v < n; v++) {
            if(!inMST[v] && graph[u][v] != INF && graph[u][v] < key[v]) {
                key[v] = graph[u][v];
            }
        }
    }
    return totalWeight;
}

// ---------- Kruskal算法（并查集版，O(m log m)） ----------
int kruskalMST(const vector<Edge>& edges, int n) {
    DSU dsu(n);
    vector<Edge> sortedEdges = edges;
    sort(sortedEdges.begin(), sortedEdges.end());

    int totalWeight = 0;
    int edgesUsed = 0;

    for(const Edge& e : sortedEdges) {
        if(dsu.unite(e.u, e.v)) {
            totalWeight += e.w;
            edgesUsed++;
            if(edgesUsed == n - 1) break;
        }
    }
    return totalWeight;
}

// ---------- 主程序 ----------
int main() {
    cout << "========== 贪心法实验：最小生成树 ==========" << endl;
    cout << "顶点数n\t图类型\t边数m\tPrim耗时(ms)\tKruskal耗时(ms)\tMST总权值" << endl;
    cout << "---------------------------------------------------------" << endl;

    // 测试的顶点数
    vector<int> ns = {100, 500, 1000, 2000};
    // 密度设定：稀疏图约为 3/n，稠密图约为 0.8（保证接近完全图）
    vector<pair<double, string>> densities = {
        {3.0 / 100, "稀疏"},   // 对于不同n，保持平均度为6
        {0.8, "稠密"}         // 80%的概率加边
    };

    for(int n : ns) {
        for(auto& d : densities) {
            double density = d.first;
            string type = d.second;

            // 1. 生成图
            vector<vector<int>> graph = generateGraph(n, density);
            vector<Edge> edges = matrixToEdges(graph, n);
            int m = edges.size();

            // 2. 计时并运行 Prim
            auto start1 = high_resolution_clock::now();
            int weightPrim = primMST(graph, n);
            auto end1 = high_resolution_clock::now();
            double timePrim = duration_cast<microseconds>(end1 - start1).count() / 1000.0; // 转为毫秒

            // 3. 计时并运行 Kruskal
            auto start2 = high_resolution_clock::now();
            int weightKruskal = kruskalMST(edges, n);
            auto end2 = high_resolution_clock::now();
            double timeKruskal = duration_cast<microseconds>(end2 - start2).count() / 1000.0;

            // 4. 输出一行数据
            cout << n << "\t\t" << type << "\t\t" << m << "\t" 
                 << fixed << setprecision(3) << timePrim << "\t\t" 
                 << fixed << setprecision(3) << timeKruskal << "\t\t" 
                 << weightPrim << endl;

            // 简单校验：两种算法权值应该相等（用于验证正确性）
            if(weightPrim != weightKruskal) {
                cout << "  [警告] 权值不一致！Prim=" << weightPrim << ", Kruskal=" << weightKruskal << endl;
            }
        }
        cout << "---------------------------------------------------------" << endl;
    }
    return 0;
}