# Avaliação Desenvolvedor Back-end Attornatus
## Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  
- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Poder informar qual endereço é o principal da pessoa  

Uma Pessoa deve ter os seguintes campos:  
- Nome
- Data de nascimento
- Endereço:
- Logradouro
- CEP
- Número
- Cidade

### Requisitos  
Todas as respostas da API devem ser JSON  
Banco de dados H2

### Diferencial
Testes
Clean Code
 
### Será levado em avaliação 
Estrutura, arquitetura e organização do projeto  
Boas práticas de programação  
Alcance dos objetivos propostos.

## End points

<strong> (GET) lista de pessoas </strong> <br>

    http://localhost:8080/people
    
<strong> (GET) pessoa por id </strong> <br>

    http://localhost:8080/people/{id}
    
<strong> (GET) endereços de uma pessoa </strong> <br>

    http://localhost:8080/people/{id}/addresses
    
<strong> (POST) insere uma nova pessoa </strong> <br>

    http://localhost:8080/people

<strong> (POST) insere uma nova pessoa </strong> <br>

    http://localhost:8080/people
    
<strong> (PUT) altera dados de uma pessoa </strong> <br>

    http://localhost:8080/{id}

<strong> (GET) consulta todos os endereços </strong> <br>

    http://localhost:8080/address

<strong> (GET) consulta um endereço por id </strong> <br>

    http://localhost:8080/address/{id}

<strong> (POST) insere um novo endereço </strong> <br>

    http://localhost:8080/address
    
  
