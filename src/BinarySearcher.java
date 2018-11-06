import java.util.Arrays;

public class BinarySearcher {

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 10, 20, 100};
        test(a, 5, 2);
        test(a, 1, 0);
        test(a, 100, 5);
        test(a, 42, -1);
        test(a, 120, -1);
        test(a, 0, -1);

        int[] b = {1, 4, 6, 65, 100};
        test(b, 0, -1);
        test(b, 1, 0);
        test(b, 2, -1);
        test(b, 4, 1);
        test(b, 5, -1);
        test(b, 6, 2);
        test(b, 10, -1);
        test(b, 65, 3);
        test(b, 70, -1);
        test(b, 100, 4);
        test(b, 200, -1);

        int[] c = {1, 4, 6, 65, 100, 110};
        test(c, 0, -1);
        test(c, 1, 0);
        test(c, 2, -1);
        test(c, 4, 1);
        test(c, 5, -1);
        test(c, 6, 2);
        test(c, 10, -1);
        test(c, 65, 3);
        test(c, 70, -1);
        test(c, 100, 4);
        test(c, 105, -1);
        test(c, 110, 5);
        test(c, 200, -1);

        test(new int[]{}, 42, -1);
        test(new int[]{42}, 0, -1);
        test(new int[]{42}, 42, 0);
        test(new int[]{42}, 100, -1);

        test(new int[]{10, 20}, 0, -1);
        test(new int[]{10, 20}, 10, 0);
        test(new int[]{10, 20}, 15, -1);
        test(new int[]{10, 20}, 20, 1);
        test(new int[]{10, 20}, 25, -1);
    }

    //найти в массиве 'a' значение 'value', вернуть индекс или -1, если не найдено.

    public static int binarySearch(int[] a, int value, int left, int right) {
        //ищем значение от индекса l до индекса r
        if (right < left)
            return -1;
        int mid = (right - left) / 2 + left;
        if (a[mid] == value)
            return mid;
        else if (value > a[mid])
            return binarySearch(a, value, mid + 1, right);
        else
            return binarySearch(a, value, left, mid - 1);

    }

    public static int binarySearch(int[] a, int value) {
        return binarySearch(a, value, 0, a.length - 1);
    }

    public static void test(int[] a, int value, int correctAnswer) {
        System.out.println("Looking for " + value + " in " + Arrays.toString(a));
        int actualAnswer = binarySearch(a, value);
        if (actualAnswer == correctAnswer)
            System.out.println("OK");
        else
            System.out.println("Got " + actualAnswer + " instead of " + correctAnswer);
    }
}
