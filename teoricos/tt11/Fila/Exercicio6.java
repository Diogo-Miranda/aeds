public class Exercicio6 { 

	public static void inverter(Fila fila) {
		Celula fim = fila.ultimo;
		while(fila.primeiro.prox != fim) {
			Celula nova = new Celula (fila.primeiro.prox.elemento);
			nova.prox = fim.prox;
			fim.prox = nova;
			Celula tmp = fila.primeiro.prox;
			fila.primeiro.prox = tmp.prox;
			nova = tmp = tmp.prox = null;
			if(fila.ultimo == fim) fila.ultimo = fila.ultimo.prox;
		}
		fim = null;		
	}

	public static void main (String[] args) {
		Fila fila = new Fila();

		fila.preencher(20);
			
	
		inverter(fila);
		fila.mostrar();
		
	}

}
