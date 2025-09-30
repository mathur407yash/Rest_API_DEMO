package com.yash.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import java.sql.Statement;


public class AlienRepository
{
//	List<Alien> aliens;
//	public AlienRepository() {
//	aliens = new ArrayList<>();
//	
//	Alien a1=new Alien();
//	a1.setId(101);
//	a1.setName("Yash");
//	a1.setPoints(99);
//	
//	Alien a2= new Alien();
//	a2.setId(102);
//	a2.setName("Harsh");
//	a2.setPoints(50);
//	
//	aliens.add(a1);
//	aliens.add(a2);
	Connection con= null;
	public AlienRepository()
	{
		String url="jdbc:mysql://localhost:3306/restdb";
		String username="root";
		String pass="1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				con=DriverManager.getConnection(url,username,pass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	public List<Alien> getAliens()
	{
		List<Alien> aliens=new ArrayList<>();
		String sql="select * from alien ";
		
		
		try {
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				Alien a= new Alien();
			
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return aliens;
	}
	
	public Alien getAlien(int id)
	{
		String sql="select * from alien where id= "+id;
		Alien a= new Alien();
		
		try {
			Statement st = con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			
			if(rs.next())
			{
			
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return a;
	}
	public void create(Alien a1) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO alien (id, name, points) VALUES (?, ?, ?)";
//		Alien a= new Alien();
	
		try {
			PreparedStatement st= con.prepareStatement(sql);
//			ResultSet rs=st.executeQuery(sql);
			st.setInt(1, a1.getId());
			st.setString(2,a1.getName());
			st.setInt(3,a1.getPoints());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	
		
		
	}
	public void update(Alien a1) {
		// TODO Auto-generated method stub
		String sql="update alien set name=? , points=? where id=?";
//		Alien a= new Alien();
	
		try {
			PreparedStatement st= con.prepareStatement(sql);
//			ResultSet rs=st.executeQuery(sql);
		
			st.setString(1,a1.getName());
			st.setInt(3, a1.getId());
			st.setInt(2,a1.getPoints());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	
		
		
	}
	public void delete(int id)
	{
		String sql="delete from alien where id=?";
	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
			} 
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
		System.out.println(e);
		}
		
				
	}
	
	
}
