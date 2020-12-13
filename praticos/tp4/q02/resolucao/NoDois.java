class NoDois {
	public String elemento;
	public NoDois esq;
	public NoDois dir;
		
	public NoDois() {
		this("vazio");
	}

	public NoDois(String elemento) {
		this.elemento = elemento;
		this.esq = null;
		this.dir = null;
	}
}
