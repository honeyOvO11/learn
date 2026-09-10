#include<stdio.h>
int main()
{	int i;
	double sum,s;
	i=1;sum=1;s=0;
	do					//循环入口 
	{	sum=sum*i;		//sum为累乘 
		s=sum+s;		//s为累加 
		i=i+1;			//累加项的增量 
	}while(i<=20);		//循环条件 
	printf("do while s=%.0f",s);
	return 0;
}
