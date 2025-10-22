import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

@Slf4j
public class BaseTest {

    protected static ArrayUtils arrayUtils;

    @BeforeAll
    public static void setupAll(){
        log.info("<<<< New ArrayUtils instance has been created >>>>");
        arrayUtils = new ArrayUtils();
    }

    @AfterAll
    public static void tearDown(){
        log.info("<<<< ArrayUtils instance is teared down >>>>");
        arrayUtils = null;
    }
}
