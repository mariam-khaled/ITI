import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

public class Main{
    
    public static void main(String [] args) throws IOException
    {
        CountryDAO countryDAO = new CountryDAO();
        CityDAO cityDAO = new CityDAO();
        
        List<Country> countries = countryDAO.readCountriesFromCSV("D:\\ITI\\Java\\countries.csv");
        List<City> cities = cityDAO.readCitiesFromCSV("D:\\ITI\\Java\\cities.csv");
        
        HashMap<Integer,LinkedList<City> > map = new HashMap<Integer,LinkedList<City>>();
        
        for(Country co : countries)
        {   
            LinkedList<City> addedCities = new LinkedList<City>();
            for(City ci : cities)
            {   
                if(co.code == ci.code)
                    addedCities.add(ci);
            }
            map.put(co.code, addedCities);
        }
        
        for (Map.Entry<Integer,LinkedList<City> > entry : map.entrySet())
             Collections.sort(entry.getValue(), Collections.reverseOrder());
                             
        for (Map.Entry<Integer,LinkedList<City> > entry : map.entrySet())
            for(City ci : entry.getValue())
                System.out.println(ci);
                
    
    }
    
}