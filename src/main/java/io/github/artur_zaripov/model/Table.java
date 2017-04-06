package io.github.artur_zaripov.model;

import java.util.List;

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
    
    private void validateNumber(int number, int maxValue, String name) {
        if (number < 0 || number >= maxValue)
            throw new IllegalArgumentException("No such " + name + " number available");
    }
}
