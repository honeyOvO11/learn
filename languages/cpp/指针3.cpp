#include<stdio.h>
int main()
{	int str[10];
	int *p;
	printf("请输入10个元素：");
	for(p=str;p<str+10;p++)
	{	scanf("%d",p);//输入10个元素 
	 }printf("数组元素为：");
	  for(p=str;p<str+10;p++)
	  {	printf("%3d",*p);//输出数组元素 
	  }printf("\n奇数位上的元素为：");
	  		for(p=str;p<str+10;p+=2)
	  		{	printf("%3d",*p);
			  }//输出奇数位上的元素 
		printf("\n偶数位上的元素为：");
			for(p=str+1;p<str+10;p+=2)
			{	printf("%3d",*p);
			}return 0;//输出偶数位上的元素 
 } 
