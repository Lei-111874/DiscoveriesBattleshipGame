# Battleship

# GrupoTP05_LEI-2

## Alunos LEI

| Alunos              | Números |
|----------------------|---------|
| Fábio do Rosário     | 111874  |
| Afonso Silva         | 122697  |
| Hugo Furtado         | 110801  |

Versão acadêmica básica do jogo Batalha Naval para usar como base.

## Regras do Jogo

### 1. Preparação e Posicionamento
* **Tabuleiros:** Cada jogador começa com duas grelhas quadriculadas de **10x10** (linhas de `0` a `9` e colunas de `0` a `9`). Uma grelha representa **"o seu mar"** e a outra **"o mar do adversário"**.
* **Orientação:** Os navios são posicionados na grelha própria na orientação **horizontal** ou **vertical**, ocultos da vista do adversário.
* **Restrições de Posicionamento:** Os navios **não podem tocar-se entre si** (nem mesmo na diagonal), mas podem ficar encostados às bordas da grelha.

### 2. Mecânica de Jogo (Turnos)
* **Rajada de Tiros:** Depois de ambas as frotas estarem posicionadas, os jogadores jogam à vez. Em cada turno, o jogador dispara uma **rajada de 3 tiros** sobre a frota adversária, indicando as respetivas coordenadas `(linha, coluna)`.
* **Relatório de Danos:** O adversário informa o resultado da rajada de 3 tiros, indicando:
  * Quantos tiros caíram na **água**;
  * Se acertou num ou mais navios e **de que tipo** são;
  * Se algum navio foi completamente **afundado**.
* **Registo:** Cada jogador regista na sua grelha de controlo ("mar do adversário") o histórico dos seus tiros e os navios inimigos já afundados.

### 3. Condição de Vitória
* Vence a partida o primeiro jogador que conseguir atingir e **afundar todos os navios** da frota adversária.


## Tipos de Navios

Neste projeto usamos uma versão do jogo Batalha Naval ambientada na época dos Descobrimentos (*Discoveries Battleship Game*), em que os navios tradicionais são substituídos por embarcações da altura.

A correspondência entre os navios da Batalha Naval clássica e os da versão dos Descobrimentos é a seguinte:

| Batalha Naval        | Descobrimentos | English  | Dimensão | Nº Navios |
|-----------------------|-----------------|----------|----------|-----------|
| Porta-aviões          | Galeão          | Galleon  | 5        | 1         |
| Navio de 4 canhões    | Fragata         | Frigate  | 4        | 1         |
| Navio de 3 canhões    | Nau             | Carrack  | 3        | 2         |
| Navio de 2 canhões    | Caravela        | Caravel  | 2        | 3         |
| Submarino             | Barca           | Barge    | 1        | 4         |

Cada jogador posiciona a sua frota completa (11 navios no total) numa grelha 10x10, seguindo orientação horizontal ou vertical, sem que os navios se toquem entre si (embora possam estar encostados à borda da grelha).
