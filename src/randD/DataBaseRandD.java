package randD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DataBaseRandD {


	public static void main(String[] args) {
		method1();
	}


	public static void method1()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//172.16.30.103
			Connection	conn =DriverManager.getConnection("jdbc:oracle:thin:@//INC00689:1521/xe","system","system");

			Statement st=conn.createStatement();


			ResultSet rs=st.executeQuery("select * from dept");

			/*while (rs.next()) {
				System.out.println(rs.getString(1));

			}*/


			ResultSetMetaData rsmd=rs.getMetaData();

			int columns = rsmd.getColumnCount();

			for(int i=1;i<=columns;i++)
				System.out.print(rsmd.getColumnTypeName(i));
			System.out.println();
			System.out.println("----------------------------------------------------");
			while(rs.next()){
				for(int i=1;i<=columns;i++)
					System.out.print(rs.getString(i));
			}



		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e);
		}
	}

}
