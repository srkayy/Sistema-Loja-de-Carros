import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeVendas {

    private List<venda> historicoVendas = new ArrayList<>();

    public void registrarVenda(venda novaVenda) {
        this.historicoVendas.add(novaVenda);
        System.out.println("Venda ID " + novaVenda.idVenda + " registrada no histórico.");
    }

    public double calcularLucroTotal() {
        double lucroTotal = historicoVendas.stream()
                .mapToDouble(v -> v.calculoFinal.lucro)
                .sum();
        return lucroTotal;
    }

    public void listarVendas() {
        if (historicoVendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }
        System.out.println("\n--- HISTÓRICO DE VENDAS ---");
        for (venda v : historicoVendas) {
            System.out.println("ID Venda: " + v.idVenda +
                    " | Cliente: " + v.cliente.getNome() +
                    " | Carro: " + v.carroVendido.getModeloCarro() +
                    " | Valor Final: R$" + String.format("%.2f", v.calculoFinal.valorFinal));
        }
    }
}