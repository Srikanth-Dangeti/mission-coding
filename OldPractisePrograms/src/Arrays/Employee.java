package Arrays;
public class Employee
{
 private String name;
 private int sal;
 
 public Employee(String name, int sal)
 {
     super();
 this.name = name;
 this.sal = sal;
 }
 //Getters Setters
 public String getName()
   {
  return name;
  }
public String setName(String name)
   
 {
   return this.name = name;
}
public int getSal()
{
   return sal;
}
public int setSal(int sal)
 {
 return this.sal = sal;
 }
}