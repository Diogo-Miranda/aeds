class Fila {

	public Celula primeiro, ultimo;
	
	public Fila() {
		primeiro = new Celula();
		ultimo = primeiro;
	}

	public int remover() throws Exception{
		if(ultimo == primeiro) 
			throw new Exception ("underflow");

		Celula tmp = primeiro.prox;
		primeiro.prox = tmp.prox;
		int elemento = tmp.elemento;	

		return elemento;
	}

	public void inserir(int elemento) {
		ultimo.prox = new Celula(elemento);
		ultimo = ultimo.prox;		
	}

	public void mostrar() {
		System.out.print("[ ");
		for(Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		
		System.out.println("] ");
	}
	
	public void preencher(int qnt) {
		for(int i = 0; i < qnt; i++) {
			inserir(i);
		}
	}
	
}
