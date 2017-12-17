package com.roncoo.eshop.inventory.request;

/**
 * 请求接口
 * @author Administrator
 *
 */
public interface Request {

	/**
	 * 处理请求逻辑
	 */
	void process();
	Integer getProductId();
	
}
