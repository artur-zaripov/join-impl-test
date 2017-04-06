package io.github.artur_zaripov.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class for table data storage
 */
public class Table {
    private List<String[]> rows;

    public Table(List<String[]> rows) {
        this.rows = rows;
    }

    public int getColumnsAmount() {
        return rows.size() == 0 ? 0 : rows.get(0).length;
    }

    public int getRowsAmount() {
        return rows.size();
    }

    public String[] getRow(int rowNumber) {
        validateNumber(rowNumber, rows.size(), "row");
        return rows.get(rowNumber);
    }

    public String getCellValue(int rowNumber, int columnNumber) {
        validateNumber(rowNumber, rows.size(), "row");
        validateNumber(columnNumber, getColumnsAmount(), "column");

        try {
            return rows.get(rowNumber)[columnNumber];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public Stream<String[]> getRowsStream() {
        return rows.stream();
    }

    public void sortByColumn(int columnNumber) {
        Collections.sort(rows,
                (String[] line1, String[] line2) -> line1[columnNumber].compareTo(line2[columnNumber]));
    }

    private void validateNumber(int number, int maxValue, String name) {
        if (number < 0 || number >= maxValue)
            throw new IllegalArgumentException("No such " + name + " number available");
    }
}
