class Palindromo{
	
	public static String invertePalavra(String s, int tamanho)
	{
		char[] inversa = new char[tamanho];

		int i = tamanho - 1;

		for(char c : s.toCharArray()) 
		{
			inversa[i] = c;
			i--;
		}

		String stringInversa = new String(inversa);

		return stringInversa;
	}

	public static boolean isPalindromo(String s)
	{
		String replace = s.replace(" ", ""); //Tira o espaço da palavra
		String palavraInversa = invertePalavra(replace, replace.length());

		boolean palindromo = false;
		
		if(replace.equals(palavraInversa)) 
		{
			palindromo = true;
		}

		return palindromo;
	}

	public static void imprimePalindromo(String s)
	{
		boolean palindromo = isPalindromo(s);

		if(palindromo)
		{
			MyIO.println("SIM");
		} 
		else
		{
			MyIO.println("NAO");
		}
	}

	public static boolean isFim(String s)
	{
		return (s.length() >= 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}

	public static void main (String[] args)
	{		
		String[] entrada = new String[10000000];
		int numEntrada = 0;

		do 
		{
			entrada[numEntrada] = MyIO.readLine();
		} 
		while (isFim(entrada[numEntrada++]) == false);
		numEntrada--; //Desconsidera a ultima entrada da palavra FIM

		boolean palindromo;

		for(int i = 0; i < numEntrada; i++)
		{
			palindromo = isPalindromo(entrada[i]);

			if(palindromo == true)
			{
				MyIO.println("SIM");
			}
			else
			{
				MyIO.println("NAO");
			}
		}
	}
}
