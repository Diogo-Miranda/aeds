class Pilha {
	public Celula topo;
	
	public Pilha() {
		topo = new Celula();
	}
	
	public void push(int elemento) {
		Celula tmp = new Celula(elemento);
		Celula tmp2;
		tmp2 = topo.prox;
		topo.prox = tmp;
		tmp.prox = tmp2;
		tmp = null;
		tmp2 = null;
	}
		
	public int pop() throws Exception{
		if(topo.prox == null) 
			throw new Exception("underflow");
		
		Celula tmp = topo.prox;	
		topo.prox = tmp.prox;
		
		return tmp.elemento;	
	}	
	
	public void view() {
		System.out.print("[ ");
		for(Celula i = topo.prox; i != null; i = i.prox){
			System.out.print(i.elemento + " ");
		} 
		System.out.print("]");
	}	

}

public class Exercicio9 {

	public static Fila toFila(Celula topo) {
		Pilha pilha = new Pilha();
		
		for(Celula i = topo.prox; i != null; i = i.prox) {
			pilha.push(i.elemento);	
		}		
		
		Fila fila = new Fila();
		
		for(Celula i = pilha.topo.prox; i != null; i = i.prox) {
			fila.inserir(i.elemento);
		}
		
		return fila;
	} 

	public static void main (String[] args) {
		Fila fila;

		Pilha pilha = new Pilha();
		pilha.push(7);
		pilha.push(6);
		pilha.push(5);
		pilha.view();
	
		fila = toFila(pilha.topo);

		fila.mostrar();
	}	

}
