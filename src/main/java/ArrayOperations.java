import java.util.Arrays;

public class ArrayOperations {
    public static final int NEEDED_NUM = 4;
    public static final int EXPECTED_NUM1 = 1;
    public static final int EXPECTED_NUM2 = 1;
    /*
    1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив. Метод
    должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после
    последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить
    RuntimeException.
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
     то метод вернет false;
     Написать набор тестов для этого метода (по 3-4 варианта входных данных).
[ 1 1 1 4 4 1 4 4 ] -> true
[ 1 1 1 1 1 1 ] -> false
[ 4 4 4 4 ] -> false
[ 1 4 4 1 1 4 3 ] -> false

     */
    public int[] newArray(int [] arr) {
        int counter = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == NEEDED_NUM) {
                counter = i;
            }
        }
        if(counter != -1){
            int [] reArray = new int[arr.length-counter-1];
            System.arraycopy(arr, counter + 1, reArray, 0, arr.length - counter-1);
            return reArray;
        }
        else
        throw new RuntimeException();
    }
    public boolean isAnyExpectedNums(int [] arr){
        int counterNeeded = 0;
        int counterExpected = 0;
        for (int j : arr) {
            if (j == EXPECTED_NUM1) {
                counterNeeded++;
            }
            if (j == EXPECTED_NUM2) {
                counterExpected++;
            }
        }
        return (counterNeeded != 0) && (counterExpected != 0);
    }
}
