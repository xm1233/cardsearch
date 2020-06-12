package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CardMessage;
import util.Stringutil;

public class CardDao extends BaseDao {
	public boolean addClass(CardMessage c1){
		String sql="insert into a_list values(null,?,?,?,?)";
		try{
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		preparedStatement.setString(1,c1.getName() );
		preparedStatement.setString(2, c1.getAtk());
		preparedStatement.setString(3, c1.getDef());
		preparedStatement.setString(4, c1.getInfo());
		if(preparedStatement.executeUpdate()>0){
			return true;
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	public List<CardMessage> getCardList(CardMessage cardmessage){
		List<CardMessage> relist=new ArrayList<CardMessage>();
		String sqlString="select * from a_list";
		if(!Stringutil.isEmpty(cardmessage.getName())){
			sqlString+=" where name like'%"+cardmessage.getName()+"%'";
		}
		try {
			PreparedStatement  preparedStatement=con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				CardMessage sc=new CardMessage();
				sc.setId(executeQuery.getInt("id"));
				sc.setName(executeQuery.getString("name"));
				sc.setAtk(executeQuery.getString("ATK"));
				sc.setDef(executeQuery.getString("DEF"));
				sc.setInfo(executeQuery.getString("info"));
				relist.add(sc);	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return relist;
		
	}

}
