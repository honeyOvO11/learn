#include<stdio.h>
#include<math.h>
int fun(int a)
{	int x,y,sum=1;
	for(x=2;x<=sqrt(a);x++)
	{	if(a%x==0) 
		sum=sum+x+a/x;//循环累加公约数 
		}	if(sum==a)
		return sum;//如果是完全数返回 
		else
			return 0;//如果不是返回0	
}
int main()
{	int x,i;
	printf("1到1000之间的所有完全数有：");
	for(i=1;i<=1000;i++)
	{	x=fun(i);//调用函数fun 
		if(x!=0&&x!=1)
		{printf("%-4d",x);}//如果返回值不为0和1输出结果 
	}
 } 
