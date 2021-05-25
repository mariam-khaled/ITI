import java.util.Scanner; 

public class Main {
  public static void main(String[] args) {
      
    Scanner Obj = new Scanner(System.in);  
    System.out.println("Enter string:");
    String input = Obj.nextLine();
    
    boolean is_letters_only = true;
    
    for (int i =0; i<input.length(); i++)
    {
       if(!Character.isLetter(input.charAt(i)))
       {
           System.out.println("String doesn't contain letters only");
           is_letters_only = false;
           break;
       }
    }
    
    if(is_letters_only)
    {
        System.out.println("String contains letters only");
    }   
    
  }
}