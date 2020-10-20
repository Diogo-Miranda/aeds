class Principal {

	public static void main (String[] args) throws Exception {
		ListaDupla listaDupla = new ListaDupla();
		
		listaDupla.inserirInicio(5);
		listaDupla.mostrar();		
		listaDupla.inserirFim(10);
		listaDupla.mostrar();
		listaDupla.removerInicio();
		listaDupla.mostrar();
		listaDupla.removerFim();
		listaDupla.mostrar();
		listaDupla.inserirInicio(10);
		listaDupla.mostrar();
		listaDupla.inserir(0, 2);
		listaDupla.mostrar();
		listaDupla.remover(1);
		listaDupla.mostrar();
	}
}
