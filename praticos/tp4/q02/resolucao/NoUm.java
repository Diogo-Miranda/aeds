class NoUm {
	int elemento;
	public NoUm esq;
	public NoUm dir;
	public NoDois noDois;

	public NoUm() {
		this(0);
	}

	public NoUm(int elemento) {
		esq = null;
		dir = null;
		this.elemento = elemento;
		noDois = null;
	}
}
