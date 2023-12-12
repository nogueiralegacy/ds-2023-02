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
- O jogo é feito para brasileiros
- Um país é selecionado todo dia aleatorimente para ser jogado, 00:00
horário de brasília, é feita a seleção de um novo país, qualquer palpite novo a partir 
desse horário deve ser referente ao novo país selecionado.
- A cada três messes os dados dos países são atualizados, caso tenham alguma mudança.
- O usuário ter de ter conexão com a internet

## Requisitos
- O sistema deve ser capaz de selecionar um país aleatoriamente, diariamente.
- O sistema deve ser capaz de receber um país como palpite.
- O sistema deve ser capaz de retornar se o jogador acertou ou errou o palpite.
- O sistema deve ser capaz de retornar dicas para o jogador, por meio da comparação do palpite recebido e do país selecionado. 
- O sistema deve ser capaz de contabilizar quantas pessoas acertaram o país.
- O sistema deve ser capaz de contabilizar quantos palpites foram feitos.
- O sistema deve ser capaz de fornecer para o usuário uma lista de todos os países que estão participando do jogo.
- O sistema deve ser capaz de fornecer o país selecionado no dia anterior.
---
- O sistema deve ser capaz de suportar mais de 1000 usuários simultâneos.
- O sistema deve ser capaz de suportar mais de 1000 palpites por segundo.
- O sistema deve suportar mudanças dos dados dos países sem a necessidade de parar o sistema.
- O sistema deve ser capaz de suportar ataques de negação de serviço.
---


## Casos de uso

![usecase](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/nogueiralegacy/ds-2023-02/main/termo/image/plantuml/usecase.puml)

- Palpitar: ação do usuário que seleciona um país, de sua escolha, e envia para o jogo como tentativa de acertar o país do dia.

- Responder: ação do jogo que retorna a resposta de cada palpite do usuário, indicando se o usuário acertou ou não, caso o usuário tiver errado é fornecido a comparação do país que ele palpitou com o país do dia.

## Dados releventas da perspectiva do usuário para adivinhar um país
![userview](/termo/image/pais.png)

# Modelo de dados
![modelo de dados país](/termo/image/DER.png)

## Arquitetura


## Tecnologias
- Java
- Spring-Boot Web
