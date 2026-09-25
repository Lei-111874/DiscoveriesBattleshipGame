package iscteiul.ista.battleship;

/**
 * Representa um navio do tipo Galeão (Galleon) no jogo Discoveries Battleship.
 * <p>
 * Na versão temática da época dos Descobrimentos, o Galeão corresponde ao
 * tradicional Porta-aviões, sendo o maior navio da frota ao ocupar 5 posições
 * na grelha dispostas em formato de "T" (variando consoante a orientação cardeal).
 * </p>
 *
 * @author Hugo Furtado (110801)
 * @version 1.0
 * @see Ship
 */
public class Galleon extends Ship {

    /**
     * A dimensão (número de quadrados ocupados na grelha) de um Galeão.
     */
    private static final Integer SIZE = 5;

    /**
     * O nome representativo deste tipo de navio.
     */
    private static final String NAME = "Galeao";

    /**
     * Constrói uma nova instância de um Galeão ({@code Galleon}) com uma
     * determinada orientação cardeal e posição inicial de referência na grelha.
     * <p>
     * Inicializa e preenche as 5 posições ocupadas pelo Galeão de acordo com
     * a orientação especificada ({@code NORTH}, {@code EAST}, {@code SOUTH} ou {@code WEST}).
     * </p>
     *
     * @param bearing a orientação cardeal do Galeão na grelha ({@link Compass})
     * @param pos     a posição inicial (coordenada de referência) para posicionar o navio ({@link IPosition})
     * @throws NullPointerException     se a orientação ({@code bearing}) fornecida for {@code null}
     * @throws IllegalArgumentException se a orientação ({@code bearing}) fornecida não for válida
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Devolve a dimensão (tamanho) do Galeão.
     *
     * @return o tamanho do navio ({@code 5})
     * @see Ship#getSize()
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche as 5 posições da grelha ocupadas pelo Galeão quando orientado a Norte ({@code NORTH}).
     *
     * @param pos a posição inicial de referência ({@link IPosition})
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche as 5 posições da grelha ocupadas pelo Galeão quando orientado a Sul ({@code SOUTH}).
     *
     * @param pos a posição inicial de referência ({@link IPosition})
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Preenche as 5 posições da grelha ocupadas pelo Galeão quando orientado a Este ({@code EAST}).
     *
     * @param pos a posição inicial de referência ({@link IPosition})
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche as 5 posições da grelha ocupadas pelo Galeão quando orientado a Oeste ({@code WEST}).
     *
     * @param pos a posição inicial de referência ({@link IPosition})
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

}
