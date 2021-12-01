import java.sql.*;
class MySQL extends PersHand{
	
	public void addCandidate(String c, String n, int v, String p,String a) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		String sql="INSERT INTO Candidate(CNIC,Name,Votes,Party,Area) VALUES(?,?,?,?,?)";
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1,c);
		statement.setString(2, n);
		statement.setInt(3, v);
		statement.setString(4,p);
		statement.setString(5,a);
		int rowsInserted=statement.executeUpdate();
		if(rowsInserted>0)
		{
			System.out.print("A New Candidate Successfully Added to the Database\n");
		}
	}

	public void addParty(String n) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		String sql="INSERT INTO Party(Name) VALUES(?)";
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1,n);
		int rowsInserted=statement.executeUpdate();
		if(rowsInserted>0)
		{
			System.out.print("A New Party Successfully Added to the Database\n");
		}
	}
	
	@SuppressWarnings("unused")
	public boolean castVote(String n) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
	//	PreparedStatement pstmt=con.prepareStatement("select* from Candidate Where Name=?");
		//pstmt.setString(1,n);
		//ResultSet rs=pstmt.executeQuery();
		String selectSql = "SELECT * FROM Candidate";
		Statement statement = con.createStatement(ResultSet.TYPE_FORWARD_ONLY,
				ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = statement.executeQuery(selectSql);
		
		
		while(rs.next())
		{
			String temp=rs.getString("Name");
			if (temp.compareToIgnoreCase(n)==0)
			{
				int newcount=rs.getInt(3)+1;
				rs.updateDouble(3, newcount);
				rs.updateRow();
			}
		}
		return true;
	}
	
	public void addVoter(String c, String n, int a, String add) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		String sql="INSERT INTO Voters(CNIC,Name,Age,Address) VALUES(?,?,?,?)";
		PreparedStatement statement=con.prepareStatement(sql);
		statement.setString(1,c);
		statement.setString(2, n);
		statement.setInt(3, a);
		statement.setString(4,add);
		int rowsInserted=statement.executeUpdate();
		if(rowsInserted>0)
		{
			System.out.print("A New Voter Successfully Added to the Database\n");
		}
	}
	
	public void showCandidates() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select Name, Party from Candidate");
		
		System.out.print("\n 		CANDIDATES\n\n");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"               "+rs.getString(2)+"\n");
		}
		
	}


	public void displayresults() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/evm","root","usmanmalik740");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select* from Candidate");
		
		System.out.print("\n 		CANDIDATES\n\n");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"               "+rs.getString(2)+"               "+rs.getString(3)+"               "+rs.getString(4)+"               "+rs.getString(5)+"\n");
		}
	}
	
}