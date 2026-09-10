#include<stdio.h>
#include<math.h>						/*预处理数学函数*/ 
int main()								
{	int x,f;							/*定义两个整型变量*/ 
	printf("输入x=");					/*显示提示信息*/ 
	scanf("%d",&x);						/*输入一个整型，赋给x*/ 
	if(x<0&&x!=-3)						/*满足x小于0且x不等于-3*/ 
		f=(int)pow(x,2)+x-6;			/*满足条件运行函数f*/ 
	else
		{	if(x<10&&x!=2&&x!=3&&x!=-3)	/*否则满足x<10且x不等于2和3和-3*/ 
			f=(int)pow(x,2)-5*x+6;		/*运行当前函数f*/ 
			else						
			f=(int)pow(x,2)-x-1;		/*否则运行函数f*/ 
		}
		printf("结果f(x)=%d",f);		/*输出结果*/ 
	return	0; 
}
