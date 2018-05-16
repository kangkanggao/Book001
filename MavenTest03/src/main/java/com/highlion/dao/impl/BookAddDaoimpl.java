package com.highlion.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.highlion.dao.BookAddDao;
import com.highlion.domain.BookVO;
import com.highlion.utils.Utils;

public class BookAddDaoimpl implements BookAddDao {

	@Override
	public Boolean add(BookVO book) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn=Utils.getConn();
			String sql="insert into t_book(tid,name,price,describle,photo,author,pubDate)values(?,?,?,?,?,?,?)";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1,book.getTid());
			ps.setString(2,book.getName());
			ps.setDouble(3,book.getPrice());
			ps.setString(4,book.getDescrible());
			ps.setString(5,book.getPhoto());
			ps.setString(6,book.getAuthor());
			ps.setDate(7,new java.sql.Date(book.getPubDate().getTime()));
			int i=ps.executeUpdate();
			if(i==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Utils.release(conn,ps);
		}
		
		return null;
	}

}
