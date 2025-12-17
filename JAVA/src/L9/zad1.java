package L9;

import java.util.Arrays;

public class zad1 {

    public static <T> T[] duplicate(T[] array, int[] times) {
        if (array == null || times == null) {
            throw new IllegalArgumentException("Tablice nie mogą być nullem");
        }

        if (times.length < array.length) {
            throw new IllegalArgumentException("Tablica times jest krotsza");
        }

        int resultSize = 0;
        for (int c: times) {
            if (c < 0) throw new IllegalArgumentException("Ujemny licznik");
            resultSize += c;
        }

        T[] result = Arrays.copyOf(array, resultSize);

        int currentIdx = 0;
        for (int i = 0; i < array.length; i++) {
            T value = array[i];
            int count = times[i];

            for (int k = 0; k < count; k++) {
                result[currentIdx] = value;
                currentIdx++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3};
        int[] counts1 = {0, 3, 1};

        Integer[] res1 = duplicate(numbers, counts1);
        System.out.println("Wynik dla liczb: " + Arrays.toString(res1));

        String[] words = {"Ala", "ma", "kota"};
        int[] counts2 = {2, 1, 0};

        String[] res2 = duplicate(words, counts2);
        System.out.println("Wynik dla napisów: " + Arrays.toString(res2));

        String[] tes = {"Ala", "ma", "kota"};
        int[] tes1 = {2, 1};

        String[] res3 = duplicate(tes, tes1);
        System.out.println("Wynik: " + Arrays.toString(res3));
    }
}
