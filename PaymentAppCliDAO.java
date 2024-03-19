import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentAppCliDAO {

	public static void storeUserDetails(User u) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root", "");
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
	}

	public static void printUserDetails() throws SQLException {
		User u = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root", "");
			Statement st = con.createStatement();
			String query = "select * from User_info";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println(
						rs.getInt("Id") + " : " + rs.getString("First_Name") + " : " + rs.getString("Last_Name") + " : "
								+ rs.getLong("Phone_Number") + " : " + rs.getString("Date_Of_Birth") + " : "
								+ rs.getString("Address") + " : " + rs.getString("Password"));
			}
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean Logindb(int Uid, String PassWord) throws SQLException {
		User u = new User();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection Con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "uda7650");
			Statement st = Con.createStatement();
			String Uquery = "select Id,Password from User_info where User_Id = '" + u.getUserId() + "'and Password ='"
					+ u.getPassword() + "'";
			ResultSet res = st.executeQuery(Uquery);
			if (res.next()) {
				res.next();
				System.out.println("Login Successfull!");
				return true;
			} else {
				System.out.println("Login Failed!");
			}
			st.close();
		
		return false;
	}

	public static void storeUserBankAcctDetails(BankAccount ba) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payments_App_CLI", "root", "");
			Statement st = con.createStatement();
			String query = "insert into BankAccount_Details(Account_Number,Acct_IFSC,Bank_Name,Bank_Acct_Pin,Acct_Type,UserId) "
					+ "values('" + ba.getBankAcctNumber() + "','" + ba.getBankAcctIFSC() + "','"
					+ ba.getBankAcctBankName() + "','" + ba.getBankAcctType() + "','" + ba.getBankAcctPin() + "','"
					+ ba.getUserId() + "')";

			int rs = st.executeUpdate(query);
			System.out.println(rs + "row/s effected");

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
