package com.roncoo.eshop.inventory.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;

import com.roncoo.eshop.inventory.request.Request;

/**
 * 执行请求的工作线程
 * @author Administrator
 *
 */
public class RequestProcessorThread implements Callable<Boolean> {

	/**
	 * 自己监控的内存队列
	 * 阻塞队列（BlockingQueue）是一个支持两个附加操作的队列。
	 * 这两个附加的操作是：在队列为空时，获取元素的线程会等待队列变为非空。
	 * 当队列满时，存储元素的线程会等待队列可用。
	 * 阻塞队列常用于生产者和消费者的场景
	 */
	private ArrayBlockingQueue<Request> queue;

	public RequestProcessorThread(ArrayBlockingQueue<Request> queue) {
		this.queue = queue;
	}
	
	@Override
	public Boolean call() throws Exception {
		try {
			while(true) {
				// ArrayBlockingQueue
				// Blocking就是说明，如果队列满了，或者是空的，那么都会在执行操作的时候，阻塞住
				Request request = queue.take();
				System.out.println("===========日志===========: 工作线程处理请求，商品id=" + request.getProductId()); 
				// 执行这个request操作
				request.process();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
