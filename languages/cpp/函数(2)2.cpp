#include<stdio.h>
#include<math.h>
int fun(int a,int b,int c)
{	if(a+b<=c||a+c<=b||b+c<=a)
	{	printf("不构成三角形"); 
	 } else
	 {	printf("能构成三角形，");//判断能不能构成三角形 
	 if(a==b&&b==c&&c==a)
	 {	printf("是等边三角形"); }
	 	else
	 	{	if(a==b||a==c||b==c)
	 		{	printf("是等腰三角形");}//判断等边还是等腰 
	 		else
	 		 { printf("是不等边三角形，");
			   int max,i,j;
			   {if(a>b)
			   		if(a>c)
			   				max=a,i=b,j=c;
			 		else	
					 		max=c,i=a,j=b;
				else 
				 if(b>c)
				 max=b,i=a,j=c;
				 	else	max=c,i=a,j=b;}
				 if(pow(max,2)==pow(i,2)+pow(j,2))
				 printf("是直角三角形");
				   if(pow(max,2)>pow(i,2)+pow(j,2))
				    printf("是钝角三角形");
					 if(pow(max,2)<pow(i,2)+pow(j,2)) 
					 printf("是锐角三角形");
					 //判断直角还是钝角，锐角三角形	
	 } } } }
int main()
{	int a,b,c;
	printf("请输入三条边：");
	scanf("%d %d %d",&a,&b,&c);
	fun(a,b,c);//主函数输入值 
}
