class MatrizFlexivel {
	public int numLinha;
	public int numColuna;
	public Celula inicio;

	public MatrizFlexivel(int numLinha, int numColuna) {
		this.numLinha = numLinha;
		this.numColuna = numColuna;
		inicio = null;

		// Gerar primeira linha
		Celula tmp = new Celula(1);
		inicio = tmp;
		for(int i = 1; i < numColuna; i++) {
			Celula nova = new Celula(1);
			tmp.prox = nova;
			nova.ant = tmp;
			tmp = tmp.prox;
		}
		tmp = null;
			
		Celula ref = inicio;	
		// Começa da segunda linha, a 1
		for(int i = 0; i < numLinha; i++) {
			// Percorrer a linha 
			Celula atual = ref;
			for(int j = 0; j < numColuna; j++) {
				Celula nova = new Celula(1);
	
				// Ponteiro superior
				nova.sup = atual;

				// Verifica se ta na borda esquerda 
				if(atual.ant != null) {
					nova.ant = atual.ant.inf;
					atual.ant.inf.prox = nova;	
				}
											
				atual.inf = nova;
				
				// mudo a coluna da referencia de cima
				if(atual.prox != null)
					atual = atual.prox;
			}
			// Mudo para a linha atual;
			ref = ref.inf;
		}
	}	
	
	public void inserir(int numLinha, int numColuna, int elemento) throws Exception
	{
		if(numLinha < 0 || numLinha > this.numLinha || numColuna < 0 || numColuna > this.numColuna)
			throw new Exception ("ERRO");
		
		Celula ref = inicio;
		Celula atual = ref;	
		for(int i = 0; i <= numLinha; i++) {
			atual = ref;
			for(int j = 0; j < numColuna; j++) {
				//atual.elemento = elemento;
				if(atual.prox != null) atual = atual.prox;	
			}
			ref = ref.inf;
		}		

		atual.elemento = elemento;
		atual = null;
		ref = null;
	}

	public void mostrar() {
		Celula ref = inicio;
		System.out.println("\n");
		Celula atual;
		for(int i = 0; i < numLinha; i++) {
			atual = ref;
			for(int j = 0; j < numColuna; j++) {
				System.out.print(atual.elemento + " ");
				atual = atual.prox;	
			}
			System.out.println("\n");
			ref = ref.inf;
		}
		
		ref = null;
		atual = null;
	}

	public MatrizFlexivel somar (MatrizFlexivel matriz) throws Exception{
			
		if(this.numLinha != matriz.numLinha || this.numColuna != matriz.numColuna)		
			throw new Exception ("ERRO!");
		
		Celula ref = inicio;
		Celula ref2 = matriz.inicio;
		Celula atual;
		Celula atual2;
		
		MatrizFlexivel soma = new MatrizFlexivel(matriz.numLinha, matriz.numColuna);

		int somaElemento = 0;
		for(int i = 0; i < this.numLinha; i++) {
			atual = ref;
			atual2 = ref2;
			for(int j = 0; j < this.numColuna; j++) {
				somaElemento = atual.elemento + atual2.elemento;					
				soma.inserir(i, j, somaElemento);			
				atual = atual.prox;
				atual2 = atual2.prox;
			}
			ref = ref.inf;
			ref2 = ref2.inf;
		}	

		ref = ref2 = atual = atual2 = null;
		
		return soma;
	}

	public MatrizFlexivel multiplicar (MatrizFlexivel matriz) throws Exception {
		if(this.numColuna != matriz.numLinha) 
			throw new Exception ("ERRO!!");
		
		MatrizFlexivel multiplicacao = new MatrizFlexivel(this.numLinha, matriz.numColuna);

		Celula ref = this.inicio;
		Celula ref2 = matriz.inicio;
		Celula atual;
		Celula atual2;
		int mult = 0;
		for(int i = 0; i < numLinha; i++) {
			atual = ref;
			for(int k = 0; k < numColuna; k++) {
				mult = 0;
				atual2 = ref2;
				for(int j = 0; j < numLinha; j++) {
						
					mult = mult + (atual.elemento * atual2.elemento); 
					
					atual2 = atual.inf;		
				}
				multiplicacao.inserir(i, k, mult);
				atual = atual.prox;
			}

			ref = ref.inf;		
			ref2 = ref2.prox;
			
		}			

		return multiplicacao;
	}
	
	public MatrizFlexivel getDiagonalPri() throws Exception{ 
		MatrizFlexivel diagonalPri = new MatrizFlexivel(numLinha, numColuna);							
	
		Celula ref = inicio;
		System.out.println("Diagonal principal : ");
		System.out.print("\n");
		for(int i = 0; i < numColuna; i++) 
		{
			for(int k = 0; k < i; k++) System.out.print("\t");
			diagonalPri.inserir(i, i, ref.elemento);						
			System.out.print(ref.elemento + "\n");	
			ref = ref.inf.prox;
		}

		return diagonalPri;
	}

	public MatrizFlexivel getDiagonalSec() throws Exception {
		MatrizFlexivel diagonalSec = new MatrizFlexivel(numLinha, numColuna);

		// Definir a referencia no final
		Celula ref;
		for(ref = inicio; ref.prox != null; ref = ref.prox); 
		
		System.out.println("Diagonal Secundaria : ");
		System.out.print("\n");
		for(int j = 0; j < numColuna; j++) {
			// Printar os \t
			for(int k = numColuna - 1; k > j; k--) System.out.print("\t");		
			diagonalSec.inserir(j, j, ref.elemento);
			System.out.print(ref.elemento + "\n");
			ref = ref.inf.ant;
		}

		return diagonalSec;
	}
			
}
