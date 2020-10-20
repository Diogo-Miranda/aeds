public class Exercicio3 {

	public static int maior(Cell cell) {
		int maior = 0;

		if(cell.prox == null) {
			maior = cell.elemento;
		} else {
			maior = maior(cell.prox);
			if(cell.elemento > maior) 
				maior = cell.elemento;
		}
		
		return maior;
	}

	public static void main (String[] args) throws Exception{
		Stack stack = new Stack();
		
		stack.populate(30);
		stack.view();

		System.out.println("Maior : "+ maior(stack.top));

		stack.pop();
		stack.push(454);
		stack.push(1);
		stack.view();
		
		System.out.println("Maior : "+ maior(stack.top));
	}
}
