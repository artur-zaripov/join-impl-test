import io.github.artur_zaripov.algorithms.SafeJoin;
import io.github.artur_zaripov.model.Table;
import io.github.artur_zaripov.utils.TableLoader;
import org.junit.Before;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author Artur
 */
public abstract class AbstractJoinTest {
    public Table tableA;
    public Table tableB;

    @Before
    public void setUp() throws IOException {
        tableA = TableLoader.load("tableA.csv");
        tableB = TableLoader.load("tableB.csv");
    }

    public void joinAndCheck(SafeJoin join) {
        Table result = join.safeExecute(tableA, 0, tableB, 0);
        assertEquals("7 rows expected in result", 7, result.getRowsAmount());
    }

    public abstract void checkRowsInJoinTablesResult();
}
