package com.highlion.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.highlion.dao.UserDao;
import com.highlion.domain.User;
import com.highlion.utils.Utils;

public class UserDaoimpl implements UserDao {

	@Override
	public Boolean login(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		boolean ret = false;
		try {
			conn = Utils.getConn();
			// 修改⼆：表⽤拼接字符串，⽤占位符写法
			// String sql = "select * from t_user where name='" + name + "' and pwd='" + pwd
			// + "'";

			// ?就是占位符，表⽰将来要⽤⼀个具体来替代改位置
			String sql = "select * from t_user where name=? and pwd=?";
			System.out.println(sql);
			// stmt = conn.createStatement();
			stmt = conn.prepareStatement(sql);
			// 对特殊字符转义
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPwd());
			// 修改三:因为上⾯已经传⼊并⾮占位符赋值了，因⽽表再传
			// rs = stmt.executeQuery(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Utils.release(conn, stmt, rs);
		}
		return ret;
	}

}
