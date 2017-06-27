import io.github.artur_zaripov.algorithms.impl.HashJoin;
import org.junit.Test;

public class HashJoinTest extends AbstractJoinTest {

    @Test
    public void checkRowsInJoinTablesResult() {
        joinAndCheck(new HashJoin());
    }
}