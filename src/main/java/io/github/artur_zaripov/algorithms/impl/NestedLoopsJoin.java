package io.github.artur_zaripov.algorithms.impl;

import io.github.artur_zaripov.algorithms.SafeJoin;
import io.github.artur_zaripov.model.Table;

import java.util.ArrayList;
import java.util.List;

public class NestedLoopsJoin extends SafeJoin {

    @Override
    public Table execute(Table tableA, int tableAColumn, Table tableB, int tableBColumn) {
        List<String[]> data = new ArrayList<>();

        tableA.getRowsStream().forEach(lineA -> {
            tableB.getRowsStream().forEach(lineB -> {
                if (lineA[tableAColumn].equals(lineB[tableBColumn]))
                    data.add(mergeRows(lineA, lineB, tableBColumn));
            });
        });

        return new Table(data);
    }

}
