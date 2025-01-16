package software.ulpgc.arquitecture.control;

import java.io.IOException;

public interface Command {
    void execute() throws IOException;
}
