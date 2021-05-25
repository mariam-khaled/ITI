public class StringUtils {
    
    static String betterString(String s1, String s2, Comparison comp)
    {
        if (comp.compare(s1, s2))
            return s1;
        else
            return s2;
    }
    
}
