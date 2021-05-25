public class Country  {
    
    int code;
    String name;
    String capital;
    
    public Country(int code, String name, String capital) {
        this.code = code;
        this.name = name;
        this.capital = capital;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    
    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }
    
    
    
}
