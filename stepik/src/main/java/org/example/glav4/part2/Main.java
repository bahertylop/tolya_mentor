package org.example.glav4.part2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RobotConnectionManager robotConnectionManager = new RobotConnectionManagerImpl();
//        moveRobot(robotConnectionManager, 0, 0);
        moveRobot2(robotConnectionManager, 0, 0);
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int maxAttempts = 3;
        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()) {
                robotConnection.moveRobotTo(toX, toY);
                i = maxAttempts;
            } catch (RobotConnectionException e) {
                if (i == maxAttempts - 1) {
                    throw e;
                }
            }
        }
    }

    public static void moveRobot2(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int tries = 3;
        for (int i = 0; i < tries; i++) {
            RobotConnection robotConnection = null;
            try {
                robotConnection = robotConnectionManager.getConnection();
                robotConnection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {
                // на третий раз исключение пробрасывается
                if (i == 2) {
                    throw e;
                }
            } finally {
                if (robotConnection != null) {
                    try {
                        robotConnection.close();
                    } catch (Exception ignored) {

                    }
                }
            }
        }
    }

}
