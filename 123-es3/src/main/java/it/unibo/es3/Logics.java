package it.unibo.es3;

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
     * Checks if the selected slot is enabled.
     * 
     * @param elem the element to check
     * @return true if elem is enabled, false otherwise
     */
    Boolean isEnabled(int elem);

    /**
     * The current content in every slot.
     * 
     * @return ordered list of the content in every slot
     */
    Map<Pair<Integer, Integer>, Boolean> symbols();

    /**
     * Change the symbol of the specified slot.
     */
    void hit();

    /**
     * True if it is time to quit.
     * 
     * @return wheter it is time to quir
     */
    boolean toQuit();
}
