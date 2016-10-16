package com.my.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BaseDao {
	private static String  Driver = "oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	
	private static String uid="vip";
	private static String pwd = "vip";
	
	static{
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() throws SQLException{
		Connection con= null;
		con = DriverManager.getConnection(url,uid,pwd);
		
		return con;
	}
	
	
	
	public static void closeAll(ResultSet rs, Statement ps, Connection con){
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection conn = getCon();
		System.out.println(conn);//
		conn.close();
		
	}
//-------------------------------------------------------------------------------------
	public static int update(String sql) {
		int row = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn= getCon();
			ps = conn.prepareStatement(sql);
			row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(null, ps, conn);
		}
		return row;
	}

	
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> getAll(String sql,Class<?> c){
		List<T> list = new ArrayList<T>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			con= getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd =  rs.getMetaData();
			int count = rsmd.getColumnCount();
			while(rs.next()){
				T t = (T)c.newInstance();
				for(int i=0;i<count;i++){
					String name = rsmd.getColumnName(i+1);
					Field f = c.getDeclaredField(name);
					f.setAccessible(true);
					if(f.getGenericType().toString().endsWith("double")){
						f.set(t, rs.getDouble(i+1));
					}else if(f.getGenericType().toString().endsWith("float")){
						f.set(t, rs.getFloat(i+1));
					}else if(f.getGenericType().toString().endsWith("money")){
						f.set(t, rs.getDouble(i+1));
					}else if(f.getGenericType().toString().endsWith("Date")){
						f.set(t, rs.getTimestamp(i+1));
					}else{
						f.set(t,rs.getObject(i+1));
					}
				}
				list.add(t);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAll(rs, ps, con);
		}
		return list;
	}
}
