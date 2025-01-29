package org.example.glav4.part2;

public class RobotConnectionImpl implements RobotConnection {

    public static int u = 0;

    @Override
    public void moveRobotTo(int x, int y) {
        if (u < 2) {
            u++;
            throw new RobotConnectionException("exception in moveRobotTo");
        }

    }

    @Override
    public void close() {
        throw new RobotConnectionException("exception in close");
//        System.out.println("Закрытие подключения");
    }
}
