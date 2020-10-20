public class Exercicio5 {

	public static void ordemInsercao(Cell cell) {
		
		if(cell != null) {
			ordemInsercao(cell.prox);
			System.out.println(cell.elemento);
		}
	}	

	public static void main (String[] args) {
		Stack stack = new Stack();
		
		stack.populate(20);

		ordemInsercao(stack.top);

	}
}
