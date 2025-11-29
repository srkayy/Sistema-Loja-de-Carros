import java.util.List;
import java.util.ArrayList;

public class CadastraCarro {

  ArrayList<Carro> listaCarros = new ArrayList<>();


  public void cadastrarCarro(String nome, int ano , double valor ,String cor , String modelo , int id){

    Carro novoCarro = new Carro(nome , ano , valor , cor , modelo , id);
    listaCarros.add(novoCarro);
  }                         
  
}

