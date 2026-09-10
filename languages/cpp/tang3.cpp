#include<stdio.h>
int main()
{	int year,month,day,x;
	printf("年,月,日:");
	scanf("%d,%d,%d",&year,&month,&day);//输入变量 
	switch(month)
{	case 1:
		x=day;
		break;
	case 2:
		x=31+day;
		break;
	case 3:
		x=59+day;
		break;
	case 4:
		x=90+day;
		break;
	case 5:
		x=120+day;
		break;
	case 6:
		x=151+day;
		break;
	case 7:
		x=181+day;
		break;
	case 8:
		x=212+day;
		break;
	case 9:
		x=243+day;
		break;
	case 10:
		x=273+day;
		break;
	case 11:
		x=304+day;
		break;
	case 12:
		x=334+day;
		break;					//对应的平年天数 
	}
	if(year%400==0||year%4==0&&year%100!=0&&month>2)//闰年且大于2月的条件 
	x+=1;//满足加一天 
	printf("是第%d天\n",x);//输出结果 
	return 0;		
}
