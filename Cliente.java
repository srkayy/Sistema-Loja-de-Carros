public class Cliente {

    private int cpf;
    private int telefone; 
    private String nome; 
    private String email; 

    public Cliente(int cpf, int telefone, String nome, String email) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
    }

    //acesso seguro aos dados privados
    public int getCpf() { return cpf; }
    public int getTelefone() { return telefone; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    //setter para o nome
    public void setNome(String nome) {
        this.nome = nome;
    }
}
