#include<stdio.h>
int main()
{	int s,a;
	char str[10];
	char *i,*j;
	printf("输入一个字符串：");
	for(s=0;(str[s]=getchar())!='\n';s++); 
	str[s]='\0';//输入字符串 
	i=&str[0];j=&str[s-1];//指针位置初始化 
		for(;i<j;i++,j--)
		{	a=*i;*i=*j;*j=a;
		}//进行反序 
		printf("反序后的字符串：%s",str);
		return 0;
}
