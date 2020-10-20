public class Exercicio2 {
		
	public static int maior(Stack stack) {
				
		Cell i = stack.top;
		int maior = i.elemento;
		for(i = i.prox; i != null; i = i.prox) 
			if(i.elemento > maior) 
				maior = i.elemento;
			
		return maior;
	}
	
	public static void main (String[] args) throws Exception{
		Stack stack = new Stack();
		stack.populate(20);
		stack.push(3542);
		stack.push(1);
		stack.view();	
		System.out.println("Maior: "+ maior(stack));
		stack.pop();
		stack.pop();
		stack.view();
		System.out.println("Maior: "+maior(stack));	
	}
	
}
