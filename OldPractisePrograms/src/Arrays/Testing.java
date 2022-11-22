package Arrays;
import java.util.ArrayList;


public class Testing 
{
	
public static void main(String[] args) {
ArrayList <Employee> emp = new ArrayList<>();
emp.add(new Employee("abc", 1000));
emp.add(new Employee("xyz", 2000));
//int total = emp.stream().collect();
//System.out.println(total);
emp.stream().filter(a -> a.getSal()>1000).forEach(System.out::println);
}
}
