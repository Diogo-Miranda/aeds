public class Exercicio5 {
	
	public static int somar(Fila fila) {
		int soma = 0;
		Celula i;
		for(i = fila.primeiro.prox; i != null; i = i.prox) {
			soma += i.elemento;
		}
		return soma;
	}

	public static void main (String[] args) {
		Fila fila = new Fila();

		fila.preencher(20);

		int soma = somar(fila);

		System.out.println("Soma = "+ soma);
	}
		
}
