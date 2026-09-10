#include <iostream>
#include <ctime>
#include <cstdlib>
#include <algorithm>
#include <cstring>

using namespace std;
// ==================== 1. 冒泡排序 ====================
void BubbleSort(int a[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            if (a[j] > a[j + 1]) {
                int temp = a[j];
                a[j] = a[j + 1];
                a[j + 1] = temp;
            }
        }
    }
}

// ==================== 2. 快速排序 ====================
int partition(int a[], int low, int high) {
    int pivot = a[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (a[j] <= pivot) {
            i++;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    int temp = a[i + 1];
    a[i + 1] = a[high];
    a[high] = temp;
    return i + 1;
}

void QuickSort(int a[], int low, int high) {
    if (low < high) {
        int pi = partition(a, low, high);
        QuickSort(a, low, pi - 1);
        QuickSort(a, pi + 1, high);
    }
}

// 快速排序包装函数
void QuickSortWrapper(int a[], int n) {
    QuickSort(a, 0, n - 1);
}

// ==================== 3. 生成随机数组 ====================
void generateRandomArray(int a[], int n) {
    for (int i = 0; i < n; i++) {
        a[i] = rand() % 100000;  // 生成0-99999的随机数
    }
}

// ==================== 4. 复制数组 ====================
void copyArray(int src[], int dst[], int n) {
    for (int i = 0; i < n; i++) {
        dst[i] = src[i];
    }
}

// ==================== 5. 主函数：实验对比 ====================
int main() {
    int n;
    cout << "请输入数据规模 n 的值: ";
    cin >> n;

    // 动态分配数组
    int* original = new int[n];
    int* a = new int[n];

    // 生成随机数据
    srand((unsigned)time(NULL));
    generateRandomArray(original, n);

    cout << "========================================" << endl;
    cout << "数据规模: " << n << endl;
    cout << "========================================" << endl;

    // ---------- 测试冒泡排序 ----------
    copyArray(original, a, n);
    clock_t start = clock();
    BubbleSort(a, n);
    clock_t end = clock();
    double time_bubble = (double)(end - start) / CLOCKS_PER_SEC;
    cout << "【冒泡排序】  time = " << time_bubble << " s" << endl;

    // ---------- 测试快速排序 ----------
    copyArray(original, a, n);
    start = clock();
    QuickSortWrapper(a, n);
    end = clock();
    double time_quick = (double)(end - start) / CLOCKS_PER_SEC;
    cout << "【快速排序】  time = " << time_quick << " s" << endl;

    // ---------- 结果对比 ----------
    cout << "========================================" << endl;
    if (time_bubble > 0) {
        cout << "快速排序比冒泡排序快约 " << time_bubble / time_quick << " 倍" << endl;
    }

    // 输出前10个元素验证正确性
    cout << "\n排序结果验证（前10个元素）: ";
    for (int i = 0; i < min(n, 10); i++) {
        cout << a[i] << " ";
    }
    cout << endl;

    // 释放内存
    delete[] original;
    delete[] a;

    return 0;
}
