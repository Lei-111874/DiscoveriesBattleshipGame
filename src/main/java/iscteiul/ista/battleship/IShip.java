/**
 *
 */
package iscteiul.ista.battleship;

import java.util.List;

public interface IShip {

    /**
     * Obtém a categoria do navio.
     *
     * @return categoria do navio
     */
    String getCategory();

    /**
     * Obtém o tamanho do navio.
     *
     * @return tamanho do navio
     */
    Integer getSize();

    /**
     * Obtém todas as posições ocupadas pelo navio.
     *
     * @return lista de posições ocupadas pelo navio
     */
    List<IPosition> getPositions();

    /**
     * Obtém a posição inicial do navio.
     *
     * @return posição inicial do navio
     */
    IPosition getPosition();

    /**
     * Obtém a direção do navio.
     *
     * @return direção do navio
     */
    Compass getBearing();

    /**
     * Verifica se o navio ainda está a flutuar.
     *
     * @return true se o navio ainda estiver a flutuar,
     *         false caso contrário
     */
    boolean stillFloating();

    /**
     * Obtém a posição mais acima ocupada pelo navio.
     *
     * @return número da linha da posição mais acima
     */
    int getTopMostPos();

    /**
     * Obtém a posição mais abaixo ocupada pelo navio.
     *
     * @return número da linha da posição mais abaixo
     */
    int getBottomMostPos();

    /**
     * Obtém a posição mais à esquerda ocupada pelo navio.
     *
     * @return número da coluna da posição mais à esquerda
     */
    int getLeftMostPos();

    /**
     * Obtém a posição mais à direita ocupada pelo navio.
     *
     * @return número da coluna da posição mais à direita
     */
    int getRightMostPos();

    /**
     * Verifica se o navio ocupa uma determinada posição.
     *
     * @param pos posição a verificar
     * @return true se o navio ocupar a posição,
     *         false caso contrário
     */
    boolean occupies(IPosition pos);

    /**
     * Verifica se o navio está demasiado próximo de outro navio.
     *
     * @param other outro navio a verificar
     * @return true se os navios estiverem demasiado próximos,
     *         false caso contrário
     */
    boolean tooCloseTo(IShip other);

    /**
     * Verifica se o navio está demasiado próximo de uma determinada posição.
     *
     * @param pos posição a verificar
     * @return true se o navio estiver demasiado próximo da posição,
     *         false caso contrário
     */
    boolean tooCloseTo(IPosition pos);

    /**
     * Efetua um disparo numa determinada posição do navio.
     *
     * @param pos posição onde o disparo é realizado
     */
    void shoot(IPosition pos);
}
