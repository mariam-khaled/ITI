
public class City implements java.lang.Comparable<City> {
    
    int code;
    String name;
    String continent;
    float area;
    double population;

    public City(int code, String name, String continent, float area, double population) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.area = area;
        this.population = population;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public float getArea() {
        return area;
    }

    public Double getPopulation() {
        return population;
    }
    
    public String toString()
    { 
        return this.code+","+this.name+","+this.continent+","+this.area+","+this.population;  
    }  
    
    @Override
    public int compareTo(City c) {
        return this.getPopulation().compareTo(c.getPopulation());
    }
    
}
