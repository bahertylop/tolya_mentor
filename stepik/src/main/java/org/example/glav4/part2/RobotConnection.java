package org.example.glav4.part2;

import java.util.zip.DataFormatException;

public interface RobotConnection extends AutoCloseable {

    void moveRobotTo(int x, int y);
    @Override
    void close();
}