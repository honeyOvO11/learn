#include <stdio.h>

int main() {
    int arr[] = {12,3,4,5,78,1,35,2013,22,2023,1010};
    int len = sizeof(arr)/sizeof(arr[0]); // 计算数组长度
    
    // 初始化最大最小值
    int max = arr[0];
    int min = arr[0];
    
    // 遍历数组比较
    for(int i = 1; i < len; i++) {
        if(arr[i] > max) max = arr[i];
        if(arr[i] < min) min = arr[i];
    }
    
    printf("数组最大值：%d\n数组最小值：%d\n", max, min);
    return 0;
}
