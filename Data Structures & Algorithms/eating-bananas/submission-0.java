class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);
        int answer = right;

        while (left <= right) {
            int midSpeed = left + (right - left) / 2;

            if (canFinish(piles, h, midSpeed)) {
                answer = midSpeed;
                right = midSpeed - 1;
            } else {
                left = midSpeed + 1; 
            }
        }

        return answer;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        long totalHours = 0;

        for (int pile : piles) {
            totalHours += (pile + speed - 1) / speed;
        }

        return totalHours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}