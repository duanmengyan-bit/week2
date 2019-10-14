package com.duanmengyan.week.domain;

import java.math.BigDecimal;

public class Goods {
	private Integer id;
	private String name;
	private BigDecimal price;
	private String baifen;
	public Goods(Integer id, String name, BigDecimal price, String baifen) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.baifen = baifen;
	}
	public Goods() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getBaifen() {
		return baifen;
	}
	public void setBaifen(String baifen) {
		this.baifen = baifen;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", baifen=" + baifen + "]";
	}
	
	
}
