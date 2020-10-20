class testSplit {

    public static void main (String[] args)
    {
        String s = "25,Diogo Araujo,175,70,PUC,1288,BH,MG";
        String[] newS = new String[8];

        for(int i = 0; i < newS.length; i++) newS[i] = "nao informado";

        String[] aux = s.split(","); 

        for(int i = 0; i < aux.length; i++) newS[i] = aux[i];

        for(int i = 0; i < newS.length; i++) if(newS[i].equals("")) newS[i] = "nao informado";

        for(int i = 0; i < newS.length; i++) System.out.println(newS[i]);

    }


}