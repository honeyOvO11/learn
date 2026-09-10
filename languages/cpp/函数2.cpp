#include<stdio.h>
int a(int s)
{	if(s%2==0)//在被调函数判断且输出奇偶 
	{	printf("%d是偶数",s);
	}	else
			printf("%d是奇数",s);
}
int main()
{	int s;
	printf("请输入一个整数："); 
	scanf("%d",&s);//主函数输入一个数 
	a(s);//调用a函数 
	return 0;
}
