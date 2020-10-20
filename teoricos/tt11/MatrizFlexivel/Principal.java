class Principal {

	public static void main (String[] args) throws Exception {
		MatrizFlexivel matrizFlexivel = new MatrizFlexivel(3, 3);
			
		//matrizFlexivel.inserir(2, 2, 10);	
		
		MatrizFlexivel matrizTmp = new MatrizFlexivel(3, 3);
		matrizTmp.inserir(1,1, 25);
		matrizTmp.inserir(2,2, 50);
		matrizTmp.inserir(1,2, 654);		
		matrizTmp.inserir(0,0, 4545);		
		matrizTmp.inserir(0,2, 777);
		//MatrizFlexivel soma = matrizFlexivel.somar(matrizTmp);		
		
		//soma.mostrar();
		
		MatrizFlexivel multiplicacao = matrizFlexivel.multiplicar(matrizTmp);
		
		//multiplicacao.mostrar();
		
		matrizTmp.mostrar();	
		matrizTmp.getDiagonalPri();
		matrizTmp.getDiagonalSec();	
		//matrizFlexivel.mostrar();
	
			
	}
}
