```java
/**
 * Representa uma caravela no jogo Batalha Naval.
 * A caravela ocupa duas posições no tabuleiro.
 */
package iscteiul.ista.battleship;

public class Caravel extends Ship {
    private static final Integer SIZE = 2;
    private static final String NAME = "Caravela";

    /**
     * Cria uma nova caravela com a orientação e a posição inicial indicadas.
     *
     * @param bearing orientação da caravela
     * @param pos posição inicial da caravela no tabuleiro
     * @throws NullPointerException se a orientação da caravela for nula
     * @throws IllegalArgumentException se a orientação da caravela for inválida
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Obtém o tamanho da caravela.
     *
     * @return tamanho da caravela, que é sempre 2
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
```
