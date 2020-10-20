class Lista {
	Celula primeiro;
	Celula ultimo;

	public Lista() 
	{
		primeiro = new Celula();
		ultimo = primeiro;
	}

	public void inserirInicio(int elemento) 
	{
		Celula nova = new Celula(elemento);
		nova.prox = primeiro.prox;
		primeiro.prox = nova;	
		if(ultimo == primeiro) ultimo = nova;
		nova = null;
	}

	public void inserirFim(int elemento) 
	{
		Celula nova = new Celula(elemento);
		ultimo.prox = nova;
		ultimo = nova;
		nova = null;		
	}

	public int removerInicio() throws Exception 
	{
		if(primeiro == ultimo)
			throw new Exception ("Erro!");
		
		int elemento = primeiro.prox.elemento;
		Celula tmp = primeiro.prox;
		primeiro.prox = tmp.prox;
		tmp = null;
		
		return elemento;
	}

	public int removerFim() throws Exception 
	{
		if(primeiro == ultimo) 
			throw new Exception ("Erro!");
	
		int elemento = ultimo.elemento;
		Celula i;
		for(i = primeiro.prox; i.prox != ultimo; i = i.prox);
		
		ultimo = i;
		i.prox = null;
		i = null;	
	
		return elemento;
	}
		
	public int tamanho() {
		int tamanho = 0;

		for(Celula i = primeiro.prox; i != null; i = i.prox, tamanho++);
		
		return tamanho;
	}

	public int remover(int pos) throws Exception { 
		int tam = tamanho();
		int elemento = 0;
		if(primeiro == ultimo || pos < 0 || pos >= tam) {
			throw new Exception ("ERRO!"); 	
		} else if (pos == 0) {
			elemento = removerInicio();
		} else if (pos == tam - 1) {
			elemento = removerFim();
		} else {
			Celula i = primeiro.prox;
			// Parar uma posicao antes
			for(int j = 0; j < pos - 1; j++, i = i.prox);
			elemento = i.elemento;
			Celula tmp = i.prox;
			i.prox = tmp.prox;
			tmp.prox = null;
			i = tmp = null;
		}

		return elemento;
	}	

	public void inserir(int pos, int elemento) throws Exception{
		int tam = tamanho();
		if(primeiro == ultimo || pos < 0 || pos >= tam) {
			throw new Exception ("ERRO!");
		} else if (pos == 0) {
			inserirInicio(elemento);
		} else if (pos == tam-1) {
			inserirFim(elemento);
		} else {
			Celula i = primeiro.prox;
			// Parar uma posicao antes
			for(int j = 0; j < pos - 1; j++, i = i.prox);
			Celula nova = new Celula(elemento);
			nova.prox = i.prox;
			i.prox = nova;
			nova = i = null;
		}
	}

	public void mostrar() {
		System.out.print("\n[ ");
		for(Celula i = primeiro.prox; i != null; i = i.prox) 
			System.out.print(i.elemento + " ");
		System.out.print("]\n");
		
	}

	public int removerSegundaPos() throws Exception 
	{
		int tam = tamanho();
		if(primeiro == ultimo || tam < 2) 
			throw new Exception("ERRO!");

		Celula p = primeiro.prox;
		Celula q = p.prox;
		int elemento = q.elemento;
		p.prox = q.prox;
		q = null; 

		return elemento;
	}	
}	
