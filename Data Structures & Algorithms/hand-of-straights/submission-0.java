class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {

        // Total cards must divide evenly
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Frequency count
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Process smallest card each time
        while (!map.isEmpty()) {

            int first = map.firstKey();

            // Try forming one group
            for (int i = 0; i < groupSize; i++) {

                int current = first + i;

                // Missing card
                if (!map.containsKey(current)) {
                    return false;
                }

                // Decrease frequency
                map.put(current, map.get(current) - 1);

                // Remove if exhausted
                if (map.get(current) == 0) {
                    map.remove(current);
                }
            }
        }

        return true;
    }
}