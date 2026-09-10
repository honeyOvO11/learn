#include <stdio.h>
#include <limits.h>   
void swap(int *a, int *b) {
    int t = *a; *a = *b; *b = t;
}
int n;                 
int cost[10][10];      
int best_cost = INT_MAX;   
int best_assign[10];        
int tasks[10];             
void search(int pos) {
    if (pos == n) {
    int total = 0;
    for (int i = 0; i < n; i++) {
    total += cost[i][tasks[i]];   
}
    if (total < best_cost) {
    best_cost = total;
    for (int i = 0; i < n; i++)
    best_assign[i] = tasks[i];
    }
    return;
}
    for (int i = pos; i < n; i++) {
swap(&tasks[pos], &tasks[i]);
search(pos + 1);
swap(&tasks[pos], &tasks[i]);
    }
}

int main() {
    n = 3;
    int cost3[3][3] = {
    {9, 2, 7},
    {6, 4, 3},
    {5, 8, 1}
};
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
    cost[i][j] = cost3[i][j];
    for (int i = 0; i < n; i++) tasks[i] = i;
    best_cost = INT_MAX;
    search(0);
    printf("n=3 任务分配问题\n");
    printf("成本矩阵：\n");
    for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++)
    printf("%2d ", cost[i][j]);
    printf("\n");
    }
    printf("最小总成本 = %d\n", best_cost);
    printf("最优分配：\n");
    for (int i = 0; i < n; i++)
    printf("工人%d -> 任务%d\n", i, best_assign[i]);
    n = 5;
    int cost5[5][5] = {
        {3, 8, 2, 6, 5},
        {7, 1, 4, 9, 2},
        {5, 6, 3, 7, 8},
        {2, 4, 9, 1, 6},
        {8, 3, 5, 2, 4}
    };
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
    cost[i][j] = cost5[i][j];
for (int i = 0; i < n; i++) tasks[i] = i;
best_cost = INT_MAX;
search(0);
printf("\nn=5 任务分配问题\n");
printf("成本矩阵：\n");
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++)
    printf("%2d ", cost[i][j]);
    printf("\n");
}
    printf("最小总成本 = %d\n", best_cost);
    printf("最优分配：\n");
    for (int i = 0; i < n; i++)
    printf("工人%d -> 任务%d\n", i, best_assign[i]);
return 0;
}
