#include<stdlib.h>//rand的头文件 
#include<stdio.h>
#define N 3
#define M 4//定义两个宏变量 
int main()
{	int rand(),i,j,a[N][M];
	double	sum=0,avg,max,min;
	for(i=0;i<N;i++)
	{	for(j=0;j<M;j++)
	{	a[i][j]=rand()%100;//让a[i][j]为随机的0~100 
	printf("%4d",a[i][j]);
	}printf("\n");//输出矩阵 
	}max=a[0][0];min=a[0][0];//赋初始值 
	for(i=0;i<N;i++)
	{	for(j=0;j<M;j++){
		sum=sum+a[i][j];//求和 
		if(max<a[i][j])
		{	max=a[i][j];}//通过比较得出最大值max 
		if(min>a[i][j])
		{	min=a[i][j];}//通过比较得出最小值min 
		}
	}avg=sum/(N*M);//求出平均数 
	printf("sum=%.0f,avg=%.2f,max=%.0f,min=%.0f",sum,avg,max,min);
	return 0;
}
