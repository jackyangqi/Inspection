package com.yang.pojo;

import lombok.Data;

@Data
public class BaseParameter<T> {

	private int current;
	private int size;
	private String word;
	private T t ;

}
