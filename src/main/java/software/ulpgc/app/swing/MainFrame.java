package software.ulpgc.app.swing;

import software.ulpgc.arquitecture.control.Command;
import software.ulpgc.arquitecture.view.BarchartDisplay;
import software.ulpgc.arquitecture.view.SelectStatisticsDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private JFreeBarchartDisplay barchartDisplay;
    private SelectStatisticsDialog selectStatisticDialog;

    public MainFrame() throws HeadlessException {
        this.setTitle("Kata 3");
        this.setSize(1024,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(BorderLayout.NORTH, toolbar());
        this.add(barchartDisplay = statisticPanel());
        this.commands = new HashMap<>();
    }

    public void put(String name, Command command) {
        commands.put(name, command);
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(toggle());
        panel.add(selector());
        return panel;
    }

    private Component selector() {
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Generations");
        comboBox.addItem("Number of abilities");
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() != ItemEvent.SELECTED) return;
                try {
                    commands.get("select").execute();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        selectStatisticDialog = new SelectStatisticsDialog() {
            @Override
            public int getSelection() {
                return comboBox.getSelectedIndex();
            }
        };
        return comboBox;
    }

    private JButton toggle() {

        JButton button = new JButton("toggle");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    commands.get("toggle").execute();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        return button;
    }

    private JFreeBarchartDisplay statisticPanel() {
        return new JFreeBarchartDisplay();
    }


    public BarchartDisplay barchartDisplay() {
        return barchartDisplay;
    }

    public SelectStatisticsDialog selectStatisticDialog() {
        return selectStatisticDialog;
    }
}