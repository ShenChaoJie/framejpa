package org.frame.common.utils;

/**
 * 
 * @author chaojie.shen
 *
 */
public class Constants {

	public enum Season{
		SPRING("春天",1),SUNMER("夏天",2),AUTUMN("秋天",3),WINER("冬天",4);
		
		private String name;
		private int code;
		private Season(String name,int code){
			this.code = code;
			this.name = name;
		}
	}

	public static void main(String[] args) {
		System.out.println(Season.SPRING.code);
		System.out.println(Season.SPRING.name);
		System.out.println(Season.SPRING.name());
	}
	
	
	
	
	
}
