package com.my.action;

import java.util.*;

import com.my.bean.Product;
import com.my.dao.productDao;

public class ProductActin {

	private String msg;
	private int status=-1;
	private Product pd;
	private List<Product> products = new ArrayList<Product>();
	/**
	 * 将商品的信息显示出来
	 */
	public String getAll(){
		products=new productDao().getAll(status);
		return "list";
	}
	
	
	//跳转到添加商品的页面
	public String toAdd () {
		return "success";
	}
	//添加商品
	public String addProduct(){
		boolean bl  = false;
		bl = new productDao().addProduct(pd);
		System.out.println(bl);
		if(bl){
			msg="添加成功";
			return "add";
		}
		else{
			msg="添加失败";
			return "fail";
		}
	}
	


	
	public Product getPd() {
		return pd;
	}
	public void setPd(Product pd) {
		this.pd = pd;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
