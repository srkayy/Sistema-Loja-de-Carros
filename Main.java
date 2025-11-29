public class Main {

    public static void main(String[] args) {

        System.out.println("--- INICIANDO SISTEMA DE GESTÃO DA LOJA ---");

        // 1. Obtém a instância única da Loja (Singleton)
        Loja lojaSingleton = Loja.getInstance("Concessionária Rápida", "Av. Principal, 456");
        lojaSingleton.exibirInfo(); // Chamada válida após a correção da Loja

        // 2. Cria um carro (dados do Carro para Compra/Estoque)
        // Carro(nome, ano, valorCompra, cor, modelo, id)
        Carro c1 = new Carro("Sedan X", 2020, 50000.00, "Prata", "Modelo A", 101);
        Carro c2 = new Carro("SUV Y", 2023, 85000.00, "Preto", "Modelo B", 102);

        // 3. Adiciona os carros usando a instância da Loja
        lojaSingleton.adicionarCarroAoEstoque(c1);
        lojaSingleton.adicionarCarroAoEstoque(c2);

        // 4. Lista o estoque atual (através da Loja)
        lojaSingleton.listarEstoqueDaLoja();

        // 5. Teste do Singleton
        System.out.println("\n--- TESTANDO SINGLETON ---");
        Loja outraReferencia = Loja.getInstance("Parâmetros Ignorados", "Local Ignorado");

        System.out.println("ID Loja 1: " + lojaSingleton.hashCode());
        System.out.println("ID Loja 2: " + outraReferencia.hashCode());
        System.out.println("As referências são a mesma instância? " + (lojaSingleton == outraReferencia));

        outraReferencia.listarEstoqueDaLoja();

        // --- Exemplo de Remoção ---
        System.out.println("\n--- REMOVENDO CARRO ---");
        boolean removido = lojaSingleton.removerCarroDoEstoque(101);
        System.out.println("Carro 101 removido: " + removido);
        lojaSingleton.listarEstoqueDaLoja();

        // --- Exemplo de Venda ---

        // CORRIGIDO: Cria o Cliente usando o construtor com 4 argumentos
        Cliente cliente = new Cliente(111222333, 999887766, "João da Silva", "joao@email.com");

        // Simulação: Serviços Adicionais (Lavagem e Polimento)
        Servico servico1 = new Servico("Lavagem Detalhada", 200.00, 1);
        Servico servico2 = new Servico("Polimento", 500.00, 2);

        // Cria a Venda com o carro remanescente (c2)
        venda novaVenda = new venda(1, cliente, c2, java.util.Arrays.asList(servico1, servico2));

        // Calcula a venda com um lucro esperado de R$ 15.000,00
        novaVenda.calcularVenda(15000.00);

        // Registra o pagamento
        novaVenda.registrarPagamento("Financiamento", 36);

        // Exibe o resumo
        novaVenda.exibirResumoVenda();

        // Exemplo final: Adicionar o cliente e a venda aos gerenciadores
        lojaSingleton.getGerenciadorClientes().cadastrarCliente(cliente);
        lojaSingleton.getGerenciadorVendas().registrarVenda(novaVenda);

        System.out.println("\n--- RELATÓRIO FINAL ---");
        lojaSingleton.getGerenciadorVendas().listarVendas();
    }
}