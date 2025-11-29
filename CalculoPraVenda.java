import java.util.ArrayList;

public class CalculoPraVenda {

    public double lucro;
    public double valorFinal;
    public double margemLucro;

    public void TodosServ(String descricao ,double valorServ , int idServico){

        ArrayList<Servico> servicoFeitos = new ArrayList<>();

        Servico valorDoServico = new Servico(descricao ,valorServ ,idServico);

        servicoFeitos.add(valorDoServico);
    }

    public void calculoTotalServ(ArrayList<Servico> servicosFeito){

        double total = servicosFeito.stream()
                .mapToDouble(s -> s.getValorServ()).sum(); // USANDO GETTER

        System.out.println(" TOTAL DE SERVIÇOS " + total);
    }

    public void calculoPraVender(double valorCompra , double total){
        valorFinal = valorCompra + total + lucro ;
        margemLucro = (lucro / valorFinal) * 100;
    }
}