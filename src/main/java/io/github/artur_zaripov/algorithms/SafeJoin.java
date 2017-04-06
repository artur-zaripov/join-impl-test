package io.github.artur_zaripov.algorithms;

import io.github.artur_zaripov.model.Table;

/**
 * Class
 */
public abstract class SafeJoin implements Join {

    public Table safeExecute(Table tableA, int tableAColumn,
                             Table tableB, int tableBColumn) {
        validateNumber(tableAColumn, tableA.getColumnsAmount(), "tableA column");
        validateNumber(tableBColumn, tableB.getColumnsAmount(), "tableB column");

        return execute(tableA, tableAColumn, tableB, tableBColumn);
    }

    public String[] mergeRows(String[] rowA, String[] rowB, int ignoredColumnInB) {
        String[] result = new String[rowA.length + rowB.length - 1];

        int i = rowA.length;
        System.arraycopy(rowA, 0, result, 0, rowA.length);
        for (int j = 0; j < rowB.length; j++)
            if (j != ignoredColumnInB) {
                result[i] = rowB[j];
                i++;
            }

        return result;
    }

    private void validateNumber(int number, int maxValue, String name) {
        if (number < 0 || number >= maxValue)
            throw new IllegalArgumentException("No such " + name + " number available");
    }
}
