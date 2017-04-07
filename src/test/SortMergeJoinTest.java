import io.github.artur_zaripov.algorithms.impl.SortMergeJoin;
import org.junit.Test;

public class SortMergeJoinTest extends AbstractJoinTest {

    @Test
    public void checkRowsInJoinTablesResult() {
        joinAndCheck(new SortMergeJoin());
    }
}
