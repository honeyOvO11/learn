#include<stdio.h>
#define N 3//定义变量N 
int main()
{	printf("开始输入矩阵内容（%d行%d列）\n",N,N);
	int	a[N][N],i,j,sum=0;
	for(i=0;i<N;i++)
	{	for(j=0;j<N;j++)
		{scanf("%d",&a[i][j]);//输入矩阵内容 
		printf("%3d",a[i][j]);
		}printf("\n");//输出矩阵 
	}for(i=0;i<N;i++)
	{	for(j=0;j<=N;j++)
		{	if(i==j||i+j==N-1)//对角线条件 
		sum=sum+a[i][j];//求和	
	}
	}printf("\n对角线元素和为：%d",sum);
	return 0;
}
