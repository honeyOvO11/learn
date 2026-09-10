#include<stdio.h>
int fun()
{	int i,a=0;
	for(i=0;i<=200;i++)
	{	if(i%10==6&&i%3==0)
		{	printf("%4d",i);//输出满足的条件的整数 
		a++;//计算个数 
		}
	}	printf("\n");
	return a;//返回个数a的值 
}
int main()
{	int s;
	printf("整数为：");
	s=fun();//调用函数fun 
	printf("个数有：%4d",s);//输出个数 
	return 0;
}
