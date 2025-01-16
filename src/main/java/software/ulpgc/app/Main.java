package software.ulpgc.app;

import software.ulpgc.app.swing.MainFrame;
import software.ulpgc.arquitecture.control.SelectStatisticsCommand;
import software.ulpgc.arquitecture.control.ToggleStatisticsCommand;
import software.ulpgc.arquitecture.io.PokemonBarchartLoader;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static software.ulpgc.arquitecture.io.CsvDownloader.downloadCsv;

public class Main {
    public static void main(String[] args) throws IOException {
        File path = new File("");
        String Path = path.getAbsolutePath();
        String urlInput = "https://raw.githubusercontent.com/Carlosqchao/Resources/refs/heads/main/pokedex_(Update.04.20).csv";
        String outputPath = Path + "\\pokedex_(Update.04.20).csv";
        downloadCsv(urlInput,outputPath);
        File file = new File("pokedex_(Update.04.20).csv");
        MainFrame mainFrame = new MainFrame();
        PokemonBarchartLoader loader = new PokemonBarchartLoader();
        mainFrame.put("toggle",new ToggleStatisticsCommand(mainFrame.barchartDisplay(), loader));
        mainFrame.put("select",new SelectStatisticsCommand(mainFrame.selectStatisticDialog(), loader, mainFrame.barchartDisplay()));
        mainFrame.barchartDisplay().show(loader.loads(0));
        mainFrame.setVisible(true);
        mainFrame.setIconImage(new ImageIcon("pokemon.png").getImage());
    }
}
