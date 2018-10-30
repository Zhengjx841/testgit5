package testingHelpers.util;


public class StringBuilder {
	StringBuffer sb = new StringBuffer();
	
	public <T> void append(T value){
		if (value == null)
			sb.append(Common.EMPTY);
		else			
			sb.append(value);
	}
	
	
	public void appendLine(){
		this.append(Common.newLine());
	}
	
	
	public <T> void appendLine(T value){
		this.append(value);
		this.appendLine();
	}
	
	
	public void appendSpace(int count){
		for (int i = 0; i < count; i++){
			this.append(Common.SPACE);
		}
	}
	
	
	@Override
	public String toString(){
		return sb.toString();
	}
	
}
