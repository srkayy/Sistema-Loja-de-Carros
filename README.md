```mermaid
---
config:
  layout: elk
  theme: redux-dark
---
classDiagram
    direction LR
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
    class Servico {
        -String descricao
        -double valorServ
        +getValorServ()
    }
    class pagamento {
        +double valorTotal
        +String tipoPagamento
        +exibirDetalhes()
    }
    class CalculoPraVenda {
        +double lucro
        +double valorFinal
        +calculoPraVender()
    }
    class venda {
        +int idVenda
        +calcularVenda(lucro)
        +registrarPagamento()
        +exibirResumoVenda()
    }
    class GerenciadorDeClientes {
        -List~Cliente~ listaClientes
        +cadastrarCliente()
        +buscarClientePorCpf()
    }
    class GerenciadorDeVendas {
        -List~venda~ historicoVendas
        +registrarVenda()
    }
    class infoEstoque {
        -List~Carro~ carrosEmEstoque
        +adicionarCarro()
        +removerCarro()
    }
    class Loja {
        -static Loja instancia
        -infoEstoque gerenciadorEstoque
        -GerenciadorDeClientes gerenciadorClientes
        -GerenciadorDeVendas gerenciadorVendas
        +static getInstance()
        +adicionarCarroAoEstoque()
        +getGerenciadorClientes()
    }
    venda "1" --> "1" Cliente : tem
    venda "1" --> "1" Carro : vende
    venda "1" --> "1" CalculoPraVenda : usa
    venda "1" --> "1" pagamento : tem
    venda "1" --> "0..*" Servico : inclui
    Loja ..> infoEstoque : usa (Gerencia)
    Loja ..> GerenciadorDeClientes : usa (Gerencia)
    Loja ..> GerenciadorDeVendas : usa (Gerencia)
    GerenciadorDeClientes "1" o-- "0..*" Cliente : GERENCIA
    GerenciadorDeVendas "1" o-- "0..*" venda : GERENCIA
    infoEstoque "1" o-- "0..*" Carro : GERENCIA
