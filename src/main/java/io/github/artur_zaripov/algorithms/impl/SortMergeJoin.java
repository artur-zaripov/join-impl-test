package io.github.artur_zaripov.algorithms.impl;

import io.github.artur_zaripov.algorithms.SafeJoin;
import io.github.artur_zaripov.model.Table;

import java.util.ArrayList;
import java.util.List;

public class SortMergeJoin extends SafeJoin {

    @Override
    public Table execute(Table tableA, int tableAColumn, Table tableB, int tableBColumn) {
        List<String[]> data = new ArrayList<>();

        tableA.sortByColumn(tableAColumn);
        tableB.sortByColumn(tableBColumn);

        int i = 0, j = 0;
        while (i < tableA.getRowsAmount() && j < tableB.getRowsAmount()) {
            String[] row1 = tableA.getRow(i);
            String[] row2 = tableB.getRow(j);

            if (row1[tableAColumn].equals(row2[tableBColumn])) {
                data.add(mergeRows(row1, row2, tableBColumn));
                j++;
            } else if (row1[tableAColumn].compareTo(row2[tableBColumn]) < 0) {
                i++;
            } else {
                j++;
            }
        }

        return new Table(data);
    }

}
