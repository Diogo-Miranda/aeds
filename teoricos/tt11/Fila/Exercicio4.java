public class Exercicio4 {
	
	public static void mostrarTerceiro(Fila fila) {
		
		int terceiroElemento = fila.primeiro.prox.prox.prox.elemento;
		System.out.println("Terceiro = "+ terceiroElemento);
	}
			
	public static void main (String[] args) throws Exception {
		Fila fila = new Fila();
		
		fila.preencher(20);
		fila.mostrar();			

		mostrarTerceiro(fila);
		
	}
	
}
