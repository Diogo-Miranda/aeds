public class Exercicio1 {
	
	public static int somar(Cell cell) {
		int soma = 0;		

		if(cell != null) {
			soma += cell.elemento + somar(cell.prox);
		}
		
		return soma;	
	} 
			
	public static void main (String[] args) throws Exception{
		Stack stack = new Stack();	
		stack.populate(20);
		stack.view();	
		System.out.println(somar(stack.top));
	}

}
