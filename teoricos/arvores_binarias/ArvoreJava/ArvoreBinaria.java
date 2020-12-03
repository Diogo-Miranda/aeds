import java.util.List;
import java.util.ArrayList;
import ListaDupla.*;
import ListaSimples.*;

class ArvoreBinaria {
	public No raiz;

	public ArvoreBinaria() {
		raiz = null;
	}
	
	/**
	 * Inserir elemento na árvore
	 * @param int elemento
	*/
	public void inserir(int x) throws Exception {
		raiz = inserir(x, raiz);
	}
	
	/**
	 * Inserir elemento na árvore
	 * @param int elemento
	 * @param No i
	 * @return No i
	*/
	public No inserir(int x, No i) throws Exception{
		// Verificar se eh nulo
		if(i == null) {
			i = new No(x);
		// Verificar se eh menor
		} else if (x < i.elemento) {
			i.esq = inserir(x, i.esq);
		// Verificar se eh maior
		} else if (x > i.elemento) {
			i.dir = inserir(x, i.dir);
		} else {
			throw new Exception("ERRO");
		}
		
		return i;	
	}

	/**
	 * Inserir um elemento de for iterativa
	 * @param int x
	*/
	public void inserirIterativo(int x) {
		No i = raiz;
		while(i != null) {
			if(x < i.elemento) {
				i = i.esq;
			} else if(x > i.elemento) {
				i = i.dir;
			} 
		}
		i = new No(x);	
	}

	/**
	 * Inserir elemento de acordo com o pai
	 * @param int x
	*/
	public void inserirPai(int x) throws Exception{
		
		if(raiz == null) {
			raiz = new No(x);
		} else if(x < raiz.elemento) {
			inserirPai(x, raiz.esq, raiz); 
		} else if(x > raiz.elemento) {
			inserirPai(x, raiz.dir, raiz);
		} else {
			throw new Exception("ERRO!");
		}
	}	

	private void inserirPai(int x, No i, No pai) throws Exception{
		if(i == null) {
			if(x < pai.elemento) {
				pai.esq = new No(x);	
			} else {
				pai.dir = new No(x);
			} 
		} else if (x < i.elemento) {
			inserirPai(x, i.esq, i);
		} else if (x > i.elemento) {
			inserirPai(x, i.dir, i);
		} else{
			throw new Exception("ERRO");
		}
	}

	public int getAltura() {	
		return getAltura(raiz)-1; // Pegar altura relativa á raiz		
	}

	private int getAltura(No i) {
			
		int alturaDir = 0,
			alturaEsq = 0,
			maior = 0;

		if(i != null) {
			alturaEsq = getAltura(i.esq);
			alturaDir = getAltura(i.dir);
			if(alturaEsq > alturaDir) maior = alturaEsq + 1;
				else maior = alturaDir + 1;
		}

		return maior;	
	}

	/**
	 * Método para mostrar a arvore de forma ordenada
	 * Mid-Order 
	 */
	public void caminharCentral() {
		System.out.print("\n[ ");
		caminharCentral(raiz);
		System.out.print("]");
	}

	/**
	 * Méroto privado para mostrar elementos 
	 * @param No i
	 */
	private void caminharCentral(No i) {
		if(i != null) {
			caminharCentral(i.esq); 
			System.out.print(i.elemento + " ");
			caminharCentral(i.dir);
		}
	}
	
	public int getNumElementos() {
		return getNumElementos(raiz); 
	}
	
	private int getNumElementos(No i) {
		int numElementos = 0;
		if(i != null) {
			numElementos++;
			numElementos += getNumElementos(i.esq);
			numElementos += getNumElementos(i.dir);
		}
		
		return numElementos;
	}

	public int somar() {
		return somar(raiz);
	}

	private int somar(No i) {
		int soma = 0;
		if(i != null) {
			soma += (i.elemento + somar(i.esq) + somar(i.dir));
		}
		return soma;
	}

	public int getNumPares() {
		return getNumPares(raiz);
	}

	private int getNumPares(No i) {
		int numPares = 0;

		if(i != null) {
			numPares += getNumPares(i.esq) + getNumPares(i.dir);
			if(i.elemento % 2 == 0) numPares++;
		}

		return numPares;
	}

	public static boolean isIguais(ArvoreBinaria primeira, ArvoreBinaria segunda) {
		return isIguais(primeira.raiz, segunda.raiz);
	}

	private static boolean isIguais(No x, No y) {
		boolean iguais = false;

		if(x != null && y != null) {
			iguais = (x.elemento == y.elemento) && isIguais(x.dir, y.dir) && isIguais(x.esq, y.esq);
		} else if (x == null && y == null) {
			iguais = true;
		}

		return iguais;
	}

	public boolean hasDivisivel11() {
		return hasDivisivel11(raiz);
	}

	private boolean hasDivisivel11(No i) {
		boolean isDivisivel = false;

		if(i != null) {
			isDivisivel = (i.elemento % 11 == 0) || hasDivisivel11(i.esq) || hasDivisivel11(i.dir);
		}	

		return isDivisivel;
	}

	public ArrayList<Integer> treeSort() {
		ArrayList<Integer> elementosOrdenados = new ArrayList<Integer>();

		System.out.print("[ ");
		treeSort(raiz, elementosOrdenados);
		System.out.print("]\n");

		return elementosOrdenados;
	}

	private void treeSort(No i, ArrayList<Integer> elementosOrdenados) {
		if(i != null) {
			treeSort(i.esq, elementosOrdenados);
			elementosOrdenados.add(i.elemento);
			System.out.print(i.elemento + " ");
			treeSort(i.dir, elementosOrdenados);
		}
	}

	public static No toArvoreBinaria(CedulaSimples cedulaSimples, CedulaDupla cedulaDupla) throws Exception {
		ArvoreBinaria ab = new ArvoreBinaria();
		
		CedulaSimples i = cedulaSimples;
		CedulaDupla j = cedulaDupla;


		while(i != null || j != null) {
			if(i != null) {
				ab.inserir(i.elemento);
				i = i.prox;
			}

			if(j != null) {
				ab.inserir(j.elemento);
				j = j.prox;
			}
		}
		
		return ab.raiz;
	}

	public void remover(int x) {
		remover(x, raiz);
	}

	private void remover(int x, No i, No j) throws Exception {
		if(i == null) {
			throw new Exception ("Erro!");
		} else if (x < i.elemento) {
			remover(x, i.esq);
		} else if (x > i.elemento) {
			remover(x, i.dir);
		} else if (i.dir == null) {
			i = i.esq;
		} else if (i.esq == null) {
			i = i.dir;
		} else {
			i.esq = anterior(i, i.esq);
		}

		return i;
	}

	private No anterior(No i, No j) {
		if (j.dir != null) {
			j.dir = anterior(i, j.dir);
		} else {
			i.elemento = j.elemento;
			j = j.esq;
		}

		return j;
	}

	/*
	public int somarIterativo() {
		return somarIterativo(raiz);
	}
	*/

	/*
	private int somarIterativo(No raiz) {
		No[] pilha = new No[getNumElementos()]; // Empilhar os elementos da árvore
		int pos = 0;

		int soma = 0;
		// Percorrer a árvore 
		pilha[pos++] = raiz;
		No y;
		while(pilha != null) {
			if(y.esq != null) {
				pilha[pos] = ;
			} else {
				
			}

		}

		return soma;
	}
	*/
}
