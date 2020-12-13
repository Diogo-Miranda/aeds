
/**
 * Tabela Hash Direta com Área Reserva de 4 bytes
 * @author Diogo Araujo Miranda
 * Última alteração 11/12/2020
*/
class Hash {
	String tabelaHash[];
	private int tamanhoTabela;
	private int tamanhoReserva;

	/**
	 * Construtor sem parâmetros da tabela Hash
	*/
	public Hash() {
		this(13);
	}
	
	/**
	 * Construtor com parâmetros da tabela Hash
	 * @param int tamanhoTabela - tamanho da tabela
	*/
	public Hash(int tamanhoTabela) {
		this.tamanhoTabela = tamanhoTabela;
		this.tamanhoReserva = 4;
		tabelaHash = new String[tamanhoTabela + tamanhoReserva];

		for(int i = 0; i < tabelaHash.length; i++) {
			tabelaHash[i] = "";
		}
	}
	
	/**
	 * Método inserir Hash
	 * Possuí complexidade no melhor caso de O(1)
	 * @param String nome - nome a ser inserido
	*/ 
	public void inserir(String nome) {
		int pos = stringToInt(nome) % tamanhoTabela;
		System.out.println("Inserir na pos = " + pos);

		if(!tabelaHash[pos].equals("")) {
			int i = tamanhoTabela;
			boolean hasEspaco = false;
			while(!hasEspaco && i <= tamanhoReserva) {
				if(tabelaHash[i].equals("")) {
					hasEspaco = true;
					tabelaHash[i] = nome;
					System.out.println("Inserir na pos = " + i);
				} else {
					i++;
				}
			}

			if(!hasEspaco) {
				System.out.println("Não há espaço para inserção");
			}	
		} else {
			tabelaHash[pos] = nome;
		}
	}

	private int stringToInt(String string) {
		int out = 0;

		for(int i = 0; i < string.length(); i++) {
			out += string.charAt(i);
		}

		return out;
	}

	public void mostrar() {
		System.out.print("[ ");
		for(int i = 0; i < tamanhoTabela+tamanhoReserva; i++) {
			if(tabelaHash[i] != null) {
				System.out.print(tabelaHash[i] + "/ ");
			}
		}
		System.out.print("] \n");
	}

	public void remover(String nome) {
		int pos = stringToInt(nome) % tamanhoTabela;

		if(tabelaHash[pos].equals(nome)) {
			tabelaHash[pos] = "";	
		} else {
			int i = tamanhoTabela;
			boolean achou = false;
			while(!achou && i <= tamanhoReserva) {
				if(tabelaHash[i].equals(nome)) {
					achou = true;
					tabelaHash[i] = "";
				} else {
					i++;
				}
			}

			if(!achou) {
				System.out.println("Nome não encontrado");
			}
		}
	}

	public boolean pesquisar(String nome) {
		int pos = stringToInt(nome) % tamanhoTabela;
		boolean resp = false;

		if(tabelaHash[pos].equals(nome)) {
			resp = true; 
		} else {
			int i = tamanhoTabela;
			while(!resp && i <= tamanhoReserva) {
				if(tabelaHash[i].equals(nome)) {
					resp = true;
				} else {
					i++;
				}
			}
		}
		
		return resp;
	}
}

public class HashDireto_areaReserva {

	public static void main (String[] args) {
		Hash hash = new Hash(5);
		
		hash.inserir("Lau Zeny");
		hash.inserir("Diogo");
		hash.inserir("Erika");
		hash.inserir("Bolota");
		hash.inserir("Edna");
		//hash.inserir("Totão");
		//hash.inserir("Eita");
		hash.mostrar();
		hash.remover("Diogo");
		hash.mostrar();
		hash.inserir("vitin");
		System.out.println(hash.pesquisar("Bolota"));
		hash.inserir("Elenco");
		hash.mostrar();

	}
}
