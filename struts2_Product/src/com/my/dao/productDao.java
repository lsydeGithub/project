package com.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.my.bean.Product;

public class productDao {

	private static Connection conn=null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null; 
	/***
	 *  查看所有商品信息
	 */
	public List<Product> getAll(int status) {
		List<Product> list = new ArrayList<Product>();
		//String sql="select Item_id,Item_name,Item_price,create_time,status from Vip_users";
		StringBuffer sql=new StringBuffer(" select * from Vip_users where 1=1  ");
		if(status!=-1){
			sql.append("and status="+status);
		}
		try {
			conn = BaseDao.getCon();
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				Product p = new Product();
				p.setCreate_time(rs.getDate("create_time"));
				p.setItem_id(rs.getInt("item_id"));
				p.setItem_name(rs.getString("item_name"));
				p.setItem_price(rs.getInt("item_price"));
				p.setStatus(rs.getInt("status"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			BaseDao.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	/**
	 * 添加商品
	 */
	
	public boolean addProduct(Product pd){
		boolean bl = false;
		String sql="insert into vip_users(Item_id,Item_name,Item_price,create_time,status) values(s_num.nextval,?,?,?,?)";
		try {
			conn = BaseDao.getCon();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pd.getItem_name());
			ps.setInt(2, pd.getItem_price());
			ps.setDate(3,new java.sql.Date(pd.getCreate_time().getTime()));
			ps.setInt(4, pd.getStatus());
			
			bl=ps.executeUpdate()>0;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			BaseDao.closeAll(null, ps, conn);
		}
		return bl;
	}
	
	/**
	 * 根据id更新商品为下架状态
	 */
	
	public boolean updateProduct(Product pd){
		boolean bl = false;
		String sql = "update Vip_users set status = ? where Item_id=?";
		int row = 0;
		try {
			conn = BaseDao.getCon();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pd.getStatus());
			ps.setInt(2, pd.getItem_id());
			row = ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			BaseDao.closeAll(null, ps, conn);
		}
		return bl = row > 0;
	}
	
}
