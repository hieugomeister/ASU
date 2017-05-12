/*
 *Simple collection with built-in array
 *@Hieu Pham
 */
public class Student
{
	private String name, SSN, Duty;
	private int age;
	
	
	public Student(String nm, String ssn, String jb, int a) // Constructor, default
	{
		name = nm;		
		SSN = ssn;
		Duty = jb;
		age = a;
	}	
	
    public String getName()
    {
        return(name);
    }
    
    public int getAge()
    {
        return(age);
    }
    
    public String getSSN()
    {
        return(SSN);
    }

    public String getDuty()
    {
        return(Duty);
    }
    
    public void setName(String TheName)
    {
        this.name = TheName;
    }
    
    public void setAge(int TheAge)
    {
        this.age = TheAge;
    }
    
    public void setSSN(String TheSSN)
    {
        this.SSN = TheSSN;
    }
    
    public void setDuty(String TheDuty)
    {
        this.Duty = TheDuty;
    }    
}