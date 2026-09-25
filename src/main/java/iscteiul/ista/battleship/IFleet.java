package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que define o contrato para uma frota de navios no jogo Discoveries Battleship.
 * <p>
 * Especifica as constantes de dimensão da grelha e da frota, bem como as operações
 * fundamentais para gerir os navios (adicionar navios, consultar navios por categoria,
 * verificar navios ainda a flutuar, localizar navios numa coordenada e imprimir o estado da frota).
 * </p>
 *
 * @author Hugo Furtado (110801)
 * @version 1.0
 * @see IShip
 * @see IPosition
 */
public interface IFleet {

    /**
     * Dimensão lateral da grelha quadriculada do tabuleiro (10x10 quadrados).
     */
    Integer BOARD_SIZE = 10;

    /**
     * Capacidade máxima de navios que compõem a frota.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Devolve a lista de todos os navios que pertencem atualmente à frota.
     *
     * @return uma {@link List} de {@link IShip} com todos os navios da frota
     */
    List<IShip> getShips();

    /**
     * Adiciona um novo navio à frota, caso cumpra as regras de posicionamento e limite da grelha.
     *
     * @param s o navio ({@link IShip}) a ser adicionado à frota
     * @return {@code true} se o navio foi adicionado com sucesso,
     *         {@code false} caso contrário (ex.: fora do tabuleiro, colisão ou frota cheia)
     */
    boolean addShip(IShip s);

    /**
     * Devolve a lista de navios da frota que pertencem a uma determinada categoria (tipo de navio).
     *
     * @param category o nome ou categoria do tipo de navio a filtrar (ex.: "Barca", "Caravela", "Nau", "Fragata", "Galeao")
     * @return uma {@link List} de {@link IShip} contendo os navios da categoria indicada
     */
    List<IShip> getShipsLike(String category);

    /**
     * Devolve a lista de todos os navios da frota que ainda se encontram a flutuar (não afundados).
     *
     * @return uma {@link List} de {@link IShip} com os navios ainda ativos em jogo
     */
    List<IShip> getFloatingShips();

    /**
     * Procura e devolve o navio que ocupa uma determinada posição na grelha.
     *
     * @param pos a posição ({@link IPosition}) a consultar no tabuleiro
     * @return o navio ({@link IShip}) que ocupa a coordenada indicada,
     *         ou {@code null} se não existir nenhum navio nessa posição
     */
    IShip shipAt(IPosition pos);

    /**
     * Imprime na consola o resumo do estado atual da frota (todos os navios,
     * navios ainda a flutuar e navios agrupados por categoria).
     */
    void printStatus();
}
