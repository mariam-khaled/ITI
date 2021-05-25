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
        
        Information info = new Information(countries, cities);
        
        info.highestPopulationCityPerCountry();
        info.highestPopulationCityPerContinent();
        info.highestPopulationCapital();
    
    }
    
}