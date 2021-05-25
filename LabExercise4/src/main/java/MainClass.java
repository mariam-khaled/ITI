import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainClass {
    
    public static void main(String [] args) throws IOException
    {
        PyramidCSVDAO pDAO = new PyramidCSVDAO();
        
        List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("D:\\ITI\\Java\\pyramids.csv");
        LinkedList<Double> heights = new LinkedList<Double>();
        
        for(Pyramid p: pyramids)
            if(p.getHeight() !=0)
                heights.add(p.getHeight());
        
        System.out.println("Average:"+Double.toString(MainClass.calculateAvg(heights)));
        System.out.println("Median:"+Double.toString(MainClass.calculateMedian(heights)));
        System.out.println("Q1:"+Double.toString(MainClass.calculateQuartile(heights).getQ1()));
        System.out.println("Q3:"+Double.toString(MainClass.calculateQuartile(heights).getQ3()));
        System.out.println("IQR:"+Double.toString(MainClass.calculateQuartile(heights).getIQR()));
    
    }
    
    public static double calculateAvg(LinkedList<Double> heights){
        
        double sum = 0.0;
        for(int i=0; i<heights.size(); i++)
        {
            sum += heights.get(i);
        }
        return sum/heights.size();
    }
    
    public static double calculateMedian(LinkedList<Double> heights){
        
        double median;
        Collections.sort(heights);
        
        if(heights.size()%2 == 0)
            median = (heights.get(((heights.size()/2)-1))+ heights.get(((heights.size()/2)))) / 2;
        else
            median = heights.get(((int) Math.floor(heights.size()/2)));
        
        return median;
    
    }
    
    public static Quartile calculateQuartile(LinkedList<Double> heights){
        
        double Q1, Q3, IQR;
        LinkedList<Double> heights1 = new LinkedList<Double>();
        LinkedList<Double> heights2 = new LinkedList<Double>();
        
        Collections.sort(heights);
        
        if(heights.size()%2 == 0)
        {
            for(int i=0; i<(heights.size()/2); i++)
                heights1.add(heights.get(i));
            
            for(int i=heights.size()/2; i<heights.size(); i++)
                heights2.add(heights.get(i));
        }
        
        else
        {
            for(int i=0; i<Math.floor(heights.size()/2); i++)  
                heights1.add(heights.get(i));
            
            for(int i=(int) ((Math.floor(heights.size()/2))+1); i<heights.size(); i++)
                heights2.add(heights.get(i));
        }
        
        Q1 = calculateMedian(heights1);
        Q3 = calculateMedian(heights2);
        IQR = Q3-Q1;
        
        return new Quartile(Q1,Q3,IQR);
    }
}
