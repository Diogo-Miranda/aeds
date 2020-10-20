public class Principal {

	public static void main (String[] args) throws Exception{
		Fila fila = new Fila();

		fila.inserir(3);
		fila.inserir(5);
		fila.mostrar();
		fila.remover();
		fila.mostrar();	
		fila.remover();
		fila.mostrar();	
	}
	
}
