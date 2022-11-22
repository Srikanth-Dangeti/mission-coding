package Oracle;
import java.util.HashMap;
import java.util.Scanner;

public class DateDiff 
{
	static HashMap<String,Integer> hash_map = new HashMap<String,Integer>();
	static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

static class Date
{
	int dd,mm,yy;
	Date(String dd,String mm,String yy)
	{
		System.out.println();
		this.dd = Integer.parseInt(dd);
		this.mm = hash_map.get(mm.toLowerCase());
		this.yy = Integer.parseInt(yy);
	}
}
static int countLeapYears(Date d) 
{ 
   int years = d.yy; 
 
   if (d.mm <= 2) 
       years--; 

   return years / 4 - years / 100 + years / 400; 
} 

static int getDifference(Date dt1, Date dt2) 
{ 
    int n1 = dt1.yy*365 + dt1.dd; 
 
   for (int i=0; i<dt1.mm - 1; i++) 
   {
       n1 += monthDays[i]; 
   }
   	   n1 += countLeapYears(dt1); 
 
 
   int n2 = dt2.yy *365 + dt2.dd; 
   for (int i=0; i<dt2.mm - 1; i++) 
   {
       n2 += monthDays[i]; 
   }
   
   n2 += countLeapYears(dt2); 
 
   return (n2 - n1); 
}

public static void fillUp()
{
	hash_map.put("jan",1);
	hash_map.put("feb",2);
	hash_map.put("mar",3);
	hash_map.put("apr",4);
	hash_map.put("may",5);
	hash_map.put("jun",6);
	hash_map.put("jul",7);
	hash_map.put("aug",8);
	hash_map.put("sep",9);
	hash_map.put("oct",10);
	hash_map.put("nov",11);
	hash_map.put("dec",12);
}
public static void main(String args[])
{
   System.out.print("Insert first date: ");
   Scanner s = new Scanner(System.in);
   String[] insert1 = new String[3];
   String str1= s.next();
   insert1 = str1.split("-");
   
   System.out.print("Insert second date: ");
   String str2 = s.next();
   String[] insert2 = new String[3];
   insert2 = str2.split("-");
  
   fillUp();
   
	Date dt1 = new Date(insert1[0],insert1[1],insert1[2]);
	Date dt2 = new Date(insert2[0],insert2[1],insert2[2]);
	System.out.println(getDifference(dt1, dt2));

}


}