package it.unibo.es2;

import java.util.HashMap;
import java.util.Map;

/**
 * The implementation of the logics of this game.
 */
public class LogicsImpl implements Logics {

    private final Map<Pair<Integer, Integer>, String> grid = new HashMap<>();
    private final int size;

    /**
     * The constructor of the Logics.
     * 
     * @param size the number of slots
     */
    public LogicsImpl(final int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid.put(new Pair<>(i, j), EMPTY);
            }
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Map<Pair<Integer, Integer>, String> symbols() {
        return Map.copyOf(grid);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String hit(final int elem) {
        final int row = elem / size;
        final int col = elem % size;
        final Pair<Integer, Integer> coordinates = new Pair<>(row, col);
        if (EMPTY.equals(grid.get(coordinates))) {
             grid.put(coordinates, NOTEMPTY);
             return NOTEMPTY;
        } else {
             grid.put(coordinates, EMPTY);
             return EMPTY;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean toQuit() {
        return isRowFull() || isColFull();
    }

    /**
     * Checks if a row is full.
     * 
     * @return true if any row is full, false otherwise
     */
    private boolean isRowFull() {
        for (int i = 0; i < size; i++) {
            boolean isRowFull = true;
            for (int j = 0; j < size; j++) {
                if (EMPTY.equals(grid.get(new Pair<>(i, j)))) {
                    isRowFull = false;
                    break;
                }
            }
            if (isRowFull) {
                return isRowFull;
            }
        }

        return false;
    }

    /**
     * Checks if any column is full.
     * 
     * @return true if any column is full, false otherwise
     */
    private boolean isColFull() {
        for (int i = 0; i < size; i++) {
            boolean isColFull = true;
            for (int j = 0; j < size; j++) {
                if (EMPTY.equals(grid.get(new Pair<>(j, i)))) {
                    isColFull = false;
                    break;
                }
            }
            if (isColFull) {
                return isColFull;
            }
        }

        return false;
    }
}
