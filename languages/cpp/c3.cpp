#include<stdio.h>
#include<math.h>
int main()
{	int i,n;
	double sum=0;
	printf("n=");
	scanf("%d",&n);							//输出变量n 
	for(i=1;i<=n;i++)						//执行n次循环 
	{	sum=(double)pow(-1.00,i-1)/i+sum;	//累加sum 
	}printf("sum=%.2f\n",sum);
	return 0;
}
