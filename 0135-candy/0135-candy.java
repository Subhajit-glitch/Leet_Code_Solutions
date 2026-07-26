public class Solution {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println("Minimum candies: " + candy(ratings));
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // everyone starts with 1 candy

        // Left to right: satisfy "left neighbor" condition
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left: satisfy "right neighbor" condition
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum up all candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }
}