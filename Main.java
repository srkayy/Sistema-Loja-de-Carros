public class Main {

    public static void main(String[] args) {

        System.out.println("--- INICIANDO SISTEMA DE GESTÃO DA LOJA ---");

        // obtém a instância única da loja
        Loja lojaSingleton = Loja.getInstance("Concessionária Rápida", "Av. Principal, 456");
        lojaSingleton.exibirInfo();
        
        Carro c1 = new Carro("Sedan X", 2020, 50000.00, "Prata", "Modelo A", 101);
        Carro c2 = new Carro("SUV Y", 2023, 85000.00, "Preto", "Modelo B", 102);

        lojaSingleton.adicionarCarroAoEstoque(c1);
        lojaSingleton.adicionarCarroAoEstoque(c2);

        lojaSingleton.listarEstoqueDaLoja();

        System.out.println("\n--- TESTANDO SINGLETON ---");
        Loja outraReferencia = Loja.getInstance("Parâmetros Ignorados", "Local Ignorado");

        System.out.println("ID Loja 1: " + lojaSingleton.hashCode());
        System.out.println("ID Loja 2: " + outraReferencia.hashCode());
        System.out.println("As referências são a mesma instância? " + (lojaSingleton == outraReferencia));

        outraReferencia.listarEstoqueDaLoja();

        System.out.println("\n--- REMOVENDO CARRO ---");
        boolean removido = lojaSingleton.removerCarroDoEstoque(101);
        System.out.println("Carro 101 removido: " + removido);
        lojaSingleton.listarEstoqueDaLoja();

        Cliente cliente = new Cliente(111222333, 999887766, "João da Silva", "joao@email.com");

        Servico servico1 = new Servico("Lavagem Detalhada", 200.00, 1);
        Servico servico2 = new Servico("Polimento", 500.00, 2);

        venda novaVenda = new venda(1, cliente, c2, java.util.Arrays.asList(servico1, servico2));

        novaVenda.calcularVenda(15000.00);

        novaVenda.registrarPagamento("Financiamento", 36);

        novaVenda.exibirResumoVenda();

        lojaSingleton.getGerenciadorClientes().cadastrarCliente(cliente);
        lojaSingleton.getGerenciadorVendas().registrarVenda(novaVenda);

        System.out.println("\n--- RELATÓRIO FINAL ---");
        lojaSingleton.getGerenciadorVendas().listarVendas();
    }
}
