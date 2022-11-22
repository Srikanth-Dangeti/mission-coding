package Test;

public class SingleTon {
	
	private static SingleTon instance;
	
	private SingleTon()
	{
		
	}
	
	
	public static SingleTon getInstance()
	{
		
		
		if(instance == null)
			return instance =new SingleTon();
		else
			return instance ;
	}
	
	
	public static void main(String [] args)
	{
		
		System.out.println(getInstance()); //Test.SingleTon@7852e922
	}

}

/*

select max(column)as highest from table where highest <(select max(column) 1sthighest from table );





*/