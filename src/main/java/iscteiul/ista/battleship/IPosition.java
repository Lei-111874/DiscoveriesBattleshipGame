/**
 *
 */
package iscteiul.ista.battleship;

/**
 * Representa uma posição no tabuleiro do jogo.
 *
 * @author fba
 */
public interface IPosition {

    /**
     * Obtém a linha da posição.
     *
     * @return número da linha
     */
    int getRow();

    /**
     * Obtém a coluna da posição.
     *
     * @return número da coluna
     */
    int getColumn();

    /**
     * Verifica se esta posição é igual a outra posição.
     *
     * @param other objeto que representa a outra posição
     * @return true se as posições forem iguais, false caso contrário
     */
    boolean equals(Object other);

    /**
     * Verifica se esta posição é adjacente a outra posição.
     *
     * @param other posição a verificar
     * @return true se as posições forem adjacentes, false caso contrário
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marca a posição como ocupada por um navio.
     */
    void occupy();

    /**
     * Marca a posição como atingida por um disparo.
     */
    void shoot();

    /**
     * Verifica se a posição está ocupada por um navio.
     *
     * @return true se a posição estiver ocupada, false caso contrário
     */
    boolean isOccupied();

    /**
     * Verifica se a posição foi atingida por um disparo.
     *
     * @return true se a posição tiver sido atingida, false caso contrário
     */
    boolean isHit();
}


