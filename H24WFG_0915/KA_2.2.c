#include <stdio.h>
#include <stdlib.h>
void feladat_2();

int main()
{
    feladat_2();
    return 0;
}
void feladat_2()
{
    FILE *fp;
    char ch;
    char fnev[50];
    printf("Filenev: ");
    scanf("%s", fnev);
    fp=fopen(fnev, "w");
    printf("Uzenet:\n");

    while((ch = getchar())!='#'){
        putc(ch,fp);
    }fclose(fp);


    fp=fopen(fnev,"r");
    while((ch=getc(fp))!=EOF){
            if(islower(ch)){
            ch=ch-32;
            printf("%c",ch);
            }
    }
    fclose(fp);
    return 0;
    }
