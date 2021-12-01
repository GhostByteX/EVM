import java.sql.SQLException;

public class Main {

	public static void main(String[]args) throws ClassNotFoundException, SQLException
	{
	
	Party objP= new Party();
	Candidate objC= new Candidate();
	Voters objV=new Voters();
	PersHand objPers=new MySQL();
	objPers.displayresults();
	}
	
}
