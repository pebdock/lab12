package it.unibo.es3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * The implementation of the logics of this game.
 */
public class LogicsImpl implements Logics {

    private static final int RANDOM = 3;

    private final Map<Pair<Integer, Integer>, Boolean> grid = new HashMap<>();
    private final int size;
    private final Random random = new Random();

    /**
     * The constructor of the Logics.
     * 
     * @param size the number of slots
     */
    public LogicsImpl(final int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid.put(new Pair<>(i, j), false);
            }
        }
        randomTrue();
    }

    /**
     * Put RANDOM slots true.
     */
    private void randomTrue() {
        int randomSlots = 0;
        while (randomSlots < RANDOM) {
            final Pair<Integer, Integer> coordinates = new Pair<>(random.nextInt(size), random.nextInt(size));
            if (!grid.get(coordinates)) {
                randomSlots = randomSlots + 1;
                grid.put(coordinates, true);
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
    public Map<Pair<Integer, Integer>, Boolean> symbols() {
        return Map.copyOf(grid);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void hit() {
        final Map<Pair<Integer, Integer>, Boolean> tmpGrid = new HashMap<>(this.grid);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final Pair<Integer, Integer> coordinates = new Pair<>(i, j);
                if (grid.get(coordinates)) {
                    checkOthers(coordinates, tmpGrid);
                }
            }
        }
        grid.putAll(tmpGrid);
    }

    /**
     * Check the slots around the selected one and put them to true.
     * 
     * @param coordinates the row and col of the selected slot
     * @param tmpMap the tmp map to use after changing the states
     */
    private void checkOthers(final Pair<Integer, Integer> coordinates, final Map<Pair<Integer, Integer>, Boolean> tmpMap) {
        for (int tmpi = coordinates.x() - 1; tmpi <= coordinates.x() + 1; tmpi++) {
            for (int tmpj = coordinates.y() - 1; tmpj <= coordinates.y() + 1; tmpj++) {
                final Pair<Integer, Integer> newCoordinates = new Pair<>(tmpi, tmpj);
                if (tmpMap.containsKey(newCoordinates) && !tmpMap.get(newCoordinates)) {
                    tmpMap.put(newCoordinates, true);
                }
            }
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean toQuit() {
        return !grid.containsValue(false);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Boolean isEnabled(final int elem) {
        final int row = elem / size;
        final int col = elem % size;
        return grid.get(new Pair<>(row, col));
    }
}
