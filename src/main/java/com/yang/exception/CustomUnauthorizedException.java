package com.yang.exception;

/**
 * 自定义401无权限异常
 * @author Administrator
 *
 */
public class CustomUnauthorizedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomUnauthorizedException(String msg){
        super(msg);
    }

    public CustomUnauthorizedException() {
        super();
    }
}
