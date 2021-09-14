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
	private int pid;
	private List<MenuModel> child;

}
