public class Loja {

    private static Loja instancia; //singleton
    private String nomeLoja;
    private String local;

    private infoEstoque gerenciadorEstoque;
    private GerenciadorDeClientes gerenciadorClientes;
    private GerenciadorDeVendas gerenciadorVendas;

    //construtor privado
    private Loja(String nomeL, String localL) {
        this.nomeLoja = nomeL;
        this.local = localL;

        this.gerenciadorEstoque = new infoEstoque();
        this.gerenciadorClientes = new GerenciadorDeClientes();
        this.gerenciadorVendas = new GerenciadorDeVendas();

        System.out.println("Loja '" + nomeL + "' aberta em " + localL + " (Singleton inicializado).");
    }

    public static Loja getInstance(String nomeL, String localL) {
        if (instancia == null) {
            instancia = new Loja(nomeL, localL);
        }
        return instancia;
    }

    public void adicionarCarroAoEstoque(Carro carro) {
        this.gerenciadorEstoque.adicionarCarro(carro);
    }

    public void listarEstoqueDaLoja() {
        this.gerenciadorEstoque.listarEstoque();
    }

    public boolean removerCarroDoEstoque(int idCarro) {
        return this.gerenciadorEstoque.removerCarro(idCarro);
    }

    public infoEstoque getGerenciadorEstoque() { return gerenciadorEstoque; }
    public GerenciadorDeClientes getGerenciadorClientes() { return gerenciadorClientes; }
    public GerenciadorDeVendas getGerenciadorVendas() { return gerenciadorVendas; }

    public void exibirInfo() {
        System.out.println("\n--- INFORMAÇÕES DA LOJA ---");
        System.out.println("Nome: " + nomeLoja);
        System.out.println("Local: " + local);
        System.out.println("---------------------------");
    }
}
