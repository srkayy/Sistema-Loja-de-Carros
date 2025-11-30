public class Carro {

    private String nomeCarro;
    private int anoCarro;
    private double valorCompra;
    private String corCarro;
    private String modeloCarro;
    private int idCarro;

    public Carro(String nome , int ano , double valor, String cor , String modelo , int id){
        this.nomeCarro = nome;
        this.anoCarro = ano;
        this.valorCompra = valor;
        this.corCarro = cor;
        this.modeloCarro = modelo;
        this.idCarro = id;
    }

    public String getNomeCarro() { return nomeCarro; }
    public int getAnoCarro() { return anoCarro; }
    public double getValorCompra() { return valorCompra; }
    public String getCorCarro() { return corCarro; }
    public String getModeloCarro() { return modeloCarro; }
    public int getIdCarro() { return idCarro; }
}
