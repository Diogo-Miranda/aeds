public class Principal {

	public static void main (String[] args) throws Exception {
		Lista lista = new Lista();
		
		lista.inserirInicio(5);
		lista.inserirInicio(3);
		lista.mostrar();
		lista.removerSegundaPos();
		lista.mostrar();	
	}	
}
