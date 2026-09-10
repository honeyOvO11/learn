#include<stdio.h>
#include<math.h>
int main()
{	int a,b,c,s,i;
	for(i=100;i<=1000;i++)//进入循环 
	{	a=i/100%10; 
		b=i/10%10;
		c=i%10;
		s=pow(a,3)+pow(b,3)+pow(c,3);
		if(s==i&&s!=1000)//满足水仙花的条件的值输出且易知1000不满足 
		{printf("水仙花数:%4d\n",s);}
	}return 0;
}
