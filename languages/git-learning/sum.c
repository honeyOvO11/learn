#include<stdio.h>
int mian()
{   int a[10];
    int sum,i,j,n,b;
        for(i=0;a[i]!='\n';i++)
        {scanf("%d\n",&a[i]);
        }
        for(j=0;j<i-1;j++)
        {
            n=a[j];
             for(sum=0,b=0;b<=n;b++)
             {  sum+=b;
             }
             printf("%d\n",sum);
        }
        return 0;
}