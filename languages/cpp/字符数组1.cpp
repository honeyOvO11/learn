#include<stdio.h>
int main()
{	char s[30],str[30];
	int i=0,n=0;
	printf("×Ö·û´®£º");
	while((s[i]=getchar())!='\n')
		{i++;}
		s[i]='\0';
	for(i=0;s[i]!='\0';i++)
	{	if(s[i]<=57&&s[i]>=48)
		{	str[n]=s[i];n++;
		}
	}str[n]='\0';
	printf("%s",str);
	return 0;
 } 
