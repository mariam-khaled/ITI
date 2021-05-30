package ToolsQA;

/**
 * Hello world!
 *
 */
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.knowm.xchart.PieSeries.PieSeriesRenderStyle;
import org.knowm.xchart.style.BoxStyler.BoxplotCalCulationMethod;

public class XChartExamples {
    public static void main(String[] args) {
        XChartExamples xChartExamples = new XChartExamples ();
        List<TitanicPassenger> allPassengers = xChartExamples.getPassengersFromJsonFile ();
        xChartExamples.plotBox (allPassengers);
        xChartExamples.plotDonut (allPassengers);
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(XChartExamples.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Read json file and return a list containing TitanicPassenger Objects
    public List<TitanicPassenger> getPassengersFromJsonFile() {
        List<TitanicPassenger> allPassengers = new ArrayList<TitanicPassenger> ();
        ObjectMapper objectMapper = new ObjectMapper ();
        objectMapper.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try (InputStream input = new FileInputStream ("titanic_csv.json")) {
            //Read JSON file
            allPassengers = objectMapper.readValue (input, new TypeReference<List<TitanicPassenger>> () {
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        return allPassengers;
    }
    
    public void plotBox(List<TitanicPassenger> passengerList) {
        //filter to get an array of passenger ages
        List<Float> pAges = passengerList.stream ().map (TitanicPassenger::getAge).limit (8).collect (Collectors.toList ());
        Float ages[] = new Float[pAges.size ()];
        ages = pAges.toArray (ages);
  
        
        BoxChart chart = new BoxChartBuilder().title("box plot demo").build();

        // Choose a calculation method
        chart.getStyler().setBoxplotCalCulationMethod(BoxplotCalCulationMethod.N_LESS_1_PLUS_1);
        chart.getStyler().setToolTipsEnabled(true);

        // Series
        chart.addSeries("Ages", Arrays.asList(ages));
        new SwingWrapper<BoxChart>(chart).displayChart();
    }
    
    public void plotDonut(List<TitanicPassenger> passengerList) {
        Map<String, Long> result =
                passengerList.stream ().collect (
                        Collectors.groupingBy (
                                TitanicPassenger::getPclass, Collectors.counting ()
                        )
                );
        
        PieChart chart = new PieChartBuilder ().width (800).height (600).title (getClass ().getSimpleName ()).build ();
        // Customize Chart
        Color[] sliceColors = new Color[]{new Color (180, 68, 50), new Color (130, 105, 120), new Color (80, 143, 160)};
        chart.getStyler ().setSeriesColors (sliceColors);
        chart.getStyler().setDefaultSeriesRenderStyle(PieSeriesRenderStyle.Donut);
        // Series
        chart.addSeries ("First Class", result.get ("1"));
        chart.addSeries ("Second Class", result.get ("2"));
        chart.addSeries ("Third Class", result.get ("3"));
        // Show it
        new SwingWrapper (chart).displayChart ();
    }

}