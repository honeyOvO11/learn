#include <stdio.h>

void swap(int *a, int *b) {
 int t=*a;
 *a=*b;
 *b=t;
}
void permute(int arr[], int start, int n) {
    if (start == n) {
    for (int i = 0; i < n; i++)
    printf("%d ", arr[i]);
    printf("\n");
    return;
}
for (int i = start; i < n; i++) {
 swap(&arr[start], &arr[i]);      
 permute(arr, start + 1, n);     
 swap(&arr[start], &arr[i]);       
 }
}

int main() {
    int arr3[] = {1, 2, 3};
    printf("n=3 的全排列：\n");
    permute(arr3, 0, 3);
    int arr5[] = {1, 2, 3, 4, 5};
    printf("\nn=5 的全排列：\n");
    int count = 0;
    permute(arr5, 0, 5);
	printf("\n");  
    return 0;
}
