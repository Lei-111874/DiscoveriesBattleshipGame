package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Fragata (Frigate) no jogo Discoveries Battleship.
 * <p>
 * Na versão temática da época dos Descobrimentos, a Fragata corresponde ao
 * tradicional navio de 4 canhões, ocupando exatamente 4 posições consecutivas
 * na grelha (na horizontal ou na vertical).
 * </p>
 *
 * @author Hugo Furtado (110801)
 * @version 1.0
 * @see Ship
 */
public class Frigate extends Ship {

    /**
     * A dimensão (número de quadrados ocupados na grelha) de uma Fragata.
     */
    private static final Integer SIZE = 4;

    /**
     * O nome representativo deste tipo de navio em português.
     */
    private static final String NAME = "Fragata";

    /**
     * Constrói uma nova instância de uma Fragata ({@code Frigate}) com uma
     * determinada orientação cardeal e posição inicial na grelha.
     * <p>
     * Calcula e adiciona automaticamente as 4 posições ocupadas pelo navio:
     * se a orientação for {@code NORTH} ou {@code SOUTH}, o navio estende-se
     * verticalmente (ao longo das linhas); se for {@code EAST} ou {@code WEST},
     * estende-se horizontalmente (ao longo das colunas).
     * </p>
     *
     * @param bearing a orientação cardeal do navio na grelha ({@link Compass})
     * @param pos     a posição inicial (coordenada de referência) para posicionar o navio ({@link IPosition})
     * @throws IllegalArgumentException se a orientação ({@code bearing}) fornecida não for válida
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
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
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * Devolve a dimensão (tamanho) da Fragata.
     *
     * @return o tamanho do navio ({@code 4})
     * @see Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Frigate.SIZE;
    }

}
