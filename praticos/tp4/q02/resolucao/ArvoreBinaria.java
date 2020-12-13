class ArvoreBinaria {
	public NoUm raiz;

	public ArvoreBinaria() {
		raiz = null;
	}
	
	/**
	 * Metodo para pesquisar um elemento na arvore a partir de uma chave
	 * @param String chave - chave de pesquisar
	 * @return boolean - retorna true se o elemento for encontrado
	*/
	public boolean pesquisar(String chave) throws Exception {
		System.out.print(chave + " ");
		System.out.print("raiz ");
		return pesquisar(chave, raiz);
	}

	/**
	 * Metodo recursivo para pesquisar um valor em uma arvore binaria
	 * @param String chave - chave a ser pesquisada
	 * @param NoUm i - No atual a ser pesquisar
	 * @return boolean resp - retorna true se o elemento for encontrado
	*/ 
	private boolean pesquisar(String chave, NoUm i) throws Exception {
		boolean resp = false;
		
		if(i != null) {
			resp = pesquisarSegundaArvore(chave, i.noDois);
			System.out.print("esq ");
			resp = resp || pesquisar(chave, i.esq);
			System.out.print("dir ");
		    resp = resp || pesquisar(chave, i.dir);
		}

		return resp;
	}

	private boolean pesquisarSegundaArvore(String chave, NoDois i) throws Exception {
		boolean resp;

		if(i == null) {
			resp = false;
		} else if (chave.equals(i.elemento)) {
			resp = true;
		} else if (chave.compareTo(i.elemento) < 0) {
			System.out.print("ESQ ");
			resp = pesquisarSegundaArvore(chave, i.esq);
		} else {
			System.out.print("DIR ");
			resp = pesquisarSegundaArvore(chave, i.dir);
		}

		return resp;
	}

	public void inserir(Jogador jogador) throws Exception {
		raiz = inserir(jogador, raiz);
	}

	private NoUm inserir(Jogador jogador, NoUm i) throws Exception {
		int chave = jogador.getAltura() % 15;
			
		if(i == null) {
			i = new NoUm(chave);
		} else if(chave == i.elemento) {
			i.noDois = inserirSegundaArvore(jogador, i.noDois);
		} else if(chave < i.elemento) {
			i.esq = inserir(jogador, i.esq);
		} else if(chave > i.elemento) {
			i.dir = inserir(jogador, i.dir);
		}

		return i;
	}

	private NoDois inserirSegundaArvore(Jogador jogador, NoDois i) throws Exception {
		if(i == null) {
			i = new NoDois(jogador.getNome());
		} else if(jogador.getNome().compareTo(i.elemento) < 0) {
			i.esq = inserirSegundaArvore(jogador, i.esq);
		} else if(jogador.getNome().compareTo(i.elemento) > 0) {
			i.dir = inserirSegundaArvore(jogador, i.dir);
		} else {
			throw new Exception ("Erro ao inserir na segunda arvore");
		}

		return i;
	}

	/** 
	 * Método para inserir um elemento utilizando seu pai como referencia
	 * @param int elemento - elemento a ser inserido
	*/
	public void inserir(int elemento) throws Exception {
		if(raiz == null) {
			raiz = new NoUm(elemento);
		} else if (elemento < raiz.elemento) {
			inserir(elemento, raiz.esq, raiz);
		} else if (elemento > raiz.elemento) {
			inserir(elemento, raiz.dir, raiz);
		} else {
			throw new Exception("Erro ao inserir!");
		}
	}

	/**
	 * Metodo para inserir um elemento na arvore binaria utilizando seu pai como referencia
	 * @param int elemento - elemento a ser inserido
	 * @param NoUm i - no atual a ser comparado
	 * @param NoUm pai - no pai utilizado como referencia
	*/
	private void inserir(int elemento, NoUm i, NoUm pai) throws Exception {
		if(i == null) {
			if(elemento < pai.elemento) {
				pai.esq = new NoUm(elemento);
			} else {
				pai.dir = new NoUm(elemento);
			}
		} else if (elemento < i.elemento) {
			inserir(elemento, i.esq, i);
		} else if (elemento > i.elemento) {
			inserir(elemento, i.dir, i);
		} else {
			throw new Exception("Erro ao inserir!");
		}
	}
	
	public void caminharPre() {
		caminharPre(raiz);
	}

	private void caminharPre(NoUm i) {
		if(i != null) {
			System.out.println(i.elemento + " : ");
			System.out.print("[ ");
			caminharPreSegunda(i.noDois);
			System.out.print("]\n");
			caminharPre(i.esq);
			caminharPre(i.dir);
		}
	}

	private void caminharPreSegunda(NoDois i) {
		if(i != null) {
			System.out.print(i.elemento + "; ");
			caminharPreSegunda(i.esq);
			caminharPreSegunda(i.dir);
		}
	}

}
