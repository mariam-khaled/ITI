
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CountryDAO {
    
    public Country createCountry(String [] metadata)
    {   
        int code = Integer.parseInt(metadata[0]);
        Country country = new Country(code, metadata[1]);
        return country;
    }
    
    public List<Country> readCountriesFromCSV(String fileName) throws IOException 
    {   
        List<Country> contriesInfo = new ArrayList();
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
                    Country country = createCountry(data);
                    contriesInfo.add(country);
                   
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
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
            try
            {
                csvReader.close();
            } catch (IOException ex) {
                Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return contriesInfo;
    }
    
}
