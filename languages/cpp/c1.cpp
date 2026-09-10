#include<stdio.h>
int main()
{	int i;
	double sum,s;
	i=1;sum=1;s=0;
	while(i<=20)			//进行20次循环 
	{sum=sum*i;				//sum为累乘 
	s=s+sum;				//s为累加 
	i=i+1;					//每一次循环i加一确保循环次数 
	}
	printf("s=%.0f",s);
	return 0;	
}
