class FSemNo {
	Celula primeiro;
	Celula ultimo;

	public FSemNo() {
		primeiro = null;
		ultimo = null;
	}

	public void inserir(int elemento) 
	{
		Celula nova = new Celula(elemento);
		if(primeiro == null && ultimo == null) {
			primeiro = nova;
			ultimo = nova;
		} else {
			ultimo.prox = nova;
			ultimo = ultimo.prox;
		}
		nova = null;
	}

	public int remover() throws Exception {
		if (primeiro == ultimo) 
			throw new Exception ("ERRO!"); 
	
		int elemento = primeiro.elemento;
		primeiro = primeiro.prox;
		
		return elemento;
	}

	public void mostrar() {
		System.out.print("[ ");
		for(Celula i = primeiro; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.print("]");			
	}
		
}

public class Exercicio10 {

	public static void main (String[] args) throws Exception{
		FSemNo fila = new FSemNo();
		
		//fila.remover();
		fila.inserir(10); 
		fila.inserir(3);
		fila.inserir(14);
		fila.remover();
		fila.inserir(1);	
	
		fila.mostrar();
	}
}
