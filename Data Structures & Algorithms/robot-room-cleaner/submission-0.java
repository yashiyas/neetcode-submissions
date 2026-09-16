class Solution {

    int[][] directions = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    Set<String> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0);
    }

    private void clean(Robot robot, int x, int y, int dir) {

        robot.clean();
        visited.add(getKey(x, y));

        for (int i = 0; i < 4; i++) {

            int newDir = (dir + i) % 4;

            int newX = x + directions[newDir][0];
            int newY = y + directions[newDir][1];

            String key = getKey(newX, newY);

            if (!visited.contains(key) && robot.move()) {

                clean(robot, newX, newY, newDir);

                goBack(robot);
            }

            robot.turnRight();
        }
    }

    private void goBack(Robot robot) {

        robot.turnRight();
        robot.turnRight();

        robot.move();

        robot.turnRight();
        robot.turnRight();
    }

    private String getKey(int x, int y) {
        return x + "|" + y;
    }
}