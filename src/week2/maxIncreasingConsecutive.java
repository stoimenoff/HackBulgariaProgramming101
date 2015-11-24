package week2;

/**
 * Created by georgipavlov on 24.11.15.
 */
public class maxIncreasingConsecutive {
    private static int maxIncreasingConsecutive(int[] items){
        if (items.length == 0)
            return 0;

        int max = 0;
        int temp = 0;
        int element = items[0];

        for (int item : items) {
            temp = item >= element ? ++temp : 1;
            element = item;
            if (temp > max) {
                max = temp;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxIncreasingConsecutive(new int[]{}));
        System.out.println(maxIncreasingConsecutive(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5}));
    }
}
