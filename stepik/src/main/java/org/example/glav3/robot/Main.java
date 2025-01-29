package org.example.glav3.robot;

import java.util.Base64;

public class Main {

    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();

        Direction directionX = (toX - x > 0) ? Direction.RIGHT : Direction.LEFT;
        Direction directionY = (toY - y > 0) ? Direction.UP : Direction.DOWN;

        while (directionX != robot.getDirection()) {
            robot.turnLeft();
        }
        while (robot.getX() != toX) {
            robot.stepForward();
        }

        while (directionY != robot.getDirection()) {
            robot.turnLeft();
        }
        while (robot.getY() != toY) {
            robot.stepForward();
        }
    }
}
