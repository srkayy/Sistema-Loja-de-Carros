import java.util.ArrayList;
import java.util.List;

public class venda {

    public int idVenda;
    public Cliente cliente;
    public Carro carroVendido;
    public List<Servico> servicosAdicionais;
    public CalculoPraVenda calculoFinal;
    public pagamento detalhesPagamento;

    public venda(int idVenda, Cliente cliente, Carro carroVendido, List<Servico> servicos) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.carroVendido = carroVendido;
        this.servicosAdicionais = (servicos != null) ? servicos : new ArrayList<>();
        this.calculoFinal = new CalculoPraVenda();
        this.detalhesPagamento = null;
    }

    public void calcularVenda(double lucroEsperado) {
        double totalServicos = servicosAdicionais.stream()
                .mapToDouble(s -> s.getValorServ()).sum(); // USANDO GETTER

        calculoFinal.calculoTotalServ((ArrayList<Servico>) servicosAdicionais);

        calculoFinal.lucro = lucroEsperado;
        calculoFinal.calculoPraVender(carroVendido.getValorCompra(), totalServicos); // USANDO GETTER
    }

    public void registrarPagamento(String tipoPagamento, int numeroParcelas) {
        if (calculoFinal.valorFinal <= 0) {
            System.out.println("ERRO: Valor final da venda não calculado.");
            return;
        }
        this.detalhesPagamento = new pagamento(calculoFinal.valorFinal, tipoPagamento, numeroParcelas);
        detalhesPagamento.exibirDetalhes();
    }

    public void exibirResumoVenda() {
        System.out.println("\n========= VENDA " + idVenda + " =========");
        System.out.println("CLIENTE: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")"); // USANDO GETTERS
        System.out.println("CARRO: " + carroVendido.getModeloCarro() + " (" + carroVendido.getAnoCarro() + ")"); // USANDO GETTERS

        System.out.println("VALOR FINAL: R$" + String.format("%.2f", calculoFinal.valorFinal));
        System.out.println("LUCRO: R$" + String.format("%.2f", calculoFinal.lucro) + " (" + String.format("%.2f", calculoFinal.margemLucro) + "%)");

        if (detalhesPagamento != null) {
            System.out.println("PAGAMENTO: " + detalhesPagamento.tipoPagamento);
        }
        System.out.println("===============================");
    }
}