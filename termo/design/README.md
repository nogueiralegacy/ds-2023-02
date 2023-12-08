# Design da aplicação

## Descrição
Um jogo voltado para a adivinhação de um país.
O jogo seleciona um país e o jogador tenta adivinhar o país com paupites. O jogo
fornece dicas para o jogador, referentes da comparação do país fornecido pelo jogador
e o país selecionado pelo jogo.

## Perguntas
- Como é feita a seleção do país pelo jogo?
- Quais são as dicas que o jogador vai receber a cada palpite?
- Quais são as dicas fornecidas pelo jogo?
- Como é feita a contagem de pontos?
- O jogador tem um limite de tentativas?

## Regras de negócio
- Um país é selecionado todo dia aleatorimente para ser jogado, 00:00
horário de brasília, é feita a seleção de um novo país, qualquer novo a partir 
desse horário deve ser referente ao novo país selecionado.
- A cada três messes os dados dos países são atualizados, caso tenham alguma mudança.

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

## Diagrama de classes

## Arquitetura

## Tecnologias