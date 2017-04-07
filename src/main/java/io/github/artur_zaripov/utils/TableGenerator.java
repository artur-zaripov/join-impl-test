package io.github.artur_zaripov.utils;

import io.github.artur_zaripov.model.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Util class for generating tables with random text content
 */
public class TableGenerator {
    static final char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static Random random = new Random();

    private TableGenerator() {
    }

    public static Table generate(int rowsNumber, int columnsNumber, int randomTextLength) {
        List<String[]> data = new ArrayList<>();

        for (int i = 0; i < rowsNumber; i++) {
            String[] row = new String[columnsNumber];

            for (int j = 0; j < columnsNumber; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < randomTextLength; k++) {
                    char c = chars[random.nextInt(chars.length)];
                    sb.append(c);
                }
                row[j] = sb.toString();
            }
            data.add(row);
        }

        return new Table(data);
    }
}
