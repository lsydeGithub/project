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
	 * ����Ʒ����Ϣ��ʾ����
	 */
	public String getAll(){
		products=new productDao().getAll(status);
		return "list";
	}
	
	
	//��ת�������Ʒ��ҳ��
	public String toAdd () {
		return "success";
	}
	//�����Ʒ
	public String addProduct(){
		boolean bl  = false;
		bl = new productDao().addProduct(pd);
		System.out.println(bl);
		if(bl){
			msg="��ӳɹ�";
			return "add";
		}
		else{
			msg="���ʧ��";
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
