import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class ArrayUtilsTest extends BaseTest{

    record ArrayTestCase(int[] input, Integer expectedMax, Integer expectedMin, Double expectedAvg){
        @Override
        public String toString(){
            return "input=" + Arrays.toString(input) +
                    ", expectedMax=" + expectedMax +
                    ", expectedMin=" + expectedMin +
                    ", expectedAvg=" + expectedAvg;
        }
    }

    static Stream<ArrayTestCase> provideArrayTestCases(){
        return Stream.of(
                new ArrayTestCase(new int[]{-4, 0, 16, -8}, 16, -8, 1.0),
                new ArrayTestCase(new int[]{}, null, null, null),
                new ArrayTestCase(new int[]{6}, 6, 6, 6.0),
                new ArrayTestCase(null, null, null, null)
                );
    }


    @ParameterizedTest
    @MethodSource("provideArrayTestCases")
    public void maxValueInArrayTest(ArrayTestCase testCase){
        log.info("maxValueInArrayTest is running for: {}", Arrays.toString(testCase.input()));
        if(testCase.input() == null){
            log.info("The array is null");
            assertThrows(IllegalArgumentException.class, () -> arrayUtils.max(testCase.input()));
        } else if (testCase.input().length == 0) {
            log.info("The array is empty");
            assertThrows(EmptyArrayException.class, () -> arrayUtils.max(testCase.input()));
        } else {
            assertEquals(testCase.expectedMax(), arrayUtils.max(testCase.input()),
                    "Test failed for input: " + Arrays.toString(testCase.input()));
        }
    }

    @ParameterizedTest
    @MethodSource("provideArrayTestCases")
    public void minValueInArrayTest(ArrayTestCase testCase){
        log.info("minValueInArrayTestCase is running for: {}", Arrays.toString(testCase.input()));
        if(testCase.input() == null){
            log.info("The array is null");
            assertThrows(IllegalArgumentException.class, () -> arrayUtils.min(testCase.input()));
        } else if (testCase.input().length == 0) {
            log.info("The array is empty");
            assertThrows(EmptyArrayException.class, () -> arrayUtils.min(testCase.input()));
        } else {
            assertEquals(testCase.expectedMin(), arrayUtils.min(testCase.input()),
                    "Test failed for input: " + Arrays.toString(testCase.input()));
        }
    }

    @ParameterizedTest
    @MethodSource("provideArrayTestCases")
    public void avgValueInArrayTest(ArrayTestCase testCase){
        log.info("avgValueInArrayTestCase is running for: {}", Arrays.toString(testCase.input()));
        if(testCase.input() == null){
            log.info("The array is null");
            assertThrows(IllegalArgumentException.class, () -> arrayUtils.average(testCase.input()));
        } else if (testCase.input().length == 0) {
            log.info("The array is empty");
            assertThrows(EmptyArrayException.class, () -> arrayUtils.average(testCase.input()));
        } else {
            assertEquals(testCase.expectedAvg(), arrayUtils.average(testCase.input()),
                    "Test failed for input: " + Arrays.toString(testCase.input()));
        }
    }

    @Test
    public void nullArrayMessageForMaxMethodTest(){
        log.info("The nullArrayForMaxMethodTest is running");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> arrayUtils.max(null));
        assertEquals(NULL_ARRAY_MSG, exception.getMessage());
    }

    @Test
    public void emptyArrayMessageForMaxMethodTest(){
        log.info("The emptyArrayForMaxMethodTest is running");
        Exception exception = assertThrows(EmptyArrayException.class, () -> arrayUtils.max(new int[]{}));
        assertEquals(EMPTY_ARRAY_MSG, exception.getMessage());
    }

    @Test
    public void nullArrayMessageForMinMethodTest(){
        log.info("The nullArrayForMinMethodTest is running");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> arrayUtils.min(null));
        assertEquals(NULL_ARRAY_MSG, exception.getMessage());
    }

    @Test
    public void emptyArrayMessageForMinMethodTest(){
        log.info("The emptyArrayForMinMethodTest is running");
        Exception exception = assertThrows(EmptyArrayException.class, () -> arrayUtils.min(new int[]{}));
        assertEquals(EMPTY_ARRAY_MSG, exception.getMessage());
    }

    @Test
    public void nullArrayMessageForAverageMethodTest(){
        log.info("The nullArrayForAverageMethodTest is running");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> arrayUtils.average(null));
        assertEquals(NULL_ARRAY_MSG, exception.getMessage());
    }

    @Test
    public void emptyArrayMessageForAverageMethodTest(){
        log.info("The emptyArrayForAverageMethodTest is running");
        Exception exception = assertThrows(EmptyArrayException.class, () -> arrayUtils.average(new int[]{}));
        assertEquals(EMPTY_ARRAY_MSG, exception.getMessage());
    }

}
