package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que define o contrato para a gestão de uma partida no jogo Discoveries Battleship.
 * <p>
 * Especifica as operações essenciais do ciclo de jogo, incluindo o disparo de tiros
 * sobre a grelha, a consulta de estatísticas da partida (tiros válidos, repetidos,
 * inválidos, certeiros, navios afundados e navios restantes) e a impressão do estado
 * do tabuleiro na consola.
 * </p>
 *
 * @author Hugo Furtado (110801)
 * @version 1.0
 * @see Game
 * @see IShip
 * @see IPosition
 */
public interface IGame {

    /**
     * Efetua um disparo sobre uma determinada posição da grelha adversária.
     *
     * @param pos a posição ({@link IPosition}) alvo do disparo
     * @return o navio ({@link IShip}) caso este tenha sido completamente afundado pelo disparo,
     *         ou {@code null} se o tiro cair na água, for inválido/repetido ou apenas atingir
     *         um navio sem o afundar totalmente
     */
    IShip fire(IPosition pos);

    /**
     * Devolve a lista de todas as posições onde foram efetuados tiros válidos.
     *
     * @return uma {@link List} de {@link IPosition} com as coordenadas dos tiros válidos
     */
    List<IPosition> getShots();

    /**
     * Devolve o número total de tiros repetidos (efetuados sobre coordenadas já atacadas).
     *
     * @return o total de tiros repetidos
     */
    int getRepeatedShots();

    /**
     * Devolve o número total de tiros inválidos (efetuados fora dos limites da grelha).
     *
     * @return o total de tiros inválidos
     */
    int getInvalidShots();

    /**
     * Devolve o número total de tiros certeiros que atingiram partes de navios.
     *
     * @return o total de acertos (hits)
     */
    int getHits();

    /**
     * Devolve o número total de navios da frota que já foram completamente afundados.
     *
     * @return o total de navios afundados
     */
    int getSunkShips();

    /**
     * Devolve o número de navios da frota que ainda permanecem a flutuar (não afundados).
     *
     * @return o total de navios restantes em jogo
     */
    int getRemainingShips();

    /**
     * Imprime na consola uma representação do tabuleiro com os tiros válidos já efetuados.
     */
    void printValidShots();

    /**
     * Imprime na consola uma representação do tabuleiro com a disposição dos navios da frota.
     */
    void printFleet();
}
