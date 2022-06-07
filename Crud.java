package Java2MySQL;
import java.sql.*;
import java.util.Scanner;
public class Crud 
{
	public static void main(String[] args) 
	{
		String data = null;
		System.out.println("\t ...Welcome Buddy... \t");
		//String dbc = "jdbc:mysql://localhost:3306/peace","root","Kannan26@";
		//String dbc = "jdbc:mysql://localhost:3306;" + "database=peace;" + "user=root;" + "password=Kannan26@;";
		//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peace","root","Kannan26@");
		/*Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/peace","root","Kannan26@");
		Statement stt=conn.createStatement();
		ResultSet rss=stt.executeQuery("select* from NATIVE");
		while(rss.next())
		{
		System.out.println(rss.getString(1)+"\t"+rss.getString(2)+"\t"+rss.getString(3));
		}*/
		/*String dbURL = "jdbc:mysql://localhost:3306/peace";
		String username= "root";
		String password= "Kannan26@";*/
		try
		{
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peace","root","Kannan26@");
			if (con != null) {
				System.out.println("\t... Database Connected ...\t");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	do
	{	
		System.out.println("\t Select the option from below MENU... \t");
		System.out.println("\t... Put 1 to select Data ... \t \n \t... Put 2 to insert Data ... \t \n \t... Put 3 to update Data ... \t \n \t... Put 4 to delete Data ... \t");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input= sc.nextLine();
		
		switch (input)
		{
		case "1":
			try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peace","root","Kannan26@"))
			{
				Statement st=con.createStatement();
				ResultSet rs1=st.executeQuery("select* from employee");
				while(rs1.next())
				{
					System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4)+"\t"+rs1.getString(5)+"\t"+rs1.getString(6));
				}
			}
			catch(Exception e)
			{
				System.out.println(e.toString());
			}
			break;
		
		case "2":
			try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peace","root","Kannan26@"))
			{
				/*System.out.println("Enter Employee Name");
				var E_Name = sc.nextLine();
				System.out.println("Enter Employee ID");
				int E_Id = sc.nextInt();
				System.out.println("Enter Employee Posting");
				var E_Posting = sc.nextLine();
				System.out.println("Enter Employee Gender");
				var E_Gender = sc.nextLine();
				System.out.println("Enter Employee Contact");
				var E_Contact = sc.nextLine();*/
				
				String sql= "INSERT INTO employee (E_Name,E_Id,E_Posting,E_Salary,E_Gender,E_Contact) VALUES (?,?,?,?,?,?)";
				PreparedStatement smt = con.prepareStatement(sql);
				smt.setString(1,"Samraj");
				smt.setInt(2,123);
				smt.setString(3,"Developer");
				smt.setDouble(4,200000);
				smt.setString(5,"Male");
				smt.setString(6,"5555544444");
				System.out.println(smt);
				int inserted = smt.executeUpdate();
				if (inserted>0) 
						{
						System.out.println("\t... Data inserted successfully ...\t");
				        }
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
			break;
			
		case "3":
			try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peace","root","Kannan26@"))
			{
				/*System.out.println("Enter Employee Name");
				var E_Name = sc.nextLine();
				System.out.println("Enter Employee ID");
				int E_Id = sc.nextInt();
				System.out.println("Enter Employee Posting");
				var E_Posting = sc.nextLine();
				System.out.println("Enter Employee Gender");
				var E_Gender = sc.nextLine();
				System.out.println("Enter Employee Contact");
				var E_Contact = sc.nextLine();*/
				String sql = "UPDATE employee SET E_Name=?, E_Id=? WHERE E_Name=?";
				PreparedStatement smt = con.prepareStatement(sql);
				smt.setString(1,"krishna");
				smt.setInt(2,226);
				smt.setString(3,"kannan");
				System.out.println(smt);
				int updated = smt.executeUpdate();
				if (updated>0) 
						{
						System.out.println("\t... Data updated successfully ...\t");
				        }
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
			break;	
			
		case "4":
			try (Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/peace","root","Kannan26@"))
			{
				/*System.out.println("Enter which Employee Id you want to delete ");	
				String E_Id = sc.nextLine();
				String dq = "delete from employee where E_Id = " + E_Id;*/
				
				String sql = "DELETE FROM employee WHERE E_Name=?";
				PreparedStatement smt = con.prepareStatement(sql);
				smt.setString(1,"raghu");
				int deleted = smt.executeUpdate();
				if (deleted>0) 
						{
					    System.out.println("\t... Data deleted successfully ...\t");
				        }
			}
			catch(Exception e)
			{
				e.getStackTrace();
			}
			break;
			
		default:
			System.out.println("\t...You are selected out of range...\t");
		break;
		}
		System.out.println("\t... Enter y to continue (or) Enter z for EXIT ...\t");
		data = sc.nextLine();
		if (data.equals("z"))
		System.out.println("\t... Thanks for Using... \\t ...Now you are EXIT the Program ...\t");
	} while (data.equals("y"));
	  //System.out.println("\t You Have selected to continue ... \t");
	}
}

