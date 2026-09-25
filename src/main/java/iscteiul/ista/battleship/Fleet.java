```java
/**
 * Representa uma frota de navios no jogo Batalha Naval.
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

public class Fleet implements IFleet {

    /**
     * Imprime todos os navios fornecidos.
     *
     * @param ships lista de navios a imprimir
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    // -----------------------------------------------------

    private List<IShip> ships;

    /**
     * Cria uma nova frota sem navios.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Obtém a lista de navios da frota.
     *
     * @return lista de navios da frota
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adiciona um navio à frota, caso este possa ser colocado no tabuleiro
     * e não exista risco de colisão com outro navio.
     *
     * @param s navio a adicionar à frota
     * @return true se o navio foi adicionado; false caso contrário
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Obtém os navios da frota pertencentes a uma determinada categoria.
     *
     * @param category categoria dos navios pretendidos
     * @return lista dos navios pertencentes à categoria indicada
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Obtém os navios da frota que ainda estão a flutuar.
     *
     * @return lista dos navios que ainda estão a flutuar
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Obtém o navio que ocupa uma determinada posição.
     *
     * @param pos posição a verificar
     * @return o navio que ocupa a posição indicada ou null caso não exista nenhum
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifica se um navio está completamente dentro dos limites do tabuleiro.
     *
     * @param s navio a verificar
     * @return true se o navio estiver dentro do tabuleiro; false caso contrário
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0 && s.getRightMostPos() <= BOARD_SIZE - 1 && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Verifica se existe risco de colisão ou proximidade excessiva entre
     * o navio indicado e algum navio já presente na frota.
     *
     * @param s navio a verificar
     * @return true se existir risco de colisão; false caso contrário
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
```
