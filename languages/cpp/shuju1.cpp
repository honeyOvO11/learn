#include<stdio.h>
#define N 2	 
#define M 3	//用宏去控制N，M的变量 
int main()
{	int a[N][M],i,j,x=0,sum;
	printf("请输入一个%d*%d的矩阵序列：",N,M);
	for(i=0;i<N;i++)
	{for(j=0;j<M;j++)
	{	scanf("%2d",&a[i][j]);
	 	printf("%3d",a[i][j]);
		 }
	 	printf("\n");//输出矩阵 
	}for(i=0;i<N;i++)
	{	sum=0;x=i+1;//x为输出第几行，sum为每行求和 
		for(j=0;j<M;j++)
		{	sum=sum+a[i][j];}
		printf("第%d行的和为：%d\n",x,sum);
	}return 0;
 } 
