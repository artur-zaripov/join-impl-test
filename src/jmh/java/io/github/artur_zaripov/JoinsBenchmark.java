package io.github.artur_zaripov;

import io.github.artur_zaripov.algorithms.SafeJoin;
import io.github.artur_zaripov.algorithms.impl.HashJoin;
import io.github.artur_zaripov.algorithms.impl.NestedLoopsJoin;
import io.github.artur_zaripov.algorithms.impl.SortMergeJoin;
import io.github.artur_zaripov.model.Table;
import io.github.artur_zaripov.utils.TableLoader;
import org.openjdk.jmh.annotations.Benchmark;

import java.io.IOException;

public class JoinsBenchmark {

    @Benchmark
    public void hashJoin() throws IOException {
        Table tableA = TableLoader.load("tableA.csv");
        Table tableB = TableLoader.load("tableB.csv");

        SafeJoin join = new HashJoin();
        join.safeExecute(tableA, 0, tableB, 0);
    }

    @Benchmark
    public void nestedLoopsJoin() throws IOException {
        Table tableA = TableLoader.load("tableA.csv");
        Table tableB = TableLoader.load("tableB.csv");

        SafeJoin join = new NestedLoopsJoin();
        join.safeExecute(tableA, 0, tableB, 0);
    }

    @Benchmark
    public void sortMergeJoin() throws IOException {
        Table tableA = TableLoader.load("tableA.csv");
        Table tableB = TableLoader.load("tableB.csv");

        SafeJoin join = new SortMergeJoin();
        join.safeExecute(tableA, 0, tableB, 0);
    }

}
