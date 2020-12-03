import java.math.*;
import java.util.List;
import java.util.ArrayList;
import ListaDupla.ListaDupla;
import ListaSimples.ListaSimples;

public class Exercicios {
	
	public static Double log2(int x) {
		return (Math.log(x) / Math.log(2));
	}

	public static void main (String[] args) throws Exception{
		ArvoreBinaria ab = new ArvoreBinaria();


		// ======================================================= //
		System.out.println("Exercicio 1) ");
		System.out.println("Num Elementos = " + ab.getNumElementos());
		int x = 6;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 3;
		ab.inserir(3);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 1;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 5;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 4;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 2;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 9;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 8;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 10;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 7;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 11;
		ab.inserir(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
		x = 12;
		ab.inserirPai(x);
		System.out.println("Num Elementos = " + ab.getNumElementos());
		System.out.println(" Lg2 (x) = " +	log2(x));
	
		System.out.println("Altura = "+ ab.getAltura());

		// ======================================================= //
		System.out.print("\n");
		System.out.println("Exercicio 2) ");

		System.out.println("Soma = " + ab.somar());

		// ======================================================= //
		System.out.print("\n");
		System.out.println("Exercicio 3) ");

		System.out.println("Num Pares = " + ab.getNumPares());

		// ======================================================= //
		System.out.print("\n");
		System.out.println("Exercicio 4) ");

		ArvoreBinaria primeira = new ArvoreBinaria();
		ArvoreBinaria segunda = new ArvoreBinaria();

		// Teste1
		boolean isIguais = ArvoreBinaria.isIguais(primeira, segunda);

		System.out.println("#teste1 isIguais = " + isIguais);

		// Teste2
		segunda.inserir(3);
		primeira.inserir(1);
		primeira.inserir(3);
		segunda.inserir(1);
		
		isIguais = ArvoreBinaria.isIguais(primeira, segunda);

		System.out.println("#teste2 isIguais = " + isIguais);

		// ======================================================= //
		System.out.print("\n");
		System.out.println("Exercicio 5) ");

		ArvoreBinaria teste5 = new ArvoreBinaria();

		boolean hasDivisivel11 = teste5.hasDivisivel11();

		System.out.println("#teste1 hasDivisivel11 = "+ hasDivisivel11);

		teste5.inserir(22);

		hasDivisivel11 = teste5.hasDivisivel11();

		System.out.println("#teste2 hasDivisivel11 = "+ hasDivisivel11);

		// ======================================================= //
		System.out.println("Exercicio 6) ");

		System.out.println("#teste1");

		ArrayList<Integer> elementosOrdenados = ab.treeSort();

		System.out.println("#teste2 - com o objeto ArrayList retornado");
		System.out.print ("[ ");
		for(int i : elementosOrdenados) {
			System.out.print(i + " ");
		}
		System.out.print ("]\n");

		// ======================================================= //
		System.out.print("\n");
		System.out.println("Exercicio 7) ");

		ListaDupla listaDupla = new ListaDupla();

		listaDupla.inserirInicio(3);
		listaDupla.inserirInicio(7);
		
		listaDupla.inserirFim(10);
		listaDupla.inserirFim(15);
		
		listaDupla.inserir(25, 1);
		listaDupla.inserir(30, 1);
		listaDupla.inserir(40, 2);
		listaDupla.removerInicio();
		listaDupla.removerFim();
		System.out.println("Lista Dupla : ");
		listaDupla.mostrar();

		ListaSimples listaSimples = new ListaSimples();

		listaSimples.inserirInicio(1);
		listaSimples.inserirFim(4);
		listaSimples.inserir(41, 1);
		listaSimples.inserir(20, 2);
		listaSimples.inserirFim(2);
		listaSimples.inserir(5, 1);
		System.out.println("Lista Simples : ");
		listaSimples.mostrar();

		ArvoreBinaria teste7 = new ArvoreBinaria();
		teste7.raiz = ArvoreBinaria.toArvoreBinaria(listaSimples.primeiro.prox, listaDupla.primeiro.prox);
	
		System.out.println("Arvore Intercalada (Caminhar Central): ");
		teste7.caminharCentral();

		// ======================================================= //
		System.out.print("\n");
	}
}
