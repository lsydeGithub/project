package com.my.bean;

import java.util.Date;

public class Product {

	private int Item_id;//	��Ʒ���	number		�ǿ�	����
	private String Item_name;//	��Ʒ����	varchar2	50	�ǿ�	
	private int Item_price;//	��Ʒ�۸�	number(9,2)		�ǿ�	
	private Date create_time;//	���ʱ��	datetime		�ǿ�	
	private int status;//	��Ʒ״̬	number	1	�ǿ�	0-�ϼ� 1-�¼�
	
	public int getItem_id() {
		return Item_id;
	}

	public void setItem_id(int item_id) {
		Item_id = item_id;
	}

	public String getItem_name() {
		return Item_name;
	}

	public void setItem_name(String item_name) {
		Item_name = item_name;
	}

	public int getItem_price() {
		return Item_price;
	}

	public void setItem_price(int item_price) {
		Item_price = item_price;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [Item_id=" + Item_id + ", Item_name=" + Item_name + ", Item_price=" + Item_price
				+ ", create_time=" + create_time + ", status=" + status + "]";
	}

	
}
