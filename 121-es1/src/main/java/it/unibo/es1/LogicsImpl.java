package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    private int size;
    private ArrayList<Integer> values;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.size = size;
        values = new ArrayList<>(Collections.nCopies(size, 0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return List.copyOf(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return this.values
        .stream()
        .map(v -> v < this.size)
        .toList();
git add .
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        if (values.get(elem) == size) {
            return size;
        } else {
            final int newvalue = values.get(elem) + 1;
            values.set(elem, newvalue);
            return newvalue;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return values.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return values.stream()
        .allMatch(v -> v == this.size);
    }
}
