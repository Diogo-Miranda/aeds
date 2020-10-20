class ListaDupla {
	public Celula primeiro;
	public Celula ultimo;

	public ListaDupla() 
	{
		primeiro = new Celula();
		ultimo = primeiro;
	}

	public void inserirInicio(int elemento) {
		Celula nova = new Celula(elemento);	
		nova.prox = primeiro.prox;
		primeiro.prox = nova;
		nova.ant = primeiro;
		if(primeiro == ultimo) 
			ultimo = nova;
		else
			nova.prox.ant = nova;
	
		nova = null;
	}

	public void inserirFim(int elemento) {
		Celula nova = new Celula(elemento);
		ultimo.prox = nova;
		nova.ant = ultimo;
		ultimo = nova;
		nova = null;
	}

	public int removerInicio() throws Exception {
		if(primeiro == ultimo)
			throw new Exception ("ERRO!");

		int elemento;
		Celula tmp = primeiro.prox;
		primeiro.prox = tmp.prox;
		primeiro.prox.ant = primeiro;
		elemento = tmp.elemento;
		tmp = null;
			
		return elemento;
	}
	
	public int removerFim() throws Exception {
		if(primeiro == ultimo)
			throw new Exception ("ERRO!");

		int elemento;
		Celula tmp = ultimo;
		ultimo = ultimo.ant;
		ultimo.prox = null;
		elemento = tmp.elemento;
		tmp = null;

		return elemento;
	}

	public void inserir(int pos, int elemento) throws Exception {
		int tam = tamanho();
		if(pos >= tam || pos < 0) {
			throw new Exception ("ERRO!"); 
		} else if (pos == 0) {
			inserirInicio(elemento);
		} else if (pos == tam-1) {
			inserirFim(elemento);
		} else {
			Celula i = primeiro.prox;
			for(int j = 0; j < pos; j++, i = i.prox);
		
			Celula nova = new Celula(elemento);
			nova.ant = i;
			nova.prox = i.prox;
			nova.ant.prox = nova.prox.ant = nova;
			nova = i = null;					
		}
	}

	public int remover(int pos) throws Exception {
		int elemento = 0, tam = tamanho();
		if(primeiro == ultimo || pos < 0 || pos >= tam) {
			throw new Exception ("ERRO!");
		} else if (pos == 0) {
			elemento = removerInicio();
		} else if (pos == tam-1) {
			elemento = removerFim();
		} else {
			// paro uma pos antes
			Celula i = primeiro;
			for(int j = 0; j < pos; j++, i = i.prox);
			Celula tmp = i.prox;
			i.prox = tmp.prox;
			tmp.prox.ant = i;
			elemento = tmp.elemento;
			tmp = null;
		}
		return elemento;
	}

	public void mostrar() {
		System.out.print("\n[ ");
		for(Celula i = primeiro.prox; i != null; i = i.prox)
			System.out.print(i.elemento + " ");
		System.out.print("]\n");
	}

	public int tamanho() {
		int tamanho = 0;
		for(Celula i = primeiro.prox; i != null; i = i.prox)
			tamanho++;

		return tamanho;
	}
	
	public void inverteLista() {
		int tamanho = tamanho();
		Celula fim = ultimo;

		Celula i = primeiro.prox;
		Cleula j = ultimo;
		while(i != j && j.prox != i) {
			int tmpElemento = i.elemento;
			i.elemento = j.elemento;
			j.elemento = i.elemento;
			i = i.prox; 
			j = j.ant;			
		}

	}

}
