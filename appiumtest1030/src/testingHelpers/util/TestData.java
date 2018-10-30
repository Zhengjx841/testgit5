package testingHelpers.util;

import java.text.MessageFormat;
import java.util.HashMap;



public class TestData {
	private final static String EXPECTED = "[期待值]"; 
	
	private final static String ACTUAL = "[实际值]"; 
	
	
	private HashMap<String , Object> data = new HashMap<>();
	
	private Object expected; 
	private Object actual;
	
	
	public void expected(Object value){
		this.expected = value;
	}
	
	
	public void actual(Object value){
		this.actual = value;
	}
	
	
	public void add(String name, Object value){
		this.data.put(MessageFormat.format("[{0}]", name), value);
	}
	
	public TestData() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TestData(String[] names, Object[] values, Object expected){
		for (int i = 0; i < names.length; i++){
			this.add(names[i], values[i]);
		}
		
		this.expected = expected;
	}
	
	@Override
	public String toString(){
		StringBuilder strBuilder = new StringBuilder();
		
		StringBuilder keyBuilder = new StringBuilder();
		StringBuilder valueBuilder = new StringBuilder();
		
				
		for (String key : this.data.keySet()){
			String value = (this.data.get(key) == null) ? Common.EMPTY : this.data.get(key).toString();
//			int length = (value.length() >= key.length()) ? value.length() : key.length();
			
			keyBuilder.append(Common.padRight(key, value.length() + key.length()));
			keyBuilder.append(Common.TAB);
			
			valueBuilder.append(Common.padRight(value, value.length() + key.length()));
			valueBuilder.append(Common.TAB);
			
		}
		
		strBuilder.append(keyBuilder);
		strBuilder.append(EXPECTED);
		strBuilder.append(Common.TAB);
		strBuilder.appendLine(ACTUAL);
		
		strBuilder.append(valueBuilder);
		strBuilder.append(this.expected);
		strBuilder.append(Common.TAB);
		strBuilder.appendLine(this.actual);
		
		return strBuilder.toString();
	}
	
	
	
	public String toString2(){

		StringBuilder strBuilder = new StringBuilder();
		
		String values = Common.EMPTY;
		
		for (String key : data.keySet()){
			values += data.get(key).toString() + Common.TAB;
		}
		
		strBuilder.appendLine(values);
		
		return strBuilder.toString();
	}
}
