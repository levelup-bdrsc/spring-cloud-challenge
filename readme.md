# Level Up Week 1 

## Objetivo do projeto

Nessa semana temos como objetivo aprender um pouco mais sobre sistemas distribuídos, troca de informações entre sistemas e quais são as ferramentas que temos disponíveis para nos ajudar nesse processo.

## Arquitetura inicial do projeto

![](images/arquitetura-caelum-eats.png)

### Explicando a ideia de cada serviço

Aqui estamos dando inicio a uma plataforma de delivery de comida, atualmente essa nossa plataforma é composta de 3 serviços, sendo eles:

- Monolito
    Responsável por armazenar informações dos contextos de: *restaurante*, *pedido*, *administrativo*.

    - Restaurante
        Aqui vamos ter todas as informações relacionado ao restaurante como: cardápio, informações gerais do restaurante e etc.
    
    - Pedido
        Aqui vamos ter todas as informações relacionadas ao pedido como: entrega, valor do pedido, cliente e etc.
    
    - Administrativo
        Aqui vamos ter todas as informações auxiliares para plataforma funcionar como por exemplo: Quais os tipos de pagamentos que iremos aceitar, quais são os tipos de restaurantes e categorias que queremos.

- Pagamento
    Aqui é o nosso serviço responsável por toda lógica e processamento de pagamentos e terá interação com o nosso serviço de monólito.

- Distância
    Aqui é o nosso serviço responsável por toda lógica de localizar qual é o restaurante mais próximo de um cep e região próxima.

Ao decorrer da semana iremos evoluir esse projeto e sua arquitetura e irão aparecer novos componentes o que estamos documentando aqui é apenas o nosso processo inicial do projeto.


## Ferramentas necessárias para o projeto

- Git
- Java com JDK 8 ou 11
- Maven
- Postman
- IDE da sua preferência

[Aqui temos um guia sobre como instalar as informações acima caso necessário](https://github.com/caelum/apostila-microservices-com-spring-cloud/blob/master/05-integracao-sincrona.md#cliente-rest-com-resttemplate-do-spring)

## Exemplo das requisições

Esse nosso projeto não tem um frontend, então iremos lidar e fazer bastante requisições para os nossos serviços utilizando o postman, visando deixar esse processo mais fácil e tranquilo de se realizar, estamos disponibilizando uma coleção de requisições para cada um desses serviços que descrevemos acima.

Com esse link: https://www.getpostman.com/collections/f831e44a71611d5445ca

Você pode seguir o passo a passo desse vídeo:

![](https://recordit.co/ytJVljCl5h.gif)


## Ponto de atenção

Todos os serviços utilizam o h2 como banco de dados, que é um banco de dados em memória, isso significa que todos que toda vez que reiniciar o serviço os dados serão perdidos.

Para acessar a console do h2, basta seguir os passos:

1. {url-do-service}:{porta-do-servico}/h2-console
2. As crendiciais são:
    1. jdbc:h2:mem:{nome-do-servico} (url)
    2. sa (username)
    3. password (senha)

Agora é só estudar e tirar suas dúvidas com o mentor!!!