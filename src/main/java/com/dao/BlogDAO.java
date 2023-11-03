package com.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.entity.Category;
import com.entity.Post;
import com.entity.User;
public class BlogDAO {
	
	Connection Conn;
	public BlogDAO(Connection Conn)
	{
		this.Conn=Conn;
	}
	public ArrayList<Category> getCategories(){

		
		ArrayList<Category> list = new ArrayList<>();
		
		try
		{
			String quary="select * from post_categories";
			Statement str=this.Conn.createStatement();
		
			ResultSet set=str.executeQuery(quary);
			while(set.next())
			{
				int cid = set.getInt("cid");
				String cname = set.getString("cname");
				
				Category cy = new Category(cid,cname);
				list.add(cy);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public boolean savePost(Post ps)
	{
		boolean f=false;
		try
		{
			String q="insert into blog_info(btittle,bcont,bpic,catid,userid ) values(?,?,?,?,?)";
			PreparedStatement psmt=Conn.prepareStatement(q);
			psmt.setString(1,ps.getBtittle());
			psmt.setString(2,ps.getBcont());
			psmt.setString(3,ps.getBpic());
			psmt.setInt(4,ps.getCatid());
			psmt.setInt(5,ps.getUserid());
			psmt.executeUpdate();
			f=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Post> getAllPost()
	{
		List<Post> list = new ArrayList();
		try
		{
			PreparedStatement p=Conn.prepareStatement("select * from blog_info order by bid desc");
			ResultSet set=p.executeQuery();
			while(set.next()) {
				int bid=set.getInt("bid");
				String btittle=set.getString("btittle");
				String bcont=set.getString("bcont");
				Timestamp bdate=set.getTimestamp("bdate");
				String bpic=set.getString("bpic");
				int catid=set.getInt("catid");
				int userid=set.getInt("userid");
				Post ps =new Post(bid,btittle,bcont,bdate,bpic,catid,userid);
				
				list.add(ps);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
	public List<Post> getPostByCatId(int catid){
		
		List<Post> list = new ArrayList();
		
		try
		{
			PreparedStatement p=Conn.prepareStatement("select * from blog_info where catid=?");
			p.setInt(1,catid);
			ResultSet set=p.executeQuery();
			while(set.next()) {
				int bid=set.getInt("bid");
				String btittle=set.getString("btittle");
				String bcont=set.getString("bcont");
				Timestamp bdate=set.getTimestamp("bdate");
				String bpic=set.getString("bpic");
				int userid=set.getInt("userid");
				Post ps =new Post(bid,btittle,bcont,bdate,bpic,catid,userid);
				
				list.add(ps);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	public Post getPostByPostId(int bId) {
        Post post = null;
        String q = "select * from blog_info where bid=?";
        try {
            PreparedStatement p = this.Conn.prepareStatement(q);
            p.setInt(1, bId);

            ResultSet set = p.executeQuery();

            if (set.next()) {

                int bid = set.getInt("bid");
                String btittle = set.getString("btittle");
                String bcont = set.getString("bcont");
                String bpic = set.getString("bpic");
                Timestamp bdate = set.getTimestamp("bdate");
                int cid=set.getInt("catId");
                int userId = set.getInt("userId");
                post = new Post(bid, btittle, bcont, bdate,bpic, cid, userId);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return post;
    }
	
}
