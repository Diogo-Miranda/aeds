
class donaMonica{

    public static void main (String[] args)
    {
        int[][] entrada = new int[1000][3];
        int numEntrada = 0;
        int i = 0;
        boolean sair = false;
        do
        {
            i = 0;
            while(sair == false && i < 3)
            {
                entrada[numEntrada][i] = MyIO.readInt();
                if(entrada[numEntrada][0] == 0) sair = true;
                i++;
            }
            numEntrada++;

        } while(sair == false);

        numEntrada--; //retira a ultima entrada (fim)

        int idadeFilhoVelho;

        for(int m = 0; m < numEntrada; m++)
        {
            idadeFilhoVelho = 0;
            idadeFilhoVelho = entrada[m][0]- entrada[m][1] - entrada[m][2];
            MyIO.println(idadeFilhoVelho);
        }
    }
}