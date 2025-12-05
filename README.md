```mermaid
---
config:
  layout: elk
  theme: redux-dark
---
classDiagram
    direction TD

    %% 4. Singleton (Loja) e Gerenciadores (Topo)
    class Loja {
        -static Loja instancia
        -InfoEstoque gerenciadorEstoque
        -GerenciadorDeVendas gerenciadorVendas
        -List~Cliente~ listaClientes
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

    %% 1. Entidades de Dados Principais (Meio)
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

    %% 2. Lógica e Cálculo / 1. Entidades de Suporte (Base)
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

    %% RELAÇÕES - Loja e Gerenciadores
    Loja ..> InfoEstoque : usa
    Loja ..> GerenciadorDeVendas : usa
    Loja "1" o-- "0..*" Cliente : GERENCIA 

    GerenciadorDeVendas "1" o-- "0..*" Venda : GERENCIA
    InfoEstoque "1" o-- "0..*" Carro : GERENCIA

    %% RELAÇÕES - Venda
    Venda "1" --> "1" Cliente : tem
    Venda "1" --> "1" Carro : vende
    Venda "1" --> "1" Pagamento : tem
    Venda "1" --> "1" CalculoPraVenda : usa
    Venda "1" --> "0..1" OrdemDeServico : pode incluir

    %% RELAÇÕES - OrdemDeServico
    OrdemDeServico "1" --> "1" Carro : é para
    OrdemDeServico "1" --> "1" Cliente : solicitada por
    OrdemDeServico "1" o-- "1..*" Servico : contém
