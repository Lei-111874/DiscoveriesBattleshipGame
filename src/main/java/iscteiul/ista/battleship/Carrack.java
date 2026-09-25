```java
/**
 * Representa uma nau no jogo Batalha Naval.
 * A nau ocupa três posições no tabuleiro.
 */
package iscteiul.ista.battleship;

public class Carrack extends Ship {
    private static final Integer SIZE = 3;
    private static final String NAME = "Nau";

    /**
     * Cria uma nova nau com a orientação e a posição inicial indicadas.
     *
     * @param bearing orientação da nau
     * @param pos posição inicial da nau no tabuleiro
     * @throws IllegalArgumentException se a orientação da nau for inválida
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Obtém o tamanho da nau.
     *
     * @return tamanho da nau, que é sempre 3
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}
```
