#include<stdio.h>
int main()
{	int i=0,j,str[10];
	printf("请输入10个数："); 
	while(i<10)
	{	scanf("%d",&str[i]);
		i++;//输入任意10个数 
	}
	printf("10个整数数组：\n"); 
	for(i=0;i<10;i++)
	{	j=str[i];	
	printf("%3d",j);//循环输出显示信息 
	}	printf("\n能被5整除带标记的数组：\n"); 
		for(i=0;i<10;i++)
		{	if(str[i]%5==0)
			{	printf("  T");}
			else 
			{	printf("  F");}//判断输入的数并且一一对应结果 
		}return 0;
 } 
