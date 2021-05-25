
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PyramidCSVDAO {

    public Pyramid createPyramid(String [] metadata)
    {   
        double height = 0;
        if(!metadata[7].isEmpty() && metadata[7]!=null)
             height = Double.parseDouble(metadata[7]);
        
        Pyramid pyramid = new Pyramid(metadata[0], metadata[2], metadata[4], height);
        return pyramid;
    }
    
    public List<Pyramid> readPyramidsFromCSV(String fileName) throws IOException 
    {   
        List<Pyramid> pyramidsInfo = new ArrayList();
        BufferedReader csvReader = null;
        try 
        {
            csvReader = new BufferedReader(new FileReader(fileName));
            String line;
            boolean first = true;
            while ((line = csvReader.readLine()) != null) {
                
                if(!first)
                {
                    String[] data = line.split(",");
                    Pyramid pyramid = createPyramid(data);
                    pyramidsInfo.add(pyramid);
                   
                }
                
                else if(first)
                {   
                    String[] data = line.split(",");
                    System.out.println(data[0]+","+data[2]+","+data[4]+","+data[7]);
                    first = false;
                }
               
            }   
        } 
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
            try
            {
                csvReader.close();
            } catch (IOException ex) {
                Logger.getLogger(PyramidCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return pyramidsInfo;
    }
}
