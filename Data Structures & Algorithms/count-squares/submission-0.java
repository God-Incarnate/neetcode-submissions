class CountSquares {

    // point frequency
    private Map<String, Integer> countMap;

    // list of all points
    private List<int[]> points;

    public CountSquares() {
        countMap = new HashMap<>();
        points = new ArrayList<>();
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        String key = x + "," + y;

        countMap.put(key,
                countMap.getOrDefault(key, 0) + 1);

        points.add(point);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int result = 0;

        for (int[] p : points) {

            int px = p[0];
            int py = p[1];

            // must form diagonal
            if (Math.abs(px - x) != Math.abs(py - y)
                || px == x
                || py == y) {
                continue;
            }

            // other two corners
            String corner1 = px + "," + y;
            String corner2 = x + "," + py;

            result += countMap.getOrDefault(corner1, 0)
                    * countMap.getOrDefault(corner2, 0);
        }

        return result;
    }
}