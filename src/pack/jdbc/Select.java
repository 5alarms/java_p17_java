package pack.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

	public static void main(String[] args) {

		Connection conn = null;  //접속 역할
		Statement stmt = null;   //SQL 코드 역할
		ResultSet re = null;    //Select 조회결과 데이터 반환 역할
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Company?";
			url += "useSSL=false&";
			url += "useUnicode =true&";
			url += "characterEncoding=UTF8&";
			url += "serverTimezone=UTC&";	
			url	+=	"allowPublicKeyRetrieval=true";
			
			String uid = "root";
			String upw = "1234";
			
			conn = DriverManager.getConnection(url, uid, upw);
		// System.out.println("company 데이터베이스 접속 OK!!");
			stmt = conn.createStatement();
			String sql = "select * from stafflist";
			re =stmt.executeQuery(sql);
			
			System.out.println("num \t id \t name \t age \t address");
			while(re.next()) {
				int num = re.getInt("num");
			String id = re.getString("id");
			String name = re.getString("name");
			String age = re.getString("age");
			String address = re.getString("address");
			String txt = num + "\t";
				txt += id + "\t";
				txt += name + "\t";
				txt += age + "\t";
				txt += address;
			System.out.println(txt);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());	
		}catch (SQLException e) {
				System.out.println(e.getMessage());
		}
		
	}

}
