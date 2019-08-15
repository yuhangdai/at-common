package com.aotain.nms.common.tools;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class UploadFileQueue {

	private Object locked = new Object();
	private final int size = 100;
	
    /** 消息模块实例 */
	private static UploadFileQueue _instance = null;
    
	/** 消息队列 */
    private Map<String, Set<String>> _vMap;
    
    /** 线程同步控制确保模块仅有一个实例 */
    public static synchronized UploadFileQueue getInstance() {    	
        if (_instance == null) {
        	_instance = new UploadFileQueue();
        }
        return _instance;
    }
    
    /** 构造器，默认消息队列长度为100 */
    private UploadFileQueue() {
    	_vMap = new ConcurrentHashMap<String, Set<String>>(size);
    }
    
    /** 向消息队列添加消息 */
    public synchronized void add(String key, String data){
    	synchronized(locked) {
    		Set<String> temp = _vMap.get(key);
    		if (temp != null) {
    			temp.add(data);
    		} else {
    			temp = new HashSet<String>();
    			temp.add(data);
    		}
    		_vMap.put(key, temp);
    	}
    }
    
    /** 返回并删除消息队列起始处消息，若消息队列为空，返回空 */
    public synchronized Set<String> remove(String key) {
    	synchronized(locked){
            if(_vMap.keySet().size() == 0) {
            	return null;
            }
            return _vMap.remove(key);
    	}
    }
    
    /** 返回消息队列长度 */
    public int getSize(){
        return _vMap.keySet().size();
    }
            
    public boolean isFull(){
    	return _vMap.keySet().size() == size;
    }   
    
    public boolean containElement(String element) {
    	return _vMap.containsKey(element);
    }
}