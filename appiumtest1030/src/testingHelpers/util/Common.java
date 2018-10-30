package testingHelpers.util;

import java.io.File;


public class Common {


	public final static Character TAB = '\t';
	
	public final static Character SPACE = ' ';
	
	public final static String EMPTY = "";
	
	public final static char SHARP = '#';
	
	
	public static boolean isNullOrEmpty(String value){
		if (value == null || value.trim().equals(EMPTY))
			return true;
		
		return false;
	}
	
	
	public static String currentPath(){
		return System.getProperty("user.dir");
	}
	
	
	public static String newLine(){
		return System.getProperty("line.separator");
	}
	

	
	public static String getAppPath(String fileName){

        File classpathRoot = new File(Common.currentPath());        
        File appsDir = new File(classpathRoot, "apps"); //获取当前java项目所在的目录下的apps文件夹
        File app = new File(appsDir, fileName);
        
        return app.getAbsolutePath();
	}
	
	
	
	public static String padLeft(String value, int length, Character c){
		if (value.length() >= length)
			return value;
		
		return repeat(c, length - value.length()) + value;
	}
	
	public static String padLeft(String value, int length){
		return padLeft(value, length, Common.SPACE);
	}
	
	public static String padRight(String value, int length, Character c){
		if (value.length() >= length)
			return value;
		
		return  value + repeat(c, length - value.length());		
	}
	
	public static String padRight(String value, int length){
		return padRight(value, length, Common.SPACE);
	}
	
	public static String repeat(Character c, int count){
		StringBuilder strBuilder = new StringBuilder();
		
		for (int i = 0; i < count; i++){
			strBuilder.append(c);
		}
		
		return strBuilder.toString();
	}
	
	
}
