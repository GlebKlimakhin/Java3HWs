import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TestArrayOperations {
    private ArrayOperations arrayOperations;

    static Stream<Object[]> arrayStream() {
        return Stream.of(new Object[] { new int[] { 4, 1 } , new int[] {1}},
                new Object[] {new int[] { 1, 2, 4 ,5 , 6 } , new int[] {5, 6}},
                 new Object[] {new int[] { 12, 16, 13, 4, 22, 3 } , new int[] {22, 3}});
    }
    static Stream<Object[]> arrayStreamException() {
        return Stream.of(new Object[] { new int[] { 1, 2, 3 }},
                new Object[] {new int[] { 12, 24, 36, 48, 60 }},
                 new Object[] {new int[] { 1, 2 ,5 , 6 }});
    }

    @BeforeEach
    public void init() {
        arrayOperations = new ArrayOperations();
    }

    @MethodSource("arrayStream")
    @ParameterizedTest
    public void massCommonTest(int[] arr, int[] result) {
        Assertions.assertArrayEquals(arrayOperations.newArray(arr), result);
    }
    @MethodSource("arrayStreamException")
    @ParameterizedTest()
    public void massExceptionTest(int[] arr){
        Assertions.assertThrows(RuntimeException.class, () -> arrayOperations.newArray(arr));
    }

    static Stream<Object[]> dataStreamBasicInput() {
        return Stream.of(new Object[] { new int[] { 1, 2, 3 }, true},
                new Object[] {new int[] { 12, 24, 36, 48, 60 }, false},
                new Object[] {new int[] { 1, 2 ,5 , 4 }, true},
                new Object[] {new int[] {}, false});
    }

    @MethodSource("dataStreamBasicInput")
    @ParameterizedTest()
    public void massCommonTestIsContains(int [] arr, boolean isContains){
        Assertions.assertEquals(isContains, arrayOperations.isAnyExpectedNums(arr));
    }

}
