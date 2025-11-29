public class Cliente {

    private int cpf; // PRIVATE
    private int telefone; // PRIVATE
    private String nome; // PRIVATE
    private String email; // PRIVATE

    // CONSTRUTOR OBRIGATÓRIO (Resolve o erro de 0 argumentos)
    public Cliente(int cpf, int telefone, String nome, String email) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
    }

    // GETTERS (Acesso seguro aos dados privados)
    public int getCpf() { return cpf; }
    public int getTelefone() { return telefone; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    // SETTER para o nome (se necessário, para alterar depois de criado)
    public void setNome(String nome) {
        this.nome = nome;
    }
}