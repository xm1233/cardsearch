package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;

public class AdminDao extends BaseDao {
	public Admin login(Admin admin){
		String sql="select * from a_admin where name=? and password=?";
		Admin adminRst=null;
		try{PreparedStatement prst=con.prepareStatement(sql);//把SQL语句传给操作对象
		prst.setString(1,admin.getName());
		prst.setString(2,admin.getPassword());
		ResultSet executeQuery=prst.executeQuery();
		if(executeQuery.next()){
			adminRst=new Admin();
			adminRst.setId(executeQuery.getInt("id"));
			adminRst.setName(executeQuery.getString("name"));
			adminRst.setPassword(executeQuery.getString("password"));
			adminRst.setCreatedate(executeQuery.getString("createdate"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
		
		return adminRst;
}
	public String editPassword(Admin admin,String newPassword){
		String sql="select * from a_admin where name=? and password=?";
		PreparedStatement prst=null;
		int id=0;
		try {
			prst=con.prepareStatement(sql);
			prst.setString(1,admin.getName());
			prst.setString(2,admin.getPassword());
			ResultSet executeQuery=prst.executeQuery();
			if(!executeQuery.next()){
				String retString="旧密码错误";
				return retString;
			}
			id=executeQuery.getInt("id");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//把SQL语句传给操作对象
		
		String retString="修改失败";
		String sqlString="update a_admin set password = ? where id = ? ";
		try {
			prst=con.prepareStatement(sqlString);//把SQL语句传给操作对象
			prst.setString(1,newPassword);
			prst.setInt(2,id);
			int r=prst.executeUpdate();
			if(r>0){
				retString="密码修改成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return retString;
	}
}
