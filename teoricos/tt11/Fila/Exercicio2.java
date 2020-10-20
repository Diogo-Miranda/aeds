class Fila {

	private Celula primeiro, ultimo;
	
	public Fila() {
		primeiro = new Celula();
		ultimo = primeiro;
	}
	
	public int remover() throws Exception{
		if(ultimo == primeiro) 
			throw new Exception ("underflow");

		Celula tmp = primeiro.prox;
		primeiro.prox = tmp.prox; // primeiro.prox.prox
		int elemento = tmp.elemento;	

		return elemento;
	}

	public void inserir(int elemento) {
		ultimo.prox = new Celula(elemento);
		ultimo = ultimo.prox;		
	}
	
	/** Exercicio2
	/ * Metodo Mostrar
	*/
	public void mostrar() {
		System.out.print("[ ");
		for(Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		
		System.out.println("] ");
	}
}

class Celula {
	public Celula prox;
	public int elemento;

	public Celula() {
		this(0);
	}

	public Celula(int elemento) {
		this.elemento = elemento;
		this.prox = null;
	}
}

