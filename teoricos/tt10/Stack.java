/**
 * descrever uma stack
 * @author: Diogo Araujo Miranda
*/
class Stack {
	public Cell top;
	
	public Stack(){
		top = null;
	}
	
	public void push(int elemento) {
		Cell tmp = new Cell(elemento);
		tmp.prox = top;
		top = tmp;
		tmp = null; 	
	}
	
	public int pop() throws Exception{
		if(top == null)
			throw new Exception ("underflow");
	
		int elemento = top.elemento;	
		Cell tmp = top;
		top = top.prox;
		tmp.prox = null;
		tmp = null;

		return elemento;		
	}	
	
	public void view() {
		System.out.print("[ ");
		for(Cell i = top; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.print("]\n");
	}
	
	/**
	 * popular uma stack com valores
	 * @author : Diogo Araujo Miranda
	 * @param int qnt - quantidade de termos
	*/
	public void populate(int qnt) {
		for(int i = 0; i < qnt; i++) {
			push(i);
		} 		
	}	
}
