import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ArrayUtils {

    public int max(int[] arr){
        if(arr == null){
            throw new IllegalArgumentException("The array is null!");
        }
        if (arr.length == 0){
            throw new EmptyArrayException("The array is empty!");
        }

        int maxValue = Arrays.stream(arr).max().getAsInt();

        log.info("The max value from the array is: {}", maxValue);
        return maxValue;
    }

    public int min(int[] arr){
        if(arr == null){
            throw new IllegalArgumentException("The array is null!");
        }
        if (arr.length == 0){
            throw new EmptyArrayException("The array is empty!");
        }

        int minValue = Arrays.stream(arr).min().getAsInt();

        log.info("The min value from the array is: {}", minValue);
        return minValue;
    }

    public double average(int[] arr){
        if(arr == null){
            throw new IllegalArgumentException("The array is null!");
        }
        if (arr.length == 0){
            throw new EmptyArrayException("The array is empty!");
        }
        double avgValue = Arrays.stream(arr).average().orElseThrow();

        log.info("The average value is: {}", avgValue);
        return avgValue;
    }
}
