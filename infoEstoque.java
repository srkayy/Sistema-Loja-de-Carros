import java.util.ArrayList;
import java.util.List;

public class infoEstoque {

    private List<Carro> carrosEmEstoque = new ArrayList<>();

    public void adicionarCarro(Carro carro) {
        this.carrosEmEstoque.add(carro);
    }

    public boolean removerCarro(int idCarro) {
        Carro carroParaRemover = carrosEmEstoque.stream()
                .filter(c -> c.getIdCarro() == idCarro) // USANDO GETTER
                .findFirst()
                .orElse(null);

        if (carroParaRemover != null) {
            this.carrosEmEstoque.remove(carroParaRemover);
            return true;
        }
        return false;
    }

    public void listarEstoque() {
        if (carrosEmEstoque.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }
        System.out.println("--- ESTOQUE ATUAL ---");
        for (Carro carro : carrosEmEstoque) {
            System.out.println("ID: " + carro.getIdCarro() + " | Modelo: " + carro.getModeloCarro() + // USANDO GETTERS
                    " | Ano: " + carro.getAnoCarro() + " | Compra: R$" + String.format("%.2f", carro.getValorCompra())); // USANDO GETTERS
        }
    }

    public List<Carro> getCarrosEmEstoque() {
        return carrosEmEstoque;
    }
}