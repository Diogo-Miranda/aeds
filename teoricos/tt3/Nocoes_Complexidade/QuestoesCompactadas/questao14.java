class questao14 {

    public static void main (String[] args)
    {
        int i = 1, b = 10;
            
        int numSubtracoes = 0;

        while (i > 0) {
	        b--;
            numSubtracoes++;
	        i = i >> 1;
        }

        i = 0;
    
        System.out.println(numSubtracoes);

        while (i < 15) {
	        b--;
            numSubtracoes++;
	        i+= 2;
        }
        


        System.out.println(numSubtracoes);
    }

}
