class Matriz {
	public static void main (String[] args){
		int n;
		int matriz[][] = new int[10][10];
		int soma[] = new int[10];

		n = MyIO.readInt();

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++) {
				matriz[i][j] = MyIO.readInt();
			}
		}
		
		for(int j = 0; j < n; j++){
			soma[j] = 0;
			for(int i = 0; i < n; i++){
				soma[j] += matriz[i][j];
			}
		}

		for(int j = 0; j < n; j++){
			System.out.print(soma[j] + " ");
		}
	}
}
