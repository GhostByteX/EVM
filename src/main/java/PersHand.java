import java.sql.SQLException;

public abstract class PersHand {

	PersHand() {
	}
	abstract public void addCandidate(String c, String n, int v,String p,String a) throws ClassNotFoundException, SQLException;
	abstract public void addParty(String n) throws SQLException, ClassNotFoundException;
	abstract public void addVoter(String c, String n, int a, String add) throws ClassNotFoundException, SQLException;
	abstract public boolean castVote(String n) throws ClassNotFoundException, SQLException;
	abstract public void showCandidates() throws ClassNotFoundException, SQLException;
	abstract public void displayresults() throws ClassNotFoundException, SQLException;
	
	
	
}