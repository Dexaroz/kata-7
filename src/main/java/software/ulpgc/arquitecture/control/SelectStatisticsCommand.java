package software.ulpgc.arquitecture.control;

import software.ulpgc.arquitecture.io.BarchartLoader;
import software.ulpgc.arquitecture.view.BarchartDisplay;
import software.ulpgc.arquitecture.view.SelectStatisticsDialog;

import java.io.IOException;

public class SelectStatisticsCommand implements Command {
    private final SelectStatisticsDialog dialog;
    private final BarchartLoader loader;
    private final BarchartDisplay display;

    public SelectStatisticsCommand(SelectStatisticsDialog dialog, BarchartLoader loader, BarchartDisplay display) {
        this.dialog = dialog;
        this.loader = loader;
        this.display = display;
    }

    @Override
    public void execute() throws IOException {
        display.show(loader.loads(dialog.getSelection()));
    }
}
