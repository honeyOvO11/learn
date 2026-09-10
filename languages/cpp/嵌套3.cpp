#include<stdio.h>
int main()
{	int a,b,c;
	printf("百钱买百鸡的所有可能的解如下:\n"); 
	for(a=0;a<=20;a++)	//因为百钱可以买20只公鸡 
		{for(b=0;b<=33;b++)//可以买33只母鸡 
		{c=100-a-b;	//可求小鸡数量 
	if(a*5+b*3+c/3==100&&c%3==0)//满足100钱输出结果 
	{printf("公鸡%d只，母鸡%d只，小鸡%d只\n",a,b,c);}
	}
	}return 0; 
}
