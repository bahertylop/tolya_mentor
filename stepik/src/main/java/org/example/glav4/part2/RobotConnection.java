package org.example.glav4.part2;

public interface RobotConnection extends AutoCloseable {

    void moveRobotTo(int x, int y);
    @Override
    void close();
}