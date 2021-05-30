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
        
        List<Country> countries = countryDAO.readCountriesFromCSV("data/countries.csv");
        List<City> cities = cityDAO.readCitiesFromCSV("data/cities.csv");
        
        Information info = new Information(countries, cities);
        
        info.highestPopulationCityPerCountry();
        System.out.println("+++++++++++");
        info.highestPopulationCityPerContinent();
        System.out.println("+++++++++++");
        info.highestPopulationCapital();
    
    }
    
}