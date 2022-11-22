package Others;
public class CharacterIsNumberOrDigitTest {
   public static void main(String[] args) {
      String str = "Tutorials123";
      for(int i=0; i < str.length(); i++) {
         Boolean flag = Character.isDigit(str.charAt(i));
         if(flag) {
            System.out.println("'"+ str.charAt(i)+"' is a number");
         }
         else {
            System.out.println("'"+ str.charAt(i)+"' is a letter");
         }
      }
   }
}