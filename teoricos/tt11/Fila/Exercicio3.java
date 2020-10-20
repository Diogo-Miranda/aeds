public class Exercicio3 {
	
	public static int maior(Fila fila) throws Exception{
		if(fila.primeiro == fila.ultimo) 
			throw new Exception ("ERRO!");
		Celula i;
		int maior = fila.primeiro.prox.elemento;
		for(i = fila.primeiro.prox; i != null; i = i.prox) {
			if(i.elemento > maior) 
				maior = i.elemento;
		}

		return maior;
	}

	public static void main (String[] args) throws Exception{
		Fila fila = new Fila();
		
		fila.preencher(20);	
		fila.remover();
		fila.mostrar();
		fila.remover();
		fila.mostrar();	
			
		int maior = maior(fila);

		System.out.println("Maior = "+ maior);	
	}
}
