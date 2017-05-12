
public class BankAccountTester
{
	public static void main(String[] args)
	{
		BankAccount[] mygroup = new BankAccount[10];
		
		mygroup[0] = new BankAccount("Hieu Pham", 100285.59, 0.05);
		mygroup[1] = new BankAccount("Liu Kang", 79485.67, 0.07);
		mygroup[2] = new BankAccount("Barrack Obama", 805865.97, 0.09);
		mygroup[3] = new BankAccount("Jacque Chirac", 1220735.77, 0.15);
		mygroup[4] = new BankAccount("James Bond", 274572.59, 0.03);
		mygroup[5] = new BankAccount("Owahtagu Siam", 397545.89, 0.06);
		mygroup[6] = new BankAccount("Laura Heinz", 997548.96, 0.23);
		mygroup[7] = new BankAccount("Jenna Nguyen", 979462.85, 0.33);
		mygroup[8] = new BankAccount("Andrew Pham", 1000285.35, 0.45);
		mygroup[9] = new BankAccount("Alyssa Pham", 2339885.59, 0.25);
		
		for(BankAccount TBA : mygroup)
        {
            TBA.addInterest();            
        }
		
		for(BankAccount TBB : mygroup)
        {            
            System.out.print(TBB.getName() + ", ");
            System.out.format("$%.2f%n", TBB.getBalance());            
        }
	}
}
