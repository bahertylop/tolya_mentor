package org.example.glav3.robot;


import jdk.dynalink.Operation;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Main {

    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();

        Direction directionX = (toX - x > 0) ? Direction.RIGHT : Direction.LEFT;
        Direction directionY = (toY - y > 0) ? Direction.UP : Direction.DOWN;

        turnRobot(robot, directionX);
        cycleRobotStep(robot, Math.abs(toX - x));

        turnRobot(robot, directionY);
        cycleRobotStep(robot, Math.abs(toY - y));
    }

    public static void turnRobot(Robot robot, Direction neededDirection) {
        while (neededDirection != robot.getDirection()) {
            robot.turnLeft();
        }
    }

    public static void cycleRobotStep(Robot robot, int countSteps) {
        while (countSteps-- != 0) {
            robot.stepForward();
        }
    }
}
