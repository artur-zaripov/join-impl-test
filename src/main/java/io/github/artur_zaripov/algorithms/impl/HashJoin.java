package io.github.artur_zaripov.algorithms.impl;

import io.github.artur_zaripov.algorithms.SafeJoin;
import io.github.artur_zaripov.model.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashJoin extends SafeJoin {

    @Override
    public Table execute(Table tableA, int tableAColumn, Table tableB, int tableBColumn) {
        Map<String, Integer> index = new HashMap<>();

        if (tableA.getRowsAmount() > tableB.getRowsAmount()) {
            fillIndex(index, tableB, tableBColumn);
            return new Table(getData(tableA, tableAColumn, index, tableB));
        } else {
            fillIndex(index, tableA, tableAColumn);
            return new Table(getData(tableB, tableBColumn, index, tableA));
        }
    }

    private void fillIndex(Map<String, Integer> index, Table table, int column) {
        for (int i = 0; i < table.getRowsAmount(); i++)
            index.put(table.getCellValue(i, column), i);
    }

    private List<String[]> getData(Table table, int columnInTable, Map<String, Integer> index, Table indexedTable) {
        List<String[]> data = new ArrayList<>();

        table.getRowsStream().forEach(row1 -> {
            Integer i = index.get(row1[columnInTable]);
            if (i != null) {
                String[] row2 = indexedTable.getRow(i);
                data.add(mergeRows(row2, row1, columnInTable));
            }
        });

        return data;
    }
}
