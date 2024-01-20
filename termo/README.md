# Design da aplicação

## Descrição
Este é um jogo de adivinhação de países. O objetivo é que o jogador adivinhe um país específico. Durante o jogo, um país é escolhido aleatoriamente, e o jogador tenta adivinhar qual é por meio de palpites. O jogo oferece dicas para facilitar a experiência do jogador, relacionadas à comparação entre o país fornecido pelo jogador e o país escolhido aleatoriamente pelo jogo.

## Perguntas
- Como é feita a seleção do país pelo jogo?
  - O país é selecionado um por dia a partir da data do sistemas.
- Quais são as dicas que o jogador vai receber a cada palpite?
  - Todos os atributos de país (apresentado no modelo de dados)
- Como é feita a contagem de pontos?
  -  Pelo número de erros para cada acerto.
- O jogador tem um limite de tentativas?
  -  Não.

## Regras de negócio
- O jogo foi projetado para o público brasileiro.
- Todo dia, às 00:00 horário de Brasília, o jogo seleciona aleatoriamente um novo país para ser adivinhado.
- Qualquer palpite feito após esse horário deve ser referente ao novo país.
- A cada três meses, os dados dos países são atualizados para refletir possíveis mudanças.
- O usuário precisa ter uma conexão ativa com a internet para participar do jogo.
- O usuário pode fazer palpites para acertar o país do dia, mas tem direito a apenas uma acerto diário.

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

## Casos de uso

![usecase](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/nogueiralegacy/ds-2023-02/main/termo/image/plantuml/usecase.puml)

- Palpitar: ação do usuário que seleciona um país, de sua escolha, e envia para o jogo como tentativa de acertar o país do dia.

- Responder: ação do jogo que retorna a resposta de cada palpite do usuário, indicando se o usuário acertou ou não, caso o usuário tiver errado é fornecido a comparação do país que ele palpitou com o país do dia.

## Dados releventas da perspectiva do usuário para adivinhar um país
![userview](/termo/image/pais.png)

# Modelo de dados
![modelo de dados país](/termo/image/DER-new.png)

## Arquitetura
![c4](/termo/image/C4-Termo.png)

- A API recebe apenas como input o identificador de país, através de um endpoint chamado por um autocomplete, e retorna um JSON de comparação para o cliente.

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

- Update do país diário

![Diagrama em branco](https://github.com/nogueiralegacy/ds-2023-02/assets/75807715/8d3e77c6-2c34-480b-b3e5-b23c3990e7dd)


## Fluxo de Atividade

O usuário, através de uma caixa de texto, digitar o nome comum (nome pelo qual o país é conhecido informalmente) de um país dentre os 195 que fazem parte das nações unidas. Após preencher o nome corretamente com o auxílio de um Autocomplete, ele terá a opção de fazer um palpite com o país digitado, ao clicar no botão, o palpite é enviado. O conceito principal do jogo é fazer com que o usuário acerte o país escolhido pelo sistema (escolha essa feita de maneira arbitrária em um determinado horário) no menor número de tentativas possível. Após enviar o palpite o sistema recebe-o através de uma requisição HTTP e realiza a comparação de cada atributo do sistema entre o país palpitado pelo usuário e o selecionado pelo sistema, todos os atributos são não-subjetivos, ou seja, obrigatoriamente retornarão uma resposta objetiva e útil para o usuário (ex.: maior\menor | verdadeiro\falso).
O sistema após a comparação retornará um objeto que conterá a comparação de cada atributo e a partir dessas comparações o usuário poderá ter melhor noção do país alvo.

### Exemplo de Fluxo:
- O sistema realiza a escolha do país e o país alvo escolhido é o Togo, país esse fora do conhecimento do usuário
- O usuário realiza o seu primeiro palpite, digita na barra “Brasil” e clica em palpitar
- O sistema recebe o palpite e realiza a comparação dos atributos:
- Coordenadas (maior/menor): divididas em latitude e longitude, retorna para o usuário a disparidade de ambas, latitude e longitude do país palpitado com o país alvo.
- Presença de faixa litorânea (verdadeiro/falso): retorna para o usuário se o país palpitado possui a mesma presença de faixa litorânea que o país alvo. Ex: caso o país alvo possua faixa litorânea e o palpitado não ou vice versa, retorna para o usuário o valor falso, caso ambos possuam ou ambos não possuam, retorna verdadeiro
- Fronteiriço (verdadeiro/falso): retorna para o usuário verdadeiro caso o país palpitado faça fronteira com o país alvo, retorna
- Continente (verdadeiro/falso): retorna para o usuário verdadeiro caso o país palpitado esteja no mesmo continente que o país alvo, retorna falso caso contrário.
- Habitantes (maior/menor): retorna para o usuário a disparidade de habitantes entre o país palpitado e o país alvo
- Área (maior/menor): retorna para o usuário a disparidade da área do país palpitado com o país alvo
- IDH  (maior/menor): retorna para o usuário a disparidade do IDH do país palpitado com o país alvo.
- PIB (maior/menor): retorna para o usuário a disparidade do PIB do país palpitado com o país alvo.
- O sistema retorna as comparações citadas acima e através dela o usuário pode realizar um palpite mais preciso.
