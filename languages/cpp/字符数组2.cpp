#include<stdio.h>
#define n 5
int main()
{	printf("准备输入n个字符串：%d\n",n);
	int i,j=0,a=0; 
	char str[100],s[100];
	for(i=1;i<=n;i++)
	{	printf("第%d个字符串：",i); 
		for(j=0;(str[j]=getchar())!='\n';)
		{	j++;//输入n个字符串 
		}str[j]='\0';
		if(j>a)//选出字符长度最长的 
		{	for(j=0;str[j]!='\0';j++)
			{	a=j;
			s[a]=str[j];//赋值在s字符组里 
			}
		}
	}a++;s[a]='\0';
	printf("最长的字符串是：%s",s);//输出结果 
	return 0;
 } 
