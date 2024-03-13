import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentAppCliDAO {

	public static void storeUserDetails(User u) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root",
					"root");
			Statement st = con.createStatement();
			String query = "insert into User_info(First_Name,Last_Name,Phone_Number,Date_Of_Birth,Address,Password) "
					+ "values('" + u.getFirstName() + "','" + u.getLastName() + "','" + u.getPhoneNumber() + "','"
					+ u.getDateOfBirth() + "','" + u.getAddress() + "','" + u.getPassword() + "')";

			int rs = st.executeUpdate(query);
			System.out.println(rs + "row/s effected");

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

			public static void storeUserBankAcctDetails(BankAccount ba) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root",
					"root");
			Statement st = con.createStatement();
			String query = "insert into BankAccount_Details(Account_Number,Acct_IFSC,Bank_Name,Bank_Acct_Pin,Acct_Type,UserId) "
					+ "values('"+ba.getBankAcctNumber()+"','"+ba.getBankAcctIFSC()+"','"+ba.getBankAcctBankName()+"','"+ba.getBankAcctType()+"','"+ba.getBankAcctPin()+"','"+ba.getUserId()+"')";
			
			int rs = st.executeUpdate(query);
			System.out.println(rs + "row/s effected");

			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
