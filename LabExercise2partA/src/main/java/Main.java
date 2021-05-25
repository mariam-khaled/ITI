public class Main {
    
    public static void main (String [] args)
    {
        String str1 = "hello world";
        String str2 = "hello";
        
        String longer = StringUtils.betterString(str1, str2, (s1, s2)-> s1.length()>s2.length());
        System.out.println(longer);
        
        String first = StringUtils.betterString(str1, str2, (s1,s2)->true);
        System.out.println(first);
    }
    
}
