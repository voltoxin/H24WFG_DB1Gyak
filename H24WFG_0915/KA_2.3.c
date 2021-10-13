#include <stdio.h>
#include <stdlib.h>

int main()
{
    feladat_3();
    return 0;
}
void feladat_3(char *file1, char *file2)
{
    FILE *fptr1, *fptr2;
    char filename[100], c;

    printf("Adja meg az olvasando file nevet: ");
    scanf("%s", filename);

    fptr1 = fopen(filename, "r");
    if (fptr1 == NULL)
    {
        printf("Nem lehet megnyitni %s \n", filename);
        exit(0);
    }

    printf("Adja meg az irando file nevet: ");
    scanf("%s", filename);

    fptr2 = fopen(filename, "w");
    if (fptr2 == NULL)
    {
        printf("Nem lehet megnyitni %s \n", filename);
        exit(0);
    }


    c = fgetc(fptr1);
    while (c != EOF)
    {
        fputc(c, fptr2);
        c = fgetc(fptr1);
    }

    printf("File tartalma atmasolva ide: %s", filename);

    fclose(fptr1);
    fclose(fptr2);
}
