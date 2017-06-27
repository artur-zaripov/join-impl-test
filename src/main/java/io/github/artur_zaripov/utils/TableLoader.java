package io.github.artur_zaripov.utils;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import io.github.artur_zaripov.model.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Util class for loading table data from resource files in CSV format
 */
public class TableLoader {

    private TableLoader() {
    }

    public static Table load(String resourceName) throws IOException {
        final List<String[]> data = new ArrayList<>();
        Resources.readLines(Resources.getResource(resourceName), Charsets.UTF_8)
                .stream()
                .forEach(s -> data.add(s.split(",")));
        return new Table(data);
    }
}
