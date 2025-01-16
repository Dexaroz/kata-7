package software.ulpgc.app.swing;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.arquitecture.model.Barchart;

public class JFreeChartAdapter {
    public static JFreeChart adapt (Barchart barchart){
        return ChartFactory.createBarChart(
                barchart.title(),
                barchart.xAxis(),
                barchart.yAxis(),
                datasetOf(barchart)
        );
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String key: barchart.data().keySet()){
            dataset.addValue(barchart.data().get(key), "", key);
        }
        return dataset;
    }
}
