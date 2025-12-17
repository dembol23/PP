package L9;

import java.util.Arrays;

public class zad2 {

    public static <T extends Comparable<T>> boolean check(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i-1].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> T[] insert(T[] array, T elem) {
        if (array == null || elem == null) {
            throw new IllegalArgumentException("Argumenty nie mogą być nullem");
        }

        if (!check(array)) {throw new IllegalArgumentException("Podano błędne argumenty");}

        int resultSize = array.length + 1;
        T[] result = Arrays.copyOf(array, array.length + 1);

        int j = 0;
        boolean inserted = false;
        for (int i = 0; i < resultSize; i++) {
            if (!inserted && (j >= array.length || array[j].compareTo(elem) > 0)) {
                result[i] = elem;
                inserted = true;
            }
            else {
                result[i] = array[j++];
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 3, 5, 7};
        System.out.println(Arrays.toString(insert(nums, 0)));
        String[] chars = {"E", "C", "E"};
        System.out.println(Arrays.toString(insert(chars, "D")));
    }
}
