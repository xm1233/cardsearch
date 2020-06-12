package dao;
import java.sql.Connection;
import java.sql.SQLException;

import util.Dbutil;

public class BaseDao {
	public Connection con=new Dbutil().getCon();
	public void closeDao(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
