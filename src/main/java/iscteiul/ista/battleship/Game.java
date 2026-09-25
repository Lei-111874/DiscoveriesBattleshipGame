package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa e gere o estado de uma partida do jogo Discoveries Battleship.
 * <p>
 * Esta classe é responsável por associar uma frota ({@link IFleet}) ao jogo,
 * processar os disparos efetuados sobre a grelha, validar coordenadas,
 * contabilizar estatísticas da partida (tiros inválidos, tiros repetidos,
 * tiros certeiros e navios afundados) e imprimir representações visuais do
 * tabuleiro na consola.
 * </p>
 *
 * @author fba
 * @author Hugo Furtado (110801)
 * @version 1.0
 * @see IGame
 * @see IFleet
 */
public class Game implements IGame {

    /**
     * A frota de navios associada a este jogo.
     */
    private IFleet fleet;

    /**
     * Lista das posições onde já foram efetuados tiros válidos e não repetidos.
     */
    private List<IPosition> shots;

    /**
     * Contador do número de tiros inválidos (fora dos limites do tabuleiro).
     */
    private Integer countInvalidShots;

    /**
     * Contador do número de tiros repetidos (disparados para coordenadas já atingidas anteriormente).
     */
    private Integer countRepeatedShots;

    /**
     * Contador do número de tiros certeiros (que atingiram um navio).
     */
    private Integer countHits;

    /**
     * Contador do número de navios completamente afundados.
     */
    private Integer countSinks;

    /**
     * Constrói uma nova instância de um jogo ({@code Game}) associada a uma determinada frota.
     * <p>
     * Inicializa a lista de tiros efetuados e coloca os contadores de tiros
     * inválidos e repetidos a zero.
     * </p>
     *
     * @param fleet a frota de navios ({@link IFleet}) que será alvo dos disparos neste jogo
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        this.fleet = fleet;
    }

    /**
     * Efetua um disparo sobre uma determinada posição do tabuleiro.
     * <p>
     * Verifica primeiro se a coordenada do tiro é válida e se não é repetida.
     * Caso o tiro seja válido e inédito, regista-o na lista de tiros e verifica
     * se existe algum navio da frota nessa posição. Se um navio for atingido e
     * acabar por afundar com este disparo, o método devolve a referência para
     * esse navio afundado; caso contrário, devolve {@code null}.
     * </p>
     *
     * @param pos a posição ({@link IPosition}) alvo do disparo
     * @return o navio ({@link IShip}) que acabou de ser afundado por este tiro,
     *         ou {@code null} se o tiro falhar, for inválido/repetido ou apenas
     *         atingir um navio sem o afundar totalmente
     * @see IGame#fire(IPosition)
     */
    @Override
    public IShip fire(IPosition pos) {
        if (!validShot(pos))
            countInvalidShots++;
        else { // valid shot!
            if (repeatedShot(pos))
                countRepeatedShots++;
            else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Devolve a lista de todas as posições correspondentes a tiros válidos já efetuados.
     *
     * @return uma {@link List} de {@link IPosition} com os tiros válidos registados
     * @see IGame#getShots()
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Devolve o número total de tiros repetidos efetuados até ao momento.
     *
     * @return o total de tiros repetidos
     * @see IGame#getRepeatedShots()
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Devolve o número total de tiros inválidos (fora da grelha) efetuados até ao momento.
     *
     * @return o total de tiros inválidos
     * @see IGame#getInvalidShots()
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Devolve o número total de tiros certeiros que atingiram navios da frota.
     *
     * @return o total de acertos em navios
     * @see IGame#getHits()
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Devolve o número total de navios da frota que já foram afundados.
     *
     * @return o total de navios afundados
     * @see IGame#getSunkShips()
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Devolve o número de navios da frota que ainda se encontram a flutuar (não afundados).
     *
     * @return o número de navios restantes em jogo
     * @see IGame#getRemainingShips()
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Verifica se a posição de um tiro se encontra dentro dos limites válidos do tabuleiro.
     *
     * @param pos a posição ({@link IPosition}) a validar
     * @return {@code true} se a linha e a coluna estiverem dentro dos limites do tabuleiro,
     *         {@code false} caso contrário
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Verifica se uma determinada posição já foi alvo de um tiro válido anteriormente.
     *
     * @param pos a posição ({@link IPosition}) a verificar
     * @return {@code true} se o tiro for repetido, {@code false} se for uma coordenada ainda não atacada
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Imprime na consola uma representação textual do tabuleiro do jogo,
     * assinalando uma lista específica de posições com um carácter marcador.
     * <p>
     * As posições vazias do tabuleiro são representadas pelo carácter {@code '.'}.
     * </p>
     *
     * @param positions a lista de posições ({@link IPosition}) a destacar na grelha
     * @param marker    o carácter ({@link Character}) utilizado para marcar as posições fornecidas
     */
    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }

    }

    /**
     * Imprime na consola o tabuleiro com todos os tiros válidos já disparados,
     * assinalados com o carácter {@code 'X'}.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Imprime na consola o tabuleiro com as posições de todos os navios da frota,
     * assinaladas com o carácter {@code '#'}.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }

}
