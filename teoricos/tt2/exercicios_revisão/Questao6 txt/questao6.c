#include "stdio.h"
#include "stdlib.h"

int m1(int i)
{
  
    printf("%i", --i);
    return i;
}

int main()
{
    int i = 1;
    i = m1(i);
    printf("%i", i);
    return 0;
}
