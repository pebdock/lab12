package it.unibo.es2;

import java.util.Map;

/**
 * The interface of the Logics of this game.
 */
public interface Logics {

    String EMPTY = " ";
    String NOTEMPTY = "*";

    /**
     * The number of slots.
     * 
     * @return the number of slots
     */
    int size();

    /**
     * The current content in every slot.
     * 
     * @return ordered list of the content in every slot
     */
    Map<Pair<Integer, Integer>, String> symbols();

    /**
     * Change the symbol of the specified slot.
     * 
     * @param elem the slot to change
     * @return the new symbol of the label
     */
    String hit(int elem);

    /**
     * True if it is time to quit.
     * 
     * @return wheter it is time to quir
     */
    boolean toQuit();
}
