package Oracle;

import java.lang.reflect.Method;

public class StringClasses {
	
	public static void main(String []args) throws ClassNotFoundException
	{
		int count=0;
		Class c=Class.forName("java.lang.String");
		Method []m=c.getDeclaredMethods();
		for(Method m1:m)
		{
			count++;
			System.out.println(m1.getName());
		}
		System.out.println(count);
	}

}
