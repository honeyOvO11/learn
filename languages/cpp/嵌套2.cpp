#include<stdio.h>
int main()
{	int sum,a,n,i,j;
	printf("奇数n=");
	scanf("%d",&n);
	for(i=1;i<=n;i+=2)//外循环控制且为奇数 
	{	a=1;//内循环中变量赋初值 
		for(j=1;j<=i;j++)//内循环控制 
		a=a*j;
		sum=sum+a; 
	}printf("sum=%d\n",sum);
	return 0;
}
