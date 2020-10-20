#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n;
	int matriz[10][10];
	int soma[10];

	scanf("%i", &n);

	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < n; j++)
		{
			scanf("%i", &matriz[i][j]);
		}
	}

	for(int j = 0; j < n; j++)
	{
		soma[j] = 0;
		for(int i = 0; i < n; i++)
		{
			soma[j] += matriz[i][j];
		}
	}

	for(int j = 0; j < n; j++)
	{
		printf("%i ", soma[j]);
	}

	return 0;
}

