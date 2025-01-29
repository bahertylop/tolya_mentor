package org.example.glav4.part2;

public class RobotConnectionManagerImpl implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
//        throw new RobotConnectionException("");
        return new RobotConnectionImpl();
    }
}
