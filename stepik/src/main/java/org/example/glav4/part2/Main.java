package org.example.glav4.part2;

import java.util.Objects;

public class Main {

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) throws RobotConnectionException {

        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConnection = robotConnectionManager.getConnection()){
                robotConnection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {
                if (i == 2) {
                    throw new RobotConnectionException("message");
                }
            } catch (Exception e) {
                return;
            }
        }
    }

}
