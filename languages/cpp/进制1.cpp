#include <stdio.h>

void convert(int mode) {
    if (mode == 1) {
        int n,b,i=0;
        char s[32];
        printf("输入十进制数 目标进制: ");
        scanf("%d%d",&n,&b);
        do s[i++]="0123456789ABCDEF"[n%b]; while(n/=b);
        printf("结果: ");
        while(i--) putchar(s[i]);
    } else {
        char s[32];
        int b,n=0;
        printf("输入数 当前进制: ");
        scanf("%s%d",s,&b);
        for(int i=0;s[i];i++){
            int c = s[i]-(s[i]>'9'?'A'-10:'0');
            if(c>=b) {printf("输入错误");return;}
            n = n*b + c;
        }
        printf("十进制: %d",n);
    }
}

int main() {
    int c;
    printf("[1]十转其他\n[2]其他转十\n选择: ");
    scanf("%d",&c);
    convert(c);
    return 0;
}
