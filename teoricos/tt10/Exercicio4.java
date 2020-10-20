public class Exercicio4 {

	public static void ordemRemocao(Cell cell) {
		
		if(cell != null) {
			System.out.println(cell.elemento);
			ordemRemocao(cell.prox);
		}
	
	}	

	public static void main (String[] args) {
		Stack stack = new Stack();
		
		stack.populate(20);
			
		ordemRemocao(stack.top);
				

	}
	
}
