#include <stdio.h>
#include <stdlib.h>

struct Auto {
char rendszam[10];
char tipus[20];
int ar;
} ;

int main()
{
    feladat4_visz();
    feladat4_olvas();
    return 0;
}
void feladat4_visz(){
    struct Auto autok[3];
    FILE *fdata;
    for (int i=0; i< 3; i++) {
        printf("Rendszam: ");
        scanf("%s",&autok[i].rendszam);
        printf("Tipus: ");
        scanf("%s",&autok[i].tipus);
        printf("Ar: ");
        scanf("%d",&autok[i].ar);
    }
    fdata = fopen("Autok.dat", "wb");
    for (int i=0; i< 3; i++) {
        fwrite(&(autok[i]), sizeof(struct Auto),1, fdata);
    }
    fclose(fdata);
}
void feladat4_olvas(int rekord){
    FILE *fdata;
    fdata = fopen("Autok.dat", "rb");
    struct Auto a;
    if (fdata == NULL) {
        printf ("Hibas file\n");
        return;
    }
    printf("Adja meg a rekordot: ");
    scanf("%d", &rekord);
    fseek(fdata, (rekord-1)* sizeof(struct Auto),0 );
    fread(&a, sizeof(struct Auto),1, fdata);
    printf("Az %d. rekord: \n",rekord);
    printf ("Rendszam: %s,\t", a.rendszam);
    printf ("Tipus: %s,\t", a.tipus);
    printf ("Ar: %d.\t", a.ar);
    fclose(fdata);
}
