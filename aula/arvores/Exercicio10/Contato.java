public class Contato {
    private String nome;
    private String telefone;
    private String email;
    private int CPF;

    public Contato(){
        this.nome = "";
        this.telefone = "";
        this.email = "";
        this.CPF = 0;
    }

    public Contato(String nome, String telefone, String email, int CPF) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.CPF = CPF;
    }  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }
}
