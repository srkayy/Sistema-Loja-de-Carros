---
config:
  layout: elk
  theme: redux-dark
---

classDiagram
    direction TD 

    %% ============================
    %% 1. ENTIDADES PRINCIPAIS
    %% ============================

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

    class OrdemDeServico {
        -int idOS
        -String statusOS
        +dataAbertura
        +calcularTotalServicos()
    }

    %% ============================
    %% 2. PAGAMENTO / VENDA
    %% ============================

    class Pagamento {
        +double valorTotal
        +String tipoPagamento
        +exibirDetalhes()
    }

    class CalculoPraVenda {
        +double lucro
        +double valorFinal
        +calculoPraVender()
    }

    class Venda {
        +int idVenda
        +calcularVenda(lucro, totalServicos)
        +registrarPagamento()
        +exibirResumoVenda()
    }

    %% ============================
    %% 3. GERENCIADORES
    %% ============================

    class GerenciadorDeClientes {
        -List~Cliente~ listaClientes
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

    %% ============================
    %% 4. SINGLETON: LOJA
    %% ============================

    class Loja {
        -static Loja instancia
        -InfoEstoque gerenciadorEstoque
        -GerenciadorDeClientes gerenciadorClientes
        -GerenciadorDeVendas gerenciadorVendas
        +static getInstance()
        +adicionarCarroAoEstoque()
        +getGerenciadorClientes()
    }


    %% ============================
    %% RELACIONAMENTOS
    %% ============================

    %% Venda
    Venda "1" --> "1" Cliente : tem
    Venda "1" --> "1" Carro : vende
    Venda "1" --> "1" CalculoPraVenda : usa
    Venda "1" --> "1" Pagamento : pagamento
    Venda "1" --> "0..1" OrdemDeServico : inclui serviços

    %% Ordem de Serviço
    OrdemDeServico "1" --> "1" Carro : para
    OrdemDeServico "1" o-- "1..*" Servico : contém
    OrdemDeServico "1" --> "1" Cliente : solicitada por

    %% Gerenciadores
    GerenciadorDeClientes "1" o-- "0..*" Cliente : gerencia
    GerenciadorDeVendas "1" o-- "0..*" Venda : gerencia
    InfoEstoque "1" o-- "0..*" Carro : gerencia

    %% Loja controla tudo
    Loja ..> InfoEstoque : gerencia
    Loja ..> GerenciadorDeClientes : gerencia
    Loja ..> GerenciadorDeVendas : gerencia
