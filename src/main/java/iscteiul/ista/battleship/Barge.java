/** 
* Representa uma barca no jogo Batalha Naval. 
* Uma barca ocupa apenas uma posição no tabuleiro. 
*/
package iscteiul.ista.battleship;

public class Barge extends Ship {
    private static final Integer SIZE = 1;
    private static final String NAME = "Barca";

   /** * Cria uma nova barca com a orientação e a posição indicadas. 
   * 
   * @param bearing orientação da barca 
   * @param pos posição superior esquerda da barca 
   */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }
   /** * Obtém o tamanho da barca. 
   * 
   * @return tamanho da barca, que é sempre 1 
   */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
