public class Servico {
    private String descricao;
    private double valorServ;
    private int idServico;

    public Servico (String descricao , double valorServ , int idservico){
        this.descricao = descricao;
        this.valorServ = valorServ;
        this.idServico = idservico;
    }

    public double getValorServ() { return valorServ; }
}