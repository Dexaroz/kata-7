package software.ulpgc.app.swing;

import org.jfree.chart.JFreeChart;
import software.ulpgc.arquitecture.model.Barchart;
import software.ulpgc.arquitecture.view.BarchartDisplay;
import org.jfree.chart.ChartPanel;

import javax.swing.*;

import java.awt.*;

public class JFreeBarchartDisplay  extends JPanel implements BarchartDisplay {

    public JFreeBarchartDisplay(){
        setLayout(new BorderLayout());
    }

    @Override
    public void show(Barchart barchart) {
        removeAll();
        add(new ChartPanel(adapt(barchart)));
        revalidate();
    }

    private JFreeChart adapt(Barchart barchart){
        return JFreeChartAdapter.adapt(barchart);
    }
}
