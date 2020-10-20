#include <stdio.h>

int main()
{
    FILE *file = fopen("colx.txt", "aw");
    
    for(int i = 1; i < 100; i++)
    {
        fprintf(file, "%i\n", i);
    }

    fclose(file);
}
