import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeClientes {

    private List<Cliente> listaClientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente) {
        if (buscarClientePorCpf(cliente.getCpf()) == null) {
            this.listaClientes.add(cliente);
            System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso.");
        } else {
            System.out.println("ERRO: Cliente com CPF " + cliente.getCpf() + " já cadastrado.");
        }
    }

    public Cliente buscarClientePorCpf(int cpf) {
        return listaClientes.stream()
                .filter(c -> c.getCpf() == cpf)
                .findFirst()
                .orElse(null);
    }

    public void listarClientes() {
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE CLIENTES CADASTRADOS ---");
        for (Cliente cliente : listaClientes) {
            System.out.println("Nome: " + cliente.getNome() +
                    " | CPF: " + cliente.getCpf() +
                    " | Email: " + cliente.getEmail());
        }
    }
}