package org.example.glav3.robot;

import java.util.Base64;

public class Main {

    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();
        if (toX - x > 0) {
            if (robot.getDirection().equals(Direction.UP)) {
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.DOWN)) {
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnLeft();
                robot.turnLeft();
            }
         } else {
            if (robot.getDirection().equals(Direction.UP)) {
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.DOWN)) {
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.RIGHT)) {
                robot.turnLeft();
                robot.turnLeft();
            }
        }
        for (int i = 0; i < Math.abs(toX - x); i++) {
            robot.stepForward();
        }

        if (toY - y > 0) {
            if (robot.getDirection().equals(Direction.RIGHT)) {
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.DOWN)) {
                robot.turnLeft();
                robot.turnLeft();
            }
        } else {
            if (robot.getDirection().equals(Direction.LEFT)) {
                robot.turnLeft();
            } else if (robot.getDirection().equals(Direction.RIGHT)) {
                robot.turnRight();
            } else if (robot.getDirection().equals(Direction.UP)) {
                robot.turnLeft();
                robot.turnLeft();
            }
        }
        for (int i = 0; i < Math.abs(toY - y); i++) {
            robot.stepForward();
        }
    }
}
