package com.siemo.insentif.calculator.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.siemo.insentif.calculator.model.IncentiveCalculatorModel;
import com.siemo.insentif.calculator.service.Connect;

public class IncentiveDataAccessObject {
	private Connection conn =null;
	public IncentiveDataAccessObject(){
		conn = new Connect().getConnected();
	}
	public boolean insertData(IncentiveCalculatorModel insertdata){
		boolean insert = false;
		PreparedStatement ps = null;
		try{
			String query = "INSERT INTO incentive(grade,salary,incentivepercetages) VALUES (?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, insertdata.getGrade());
			ps.setInt(2, insertdata.getSalary());
			ps.setFloat(3, insertdata.getIncentivePercentage());
			ps.execute();
			insert = true;
		}catch(SQLException se){
			Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, se);
		}
		finally{
			if(conn!=null)try{
				conn.close();
			}catch(Exception e){
				Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, e);
			}
			if(ps!=null)try{
				ps.close();
			}catch(Exception e){
				Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return insert;
	}
	
	public List<IncentiveCalculatorModel> getIncentiveData(){
		List<IncentiveCalculatorModel> listIncentive = new ArrayList<IncentiveCalculatorModel>();
		ResultSet rs = null;
		try{
			String selectquery = "SELECT * FROM incentive";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(selectquery);
			while(rs.next()){
				IncentiveCalculatorModel model = new IncentiveCalculatorModel();
				model.setGrade(rs.getString(1));
				int salary = rs.getInt(2);
				model.setSalary(salary);
				float incentivePercentage =Float.parseFloat(rs.getString(3));
				model.setIncentivePercentage(incentivePercentage);
				float incentive = (float)(salary*incentivePercentage);
				//model.setIncentiveFloat(incentive);
				model.setIncentive(Math.round(incentive));
				listIncentive.add(model);
			}
		}catch(SQLException se){
			Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, se);
		}
		finally {
			if (conn!=null)try{
				conn.close();
			}catch(Exception e){
				Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, e);
			}
			if (rs!=null)try{
				rs.close();
			}catch(Exception e){
				Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return listIncentive;
	}
	public float getIncentivePercentage(String grade){
		Statement st = null;
		ResultSet rs = null;
		float incentivePercentage = 0;
		try{
			String query="SELECT * FROM incentive WHERE grade='"+grade+"'";
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				incentivePercentage = Float.parseFloat(rs.getString("incentivepercentages"));
			}
			
		}catch(SQLException se){
			Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, se);
		}
		finally{
			if (conn!=null)try{
				conn.close();
			}catch(Exception e){
				Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, e);
			}
			if (rs!=null)try{
				rs.close();
			}catch(Exception e){
				Logger.getLogger(IncentiveDataAccessObject.class.getName()).log(Level.SEVERE, null, e);
			}
		}
		return incentivePercentage;
	}
}
