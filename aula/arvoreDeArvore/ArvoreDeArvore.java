class NoChar {
	char elemento;
	NoChar dir;
	NoChar esq;
	NoString noString;

	NoChar(char elemento) {
		this.elemento = elemento;
		noString = null;
		this.dir = null;
		this.esq = null;
	}
}

class NoString {
	String elemento;
	NoString dir;
	NoString esq;

	NoString(String elemento) {
		this.elemento = elemento;
		this.dir = null;
		this.esq = null;
	}
}

public NoString inserirPalavra(String p, NoString i) 
{
	if(i == null) {
		i = inserir(p);
	} else if(i.elemento.compareTo(p) < 0) {
		i = inserirPalavra(p, i.dir);
	} else {
		i = inserirPalavra(p, i.esq);
	} 
	
	return i;
}	

public NoChar inserir(String p, NoChar i) 
{
	char c = p.charAt(0);
	if(i == null) {
		i = inserir(c);
	// Verificar se é igual
	} else if(i.elemento == c) {
		i = inserirPalavra(p, i.noString);
	} else if(i.elemento > c) {
		i = inserirPalavra(p, i.esq);
	} else {
		i = inserirPalavra(p, i.dir);
	}

	return i;
}

public boolean temString10(NoString i) 
{
	boolean resp = false;
	if(i != null) {
		resp = (i.elemento.length() == 10) || noString10(i.esq) || noString10(i.dir);
	}
	return resp;
}

public boolean temString10(NoChar i) 
{
	boolean resp = false;
	if(i != null) {
		resp = temString10(i.noString) || temString10(i.esq) || temString10(i.dir);
	}
	return resp;
}

public class ArvoreDeArvore {
	public static void main (String[] args) {
		
	}
}

