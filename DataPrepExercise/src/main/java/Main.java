import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import joinery.DataFrame;
import joinery.DataFrame.JoinType;
import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;
import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.CsvReadOptions;
import tech.tablesaw.selection.Selection;
import static tech.tablesaw.aggregate.AggregateFunctions.*;
import tech.tablesaw.joining.DataFrameJoiner;
        
public class Main {
    public static void main(String [] args) throws IOException{
        
        //using joinery
        DataFrame<Object> df = DataFrame.readCsv("data/titanic.csv");
        System.out.println(df.describe());
        
        //using tablesaw
        Table t = Table.read().usingOptions(CsvReadOptions
        .builder("data/titanic.csv")
        .missingValueIndicator(""));
        System.out.println(t.summary().toString());
        
        //Using joinery
        DataFrame<Object> df1 = DataFrame.readCsv("data/dataframe1.csv");
        DataFrame<Object> df2 = DataFrame.readCsv("data/dataframe2.csv");
        
        df2.merge(df1,JoinType.LEFT);
        
        System.out.println(df1);
        System.out.println(df2);
        
        //using tablesaw
        Table t1 = Table.read().usingOptions(CsvReadOptions
        .builder("data/dataframe1.csv")
        .missingValueIndicator(""));
        
        Table t2 = Table.read().usingOptions(CsvReadOptions
        .builder("data/dataframe2.csv")
        .missingValueIndicator(""));
        
        List<Double> list1 = Arrays.asList(new Double[]{5.0, 90.7});
        List<String> list2 = Arrays.asList(new String[]{"lake", "sea"});
        DoubleColumn nc1 = DoubleColumn.create("nc1",list1);
        StringColumn nc2 = StringColumn.create("nc2",list2);
        
        t1.addColumns(nc1);
        t2.addColumns(nc2);
        
        System.out.println(t1);
        System.out.println(t2);
        
        System.out.println(t1.joinOn("name").inner(t2, true, "name"));
        
    }
}