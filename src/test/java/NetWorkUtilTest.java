import concurrent.NetWorkUtils;
import org.junit.Test;

public class NetWorkUtilTest {
    @Test(timeout = 2000)
    public void hetConnectionShouldReturnFasterThanOneSecond() {
        NetWorkUtils.getConnection();
    }
}
