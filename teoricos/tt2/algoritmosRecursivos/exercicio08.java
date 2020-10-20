class exercicio08 {

    public static boolean isPalindromo(char[] array, int tam, int i)
    {
        boolean resp = true;
        System.out.println(".");
        if(i < tam) {
            resp = isPalindromo(array, tam-1, i+1);
            if(array[i] != array[tam])
                resp = false;
        }else {
            if(array[i] == array[tam])
                resp = true;
        }

        return resp;
    }

    public static boolean isPalindromo(char[] array)
    {
        return isPalindromo(array, array.length-1, 0);
    }

    public static void main (String[] args)
    {
        char[] array = {'a', 'l', 'a'};
        System.out.println(isPalindromo(array));
    }
}
