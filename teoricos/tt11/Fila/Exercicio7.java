public class Exercicio7 {

	public static int contarElementos(Celula celula) {
		int qnt = 0;		

		if(celula != null) {
			qnt += contarElementos(celula.prox);
			if( ( (celula.elemento % 5) == 0) && ( (celula.elemento % 2) == 0) ) 
				qnt++;
		}
		
		return qnt;
	}

	public static void main (String[] args) {
		Fila fila = new Fila();
			
		fila.preencher(20);	
			
		fila.mostrar();

		int qnt = contarElementos(fila.primeiro.prox);

		System.out.println("Qnt = "+ qnt);
	}
}
