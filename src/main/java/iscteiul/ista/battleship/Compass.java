```java
/**
 * Representa as orientações possíveis dos navios no jogo Batalha Naval.
 */
package iscteiul.ista.battleship;

/**
 * Define as orientações possíveis de um navio.
 *
 * Cada orientação é representada por um carácter.
 *
 * @author fba
 */
public enum Compass {
    NORTH('n'), SOUTH('s'), EAST('e'), WEST('o'), UNKNOWN('u');

    private final char c;

    /**
     * Cria uma orientação associada a um carácter.
     *
     * @param c carácter que representa a orientação
     */
    Compass(char c) {
        this.c = c;
    }

    /**
     * Obtém o carácter correspondente à orientação.
     *
     * @return carácter que representa a orientação
     */
    public char getDirection() {
        return c;
    }

    /**
     * Obtém a representação textual da orientação.
     *
     * @return carácter da orientação convertido para texto
     */
    @Override
    public String toString() {
        return "" + c;
    }

    /**
     * Converte um carácter numa orientação.
     *
     * @param ch carácter que representa a orientação
     * @return a orientação correspondente ao carácter ou UNKNOWN
     *         caso o carácter não corresponda a nenhuma orientação
     */
    static Compass charToCompass(char ch) {
        Compass bearing;
        switch (ch) {
            case 'n':
                bearing = NORTH;
                break;
            case 's':
                bearing = SOUTH;
                break;
            case 'e':
                bearing = EAST;
                break;
            case 'o':
                bearing = WEST;
                break;
            default:
                bearing = UNKNOWN;
        }

        return bearing;
    }
}
```
