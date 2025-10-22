import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@Slf4j
public class BaseTest {
    protected static final String NULL_ARRAY_MSG = "The array is null!";
    protected static final String EMPTY_ARRAY_MSG = "The array is empty!";

    protected static ArrayUtils arrayUtils;

    @BeforeEach
    public void setupAll(){
        log.info("<<<< New ArrayUtils instance has been created >>>>");
        arrayUtils = new ArrayUtils();
    }

    @AfterEach
    public void tearDown(){
        log.info("<<<< ArrayUtils instance is teared down >>>>");
        arrayUtils = null;
    }
}
