package io.github.artur_zaripov.algorithms;

import io.github.artur_zaripov.model.Table;

/**
 * Interface for join algorithms
 */
public interface Join {

    public Table execute(Table tableA, int tableAColumn,
                         Table tableB, int tableBColumn);

}
