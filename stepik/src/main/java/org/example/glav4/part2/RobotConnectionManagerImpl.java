package org.example.glav4.part2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.SimpleFormatter;

public class RobotConnectionManagerImpl implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
//        throw new RobotConnectionException("");
        return new RobotConnectionImpl();
    }
}
