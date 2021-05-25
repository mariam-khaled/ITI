
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityDAO {

    public City createCity(String [] metadata)
    {   
        int code = Integer.parseInt(metadata[0]);
        float area = Float.parseFloat(metadata[3]);
        double population = Double.parseDouble(metadata[4]);
        City city = new City(code, metadata[1], metadata[2], area, population);
        return city;
    }
    
    public List<City> readCitiesFromCSV(String fileName) throws IOException 
    {   
        List<City> citiesInfo = new ArrayList();
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
                    City city = createCity(data);
                    citiesInfo.add(city);
                   
                }
                
                else if(first)
                {   
                    first = false;
                    continue;
                }
               
            }   
        } 
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
            try
            {
                csvReader.close();
            } catch (IOException ex) {
                Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return citiesInfo;
    }
}

    

