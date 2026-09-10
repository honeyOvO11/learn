#include<stdio.h>
int main()
{	int i,j,s=0,a=0,A=0,m=0;//j记其他，s记空格，a记小写 
	char str[100];			//A记大写，m记数字 
	printf("键盘任意输入一个字符串：\n");
	for(i=0;(str[i]=getchar())!='\n';)
	{	i++;				
	}	str[i]='\0';		//输出任意一个字符串 
		for(i=0;str[i]!='\0';i++)
		{	if(str[i]==32)
			{	s++; }//求空格的数量 
			if(str[i]>='a'&&str[i]<='z')
			{	a++;}//小写字母的数量 
			if(str[i]>='A'&&str[i]<='Z')
			{	A++;}//大写字母的数量 
			if(str[i]>='0'&&str[i]<='9')
			{	m++;}//数字的数量 
		 }	j=i-s-a-A-m;//其他的数量 
		  printf("空格：%d\n小写字母：%d\n",s,a);
		  printf("大写字母：%d\n数字：%d\n其他：%d",A,m,j);
	return 0; 
} 
