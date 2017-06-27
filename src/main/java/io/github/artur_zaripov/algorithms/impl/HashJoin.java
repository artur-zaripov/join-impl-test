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
        Map<String, List<Integer>> index = new HashMap<>();

        if (tableA.getRowsAmount() > tableB.getRowsAmount()) {
            fillIndex(index, tableB, tableBColumn);
            return new Table(getData(tableA, tableAColumn, index, tableB));
        } else {
            fillIndex(index, tableA, tableAColumn);
            return new Table(getData(tableB, tableBColumn, index, tableA));
        }
    }

    private void fillIndex(Map<String, List<Integer>> index, Table table, int column) {
        for (int i = 0; i < table.getRowsAmount(); i++) {
            String value = table.getCellValue(i, column);
            List<Integer> rowNumbers = index.get(value);
            if (rowNumbers == null) {
                rowNumbers = new ArrayList<>();
                rowNumbers.add(i);
                index.put(value, rowNumbers);
            } else {
                rowNumbers.add(i);
            }
        }
    }

    private List<String[]> getData(Table table, int columnInTable, Map<String, List<Integer>> index, Table indexedTable) {
        List<String[]> data = new ArrayList<>();

        table.getRowsStream().forEach(row1 -> {
            List<Integer> rowNumbers = index.get(row1[columnInTable]);
            if (rowNumbers != null) {
                for (Integer i : rowNumbers) {
                    String[] row2 = indexedTable.getRow(i);
                    data.add(mergeRows(row2, row1, columnInTable));
                }
            }
        });

        return data;
    }
}
