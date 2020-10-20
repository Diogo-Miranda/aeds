public class Exercicio6 {
	
	public static Stack desempilhar(Stack stack) {
		Stack tmp = new Stack();

		for(Cell i = stack.top; i != null; i = i.prox) {
			tmp.push(i.elemento);
		}
	
		return tmp;
	}
	
	public static void ordemInsercao(Stack stack) {
		
		for(Cell i = stack.top; i != null; i = i.prox) {
			System.out.println(i.elemento);
		}
	}

	public static void main (String[] args) {
		Stack stack = new Stack();
		
		stack.populate(20);

		Stack tmp = desempilhar(stack);
		
		ordemInsercao(tmp);	
		
	}
}
