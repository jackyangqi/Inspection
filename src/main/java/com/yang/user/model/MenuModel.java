package com.yang.user.model;

import java.util.List;

import lombok.Data;

@Data
public class MenuModel {

	private int id;
	private String name;
	private String page;
	private String icon;
	private int type;
	private List<MenuModel> child;

}
