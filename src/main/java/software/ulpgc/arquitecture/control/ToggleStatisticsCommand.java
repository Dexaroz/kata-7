package software.ulpgc.arquitecture.control;

import software.ulpgc.arquitecture.io.BarchartLoader;
import software.ulpgc.arquitecture.view.BarchartDisplay;

import java.io.IOException;

public class ToggleStatisticsCommand implements Command {
    private final BarchartDisplay display;
    private final BarchartLoader loader;
    private int i = 0;

    public ToggleStatisticsCommand(BarchartDisplay display, BarchartLoader loader) {
        this.display = display;
        this.loader = loader;
    }
    @Override
    public void execute() throws IOException {
        display.show(loader.loads(i++ %2));
    }
}
