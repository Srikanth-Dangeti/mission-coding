package Test;

public class Testing1 {
    public static void main(String[] args) {
        try {
            throw new Exc1();
        }
        catch (Exc0 e0)
        {
            System.out.println("Exc0: ");
        }
        catch (Exception e)
        {
            System.out.println();
        }
    }
}
