#include<stdio.h>
int main()
{	int a=0,i,j=0;
	for(i=1;i<=100;i++)
	{	if(i%3==0&&i%2==1||i%5==0&&i%2==1)//满足条件的i 
		{printf("%4d",i);
		if(++j%6==0)
		printf("\n");	//输出6个结果换行 
		a=a+i;			//循环求和 
		}
	}printf("\na=%d",a);
	return 0;
}
