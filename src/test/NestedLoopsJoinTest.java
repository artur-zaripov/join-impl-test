import io.github.artur_zaripov.algorithms.impl.NestedLoopsJoin;
import org.junit.Test;

public class NestedLoopsJoinTest extends AbstractJoinTest {

    @Test
    public void checkRowsInJoinTablesResult() {
        joinAndCheck(new NestedLoopsJoin());
    }
}