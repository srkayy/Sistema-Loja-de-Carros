public class pagamento {

    public double valorTotal;
    public String tipoPagamento;
    public int numeroParcelas;

    public pagamento(double valorTotal, String tipoPagamento, int numeroParcelas) {
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
        this.numeroParcelas = Math.max(1, numeroParcelas);
    }

    public void exibirDetalhes() {
        System.out.println("\n--- DETALHES DO PAGAMENTO ---");
        System.out.println("Valor Total: R$" + String.format("%.2f", valorTotal));
        System.out.println("Tipo: " + tipoPagamento);

        if (numeroParcelas > 1) {
            System.out.println("Parcelas: " + numeroParcelas + " x R$" + String.format("%.2f", valorTotal / numeroParcelas));
        } else {
            System.out.println("Pagamento à Vista.");
        }
    }
}