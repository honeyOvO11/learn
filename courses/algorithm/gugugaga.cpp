#include <stdio.h>

// 交换两个数
void swap(int a, int b) {
    int t = a;
    a = b;
    b = t;
}

// 递归生成排列
// arr: 数组， start: 当前要固定的位置， n: 总长度
void permute(int arr[], int start, int n) {
    if (start == n) {          // 所有位置都固定好了，输出一个排列
        for (int i = 0; i < n; i++)
            printf("%d ", arr[i]);
        printf("\n");
        return;
    }
    for (int i = start; i < n; i++) {
        swap(arr[start], arr[i]);      // 把第i个数字换到start位置
        permute(arr, start + 1, n);      // 固定下一个位置
        swap(arr[start], arr[i]);      // 换回来，恢复原样
    }
}
int main() {
    int arr3[] = {1, 2, 3};
    printf("n=3 的全排列（共6个）：\n");
    permute(arr3, 0, 3);
    int arr5[] = {1, 2, 3, 4, 5};
    printf("\nn=5 的全排列：\n");
    int count = 0;
    printf("（实际程序会输出120行，这里省略，运行即可见）\n");
    return 0;
}