
class Celula {
	public int elemento;
	public Celula prox;

	public Celula() {
		this(0);
	}

	public Celula(int elemento) {
		this.elemento = elemento;
		prox = null;
	}

}

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

public class Exercicio7 {

	public static void main (String[] args) throws Exception {
		Pilha pilha = new Pilha();

		pilha.push(3);
		pilha.push(5);		
		pilha.pop();	
		pilha.push(10);		
	
		pilha.view();
	
	}
}
