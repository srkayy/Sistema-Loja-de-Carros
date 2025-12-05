```mermaid
---
config:
  layout: dagre
  theme: redux-dark
---
classDiagram
    direction TD
    class Loja {
        -static Loja instancia
        -InfoEstoque gerenciadorEstoque
        -GerenciadorDeVendas gerenciadorVendas
        -List~Cliente~ listaClientes  %% NOVA LISTA AQUI
        +static getInstance()
        +adicionarCarroAoEstoque()
        +cadastrarCliente()
        +buscarClientePorCpf()
    }
    class GerenciadorDeVendas {
        -List~Venda~ historicoVendas
        +registrarVenda()
    }
    class InfoEstoque {
        -List~Carro~ carrosEmEstoque
        +adicionarCarro()
        +removerCarro()
    }
    class Cliente {
        -int cpf
        -int telefone
        -String nome
        -String email
        +Cliente(cpf, tel, nome, email)
        +getNome()
    }
    class Carro {
        -String modeloCarro
        -int idCarro
        -double valorCompra
        +Carro(nome, ano, valor, cor, modelo, id)
        +getModeloCarro()
        +getValorCompra()
    }
    class Venda {
        +int idVenda
        +calcularVenda(lucro, totalServicos)
        +registrarPagamento()
        +exibirResumoVenda()
    }
    class OrdemDeServico {
        -int idOS
        -String statusOS
        +dataAbertura
        +calcularTotalServicos()
    }
    class Pagamento {
        +double valorTotal
        +String tipoPagamento
        +exibirDetalhes()
    }
    class Servico {
        -String descricao
        -double valorServ
        +getValorServ()
    }
    class CalculoPraVenda {
        +double lucro
        +double valorFinal
        +calculoPraVender()
    }
    Loja ..> InfoEstoque : usa
    Loja ..> GerenciadorDeVendas : usa
    Loja "1" o-- "0..*"

    GerenciadorDeVendas "1" o-- "0..*" Venda : GERENCIA
    InfoEstoque "1" o-- "0..*" Carro : GERENCIA
    Venda "1" --> "1" Cliente : tem
    Venda "1" --> "1" Carro : vende
    Venda "1" --> "1" Pagamento : tem
    Venda "1" --> "1" CalculoPraVenda : usa
    Venda "1" --> "0..1" OrdemDeServico : pode incluir
    OrdemDeServico "1" --> "1" Carro : é para
    OrdemDeServico "1" --> "1" Cliente : solicitada por
    OrdemDeServico "1" o-- "1..*" Servico : contém
