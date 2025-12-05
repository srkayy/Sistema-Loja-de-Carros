---
config:
  layout: elk
  theme: redux-dark
---
classDiagram
    direction TD 
    
    %% 1. Entidades de Dados (Encapsuladas)
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
    class Pagamento {
        +double valorTotal
        +String tipoPagamento
        +exibirDetalhes()
    }
    
    %% Nova Classe: Ordem de Serviço
    class OrdemDeServico {
        -int idOS
        -String statusOS
        +dataAbertura
        +calcularTotalServicos()
    }

    %% 2. Lógica e Cálculo
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

    %% 3. Gerenciadores
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

    %% 4. Singleton (Loja)
    class Loja {
        -static Loja instancia
        -InfoEstoque gerenciadorEstoque
        -GerenciadorDeClientes gerenciadorClientes
        -GerenciadorDeVendas gerenciadorVendas
        +static getInstance()
        +adicionarCarroAoEstoque()
        +getGerenciadorClientes()
    }

    %% RELAÇÕES (Associações e Agregações)
    
    %% Venda
    Venda "1" --> "1" Cliente : tem
    Venda "1" --> "1" Carro : vende
    Venda "1" --> "1" CalculoPraVenda : usa
    Venda "1" --> "1" Pagamento : tem
    Venda "1" --> "0..1" OrdemDeServico : pode incluir (Serviços adicionais)

    %% OrdemDeServico (A chave para a realidade de serviços)
    OrdemDeServico "1" --> "1" Carro : é para
    OrdemDeServico "1" o-- "1..*" Servico : contém (Agregação de 1 ou mais serviços)
    OrdemDeServico "1" --> "1" Cliente : solicitada por
    
    %% Loja (Controle)
    Loja ..> InfoEstoque : usa (Gerencia)
    Loja ..> GerenciadorDeClientes : usa (Gerencia)
    Loja ..> GerenciadorDeVendas : usa (Gerencia)

    %% Gerenciadores (Agregação)
    GerenciadorDeClientes "1" o-- "0..*" Cliente : GERENCIA
    GerenciadorDeVendas "1" o-- "0..*" Venda : GERENCIA
    InfoEstoque "1" o-- "0..*" Carro : GERENCIA
