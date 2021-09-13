package com.yang.exception;

/**
 * 自定义异常
 * @author Administrator
 *
 */
public class CustomException extends RuntimeException{
	 public CustomException(String msg){
	        super(msg);
	    }

	    public CustomException() {
	        super();
	    }
}
