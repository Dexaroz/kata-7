package model;

import java.awt.*;

public class Game {
    private String title;
    private String console;
    private int total_sale;

    public Game(String title, String console, int total_sale) {
        this.title = title;
        this.console = console;
        this.total_sale = total_sale;
    }

    public String getTitle() {
        return title;
    }

    public String getConsole() {
        return console;
    }

    public int getTotal_sale() {
        return total_sale;
    }

    @Override
    public String toString() {
        return "Game{" +
                ", title='" + title + '\'' +
                ", console='" + console + '\'' +
                ", total_sale=" + total_sale +
                '}';
    }
}
