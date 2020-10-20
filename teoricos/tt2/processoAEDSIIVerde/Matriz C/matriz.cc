#include <iostream>
using namespace std;

int main(){

	int n;
	int matriz[10][10];
	int soma[10];

	cin >> n;

	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			cin >> matriz[i][j];
		}
	}

	for(int j = 0; j < n; j++){
		soma[j] = 0;
		for(int i = 0; i < n; i++){
			soma[j] += matriz[i][j];
		}
	}

	for(int j = 0; j < n; j++){
		cout << soma[j] << " ";
	}
}
