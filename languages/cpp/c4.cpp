#include<stdio.h>
int main()
{	int a=1,b=1,c=1,d,e,i;
	for(i=1;i<=4;i++)			//因为按照要求循环是4次 
	{	d=a+b+c;				
		e=b+c+d;
		printf("%7d%7d%7d%7d%7d\n",a,b,c,d,e);	//满足每行5列的要求 
		a=c+d+e;b=d+e+a;c=e+a+b;				//通过顺序结构使后面的结果满足条件 
	}
	return 0;
}
