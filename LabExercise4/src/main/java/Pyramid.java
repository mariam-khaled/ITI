
public class Pyramid implements java.lang.Comparable<Pyramid>{
    
    private String pharaoh;
    private String modern_name;
    private String site;
    private double height;

    public Pyramid(String pharaoh, String modern_name, String site, double height) {
        setPharaoh(pharaoh);
        setModern_name(modern_name);
        setSite(site);
        setHeight(height);
    }
    
    public String getPharaoh() {
      return pharaoh;
    }

    public String getModern_name() {
        return modern_name;
    }

    public String getSite() {
        return site;
    }

    public Double getHeight() {
        return height;
    }
    
    public void setPharaoh(String pharaoh) {
        
        if((pharaoh != null) && (!pharaoh.isEmpty()) )
        {
            if(pharaoh.getClass().getSimpleName() == "String")
                this.pharaoh = pharaoh;
            else
                this.pharaoh = pharaoh.toString();
        }
        else
        {
               this.pharaoh = "missing";
        }
     
    }

    public void setModern_name(String modern_name) {
        if((modern_name != null) && (!modern_name.isEmpty()) )
        { 
            if(modern_name.getClass().getSimpleName() == "String")
                this.modern_name = modern_name;
            else
                this.modern_name = modern_name.toString();
        }
        else
        {
               this.modern_name = "missing";
        }
    }

    public void setSite(String site) {
        if((site != null) && (!site.isEmpty()) )
        { 
            if(site.getClass().getSimpleName() == "String")
                this.site = site;
            else
                this.site = site.toString();
        }
        else
        {
               this.site = "missing";
        }
    }

    public void setHeight(double height) {
       this.height = height;
    }
    
    public String toString()
    { 
        return this.pharaoh+","+this.modern_name+","+this.site+","+this.height;  
    }  
    
    @Override
    public int compareTo(Pyramid p) {
        return this.getHeight().compareTo(p.getHeight());
    }
  
}
