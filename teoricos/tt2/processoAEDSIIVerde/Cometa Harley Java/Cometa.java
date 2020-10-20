
class Cometa {

    public static int calculaAno(int ano)
    {
        int ultimaPassagem = 1986;
        
        while(ultimaPassagem <= ano)
        {
            ultimaPassagem  += 76;
        }

        if(ultimaPassagem == ano)
        {
            ultimaPassagem += 76;
        }

        return ultimaPassagem;
    }

    public static void main (String[] args)
    {
        int[][] entrada = new int[1000][1];
        int numEntrada = 0;

        do
        {
            entrada[numEntrada][0] = MyIO.readInt();
            numEntrada++;
        } 
        while(entrada[numEntrada-1][0] != 0);

        numEntrada--;

        int anoCometa;

        for(int m = 0; m < numEntrada; m++)
        {
            anoCometa = calculaAno(entrada[m][0]);
            MyIO.println(anoCometa);
        }
    }
}