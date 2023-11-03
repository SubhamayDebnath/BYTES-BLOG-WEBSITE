package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.entity.User;

public class UserDAO {
	
	public Connection conn;
	
	public UserDAO(Connection conn)
	{
		super();
		this.conn=conn;
	}
	public boolean addUser(User webuser)
	{
		boolean result=false;
		
		try
		{
			String quary="insert into user_info(firstname,lastname,dob,email,password) values(?,?,?,?,?)"; 
			
			PreparedStatement ps= conn.prepareStatement(quary);
			ps.setString(1,webuser.getFirstname());
			ps.setString(2,webuser.getLastname());
			ps.setString(3,webuser.getDob());
			ps.setString(4,webuser.getEmail());
			ps.setString(5,webuser.getPassword());
			
			int i = ps.executeUpdate();
			
			if(i==1)
			{
				result = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	 public User getUserByEmailAndPassword(String email, String password) {
	        User user = null;

	        try {

	            String query = "select * from user_info where email =? and password=?";
	            PreparedStatement pstmt= conn.prepareStatement(query);
	            pstmt.setString(1, email);
	            pstmt.setString(2, password);

	            ResultSet set =pstmt.executeQuery();

	            if (set.next()) {
	                user = new User();

	                String firstname = set.getString("firstname");
	                user.setFirstname(firstname);
	                user.setLastname(set.getString("lastname"));
	                user.setId(set.getInt("id"));
	                user.setDob(set.getString("dob"));
	                user.setEmail(set.getString("email"));
	                user.setPassword(set.getString("password"));
	                user.setProfile(set.getString("profile"));
	              

	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return user;
	    }
	 
	 public boolean updateUser(User user) {

	        boolean f = false;
	        try {

	            String query = "update user_info set firstname=? , lastname=?,dob=?, email=? , password=?, profile=? where  id =?";
	            PreparedStatement p = conn.prepareStatement(query);
	            p.setString(1, user.getFirstname());
	            p.setString(2, user.getLastname());
	            p.setString(3,user.getDob());
	            p.setString(4, user.getEmail());
	            p.setString(5, user.getPassword());
	            p.setString(6, user.getProfile());
	            p.setInt(7, user.getId());

	            p.executeUpdate();
	            f = true;

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return f;
	    }
	 
	 public User getUserByUserID(int userId)
		{
			User user= null;
			try
			{
				String q="select * from user_info where id= ?";
				PreparedStatement ps=this.conn.prepareStatement(q);
				ps.setInt(1, userId);
				ResultSet set=ps.executeQuery();
				if (set.next())
				{
					user = new User();

	                String firstname = set.getString("firstname");
	                user.setFirstname(firstname);
	                user.setLastname(set.getString("lastname"));
	                user.setId(set.getInt("id"));
	                user.setDob(set.getString("dob"));
	                user.setEmail(set.getString("email"));
	                user.setPassword(set.getString("password"));
	                user.setProfile(set.getString("profile"));
	              
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return user;
		}


}
