
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Information {
    
    List<Country> countries;
    List<City> cities;
    
    public Information(List<Country> countries, List<City> cities) {
        this.countries = countries;
        this.cities = cities;
    }
    
    public void highestPopulationCityPerCountry(){
        
        HashMap<Integer,LinkedList<City> > map = new HashMap<Integer,LinkedList<City>>();
        
        for(Country co : this.countries)
        {   
            LinkedList<City> addedCities = new LinkedList<City>();
            for(City ci : this.cities)
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
            {
                System.out.println(ci);
                break;
            }
    }
    
    public void highestPopulationCityPerContinent(){
        
        HashMap<String, LinkedList<City> > map = new HashMap<String, LinkedList<City>>();
     
        for(City ci : this.cities)
        {   
            LinkedList<City> addedCities = new LinkedList<City>();
            for(City cit : this.cities)
            {   
                if(ci.continent.equals(cit.continent))
                    addedCities.add(cit);
            }
            map.put(ci.continent, addedCities);
        }
        
       
        for (Map.Entry<String,LinkedList<City> > entry : map.entrySet())
             Collections.sort(entry.getValue(), Collections.reverseOrder());
                             
        for (Map.Entry<String,LinkedList<City> > entry : map.entrySet())
            for(City ci : entry.getValue())
            {
                System.out.println(ci);
                break;
            }
    
    }
    
    public void highestPopulationCapital(){
        
        LinkedList<City> capitals = new LinkedList<City>();
        
        for (Country co: this.countries)
            for(City ci: this.cities)
                if(co.capital.equals(ci.name))
                    capitals.add(ci);
        
        Collections.sort(capitals, Collections.reverseOrder());
        
        for(City ca: capitals)
        {
            System.out.println(ca);
            break;
        }
        
    }
    
}
