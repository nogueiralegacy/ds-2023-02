# Design da aplicação

## Descrição
Um jogo voltado para a adivinhação de um país.
O jogo seleciona um país e o jogador tenta adivinhar o país com palpites. O jogo
fornece dicas para o jogador, referentes da comparação do país fornecido pelo jogador
e o país selecionado pelo jogo.

## Perguntas
- DESCRIÇÃO DO SISTEMA
- Como é feita a seleção do país pelo jogo?
- Quais são as dicas que o jogador vai receber a cada palpite?
- Quais são as dicas fornecidas pelo jogo?
- Como é feita a contagem de pontos?
- O jogador tem um limite de tentativas?

## Regras de negócio
- O jogo é feito para brasileiros.
- Um país é selecionado todo dia aleatorimente para ser jogado, 00:00
horário de brasília, é feita a seleção de um novo país, qualquer palpite novo a partir 
desse horário deve ser referente ao novo país selecionado.
- A cada três messes os dados dos países são atualizados, caso tenham alguma mudança.
- O usuário ter de ter conexão com a internet.
- O usuário pode jogar acertar o país do dia apenas uma vez.

## Requisitos
### Funcionais
| ID | Descrição | 
| ------------- | ------------- |
| 001 | O sistema deve ser capaz de selecionar um país aleatoriamente, diariamente.  |
| 002 | O sistema deve ser capaz de receber um país como palpite.  |
| 003 | O sistema deve ser capaz de retornar se o jogador acertou ou errou o palpite.  |
| 004 | O sistema deve ser capaz de retornar dicas para o jogador, por meio da comparação do palpite recebido e do país selecionado. |
| 005 | O sistema deve ser capaz de contabilizar quantas pessoas acertaram o país. |
| 006 | O sistema deve ser capaz de contabilizar quantos palpites foram feitos. |
| 007 | O sistema deve ser capaz de fornecer para o usuário uma lista de todos os países que estão participando do jogo. |
| 008 | O sistema deve ser capaz de fornecer o país selecionado no dia anterior. |

---

### Não Funcionais  
| ID | Descrição | 
| ------------- | ------------- |
| 001 | O sistema deve ser capaz de suportar mais de 1000 usuários simultâneos. |
| 002 | O sistema deve ser capaz de suportar mais de 1000 palpites por segundo. |
| 003 | O sistema deve suportar mudanças dos dados dos países sem a necessidade de parar o sistema. |
| 004 | O sistema deve ser capaz de suportar ataques de negação de serviço. |

## Casos de uso

![usecase](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/nogueiralegacy/ds-2023-02/main/termo/image/plantuml/usecase.puml)

- Palpitar: ação do usuário que seleciona um país, de sua escolha, e envia para o jogo como tentativa de acertar o país do dia.

- Responder: ação do jogo que retorna a resposta de cada palpite do usuário, indicando se o usuário acertou ou não, caso o usuário tiver errado é fornecido a comparação do país que ele palpitou com o país do dia.

## Dados releventas da perspectiva do usuário para adivinhar um país
![userview](/termo/image/pais.png)

# Modelo de dados
![modelo de dados país](/termo/image/DER-new.png)

## Arquitetura
![entidades](/termo/image/Entidades.png)

- A API recebe apenas a entidade país, através de um endpoint, e retorna apenas a entidade comparação. Para a primeira entidade recebemos o identificador único do país que é conhecido pelo auto complete da interface, a partir do nome do país. E para a segunda, respondemos para o cliente todos os atributos de país e qual o seu nível de semelhança entre país do dia versus país palpitado.

## Tecnologias
- Java
- Spring-Boot Web

## Decisões
- A API é responsável por fazer a comparação do país palpitado com o país do dia. 

- A implementação escolhida foi uma implementação server-side com o cliente comunicando com o servidor através de requisições HTTP. Ao utilizar tal implementação o usuário fica dependente de uma conexão estável com a internet para que possa utilizar o sistema sem nenhum problema além da manutenção do servidor que hospedará a aplicação. Para contrabalancear, a implementação permite uma centralização dos serviços o que fornece uma maior facilidade de manutenção e escalabilidade dinâmica, permite também a utilização de serviços externos em futuras atualizações como fontes externas de dados ou monetização com anúncios.

- Tecnologias  

Para implementar utilizando Spring Boot e servidores em nuvem, primeiramente desenvolveria a lógica do jogo e endpoints no Spring Boot para gerenciar as requisições dos usuários, incluindo a lógica de sorteio diário de países e fornecimento de dicas. Em seguida, utilizaria serviços de nuvem, como por exemplo  AWS, Google Cloud ou Azure para hospedar o aplicativo Spring Boot. Utilizaria recursos de balanceamento de carga e autoescalonamento dos serviços em nuvem para lidar com picos de tráfego, assegurando assim uma infraestrutura escalável e confiável para suportar o jogo de adivinhação diária dos países.

- Armazenamento dos dados em JSON  

Decidimos pela não utilização de nehum SGBD, guardando todos os dados necessários em um arquivo JSON. Optamos pelo JSON por se tratar de uma baixa quantidade de dados, sem perspectiva de alteração nesse fator, portabilidade e compatibilidade universal.
