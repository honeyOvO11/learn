#include<stdio.h>
int main()
{	int sum,a,i,j;
	i=1;j=1;sum=0;a=0;//对四个变量赋值 
	while(i<=100)//循环100次 
	{	while(j<=i)//内循环嵌套 
		{	a=a+j; //一层求和 
			sum=a+sum;//总求和 
			j++;
		}i++;
	}printf("sum=%d",sum);
	return 0;
}
