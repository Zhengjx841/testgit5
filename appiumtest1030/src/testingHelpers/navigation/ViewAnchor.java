package testingHelpers.navigation;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testingHelpers.util.Common;
import testingHelpers.util.StringBuilder;



public class ViewAnchor {

	// 路径各部分之间的分隔符
	public final static char SPLITER = '/';
	
	
	protected static List<ViewAnchor> allAnchors = new ArrayList<>();

	
	public static ViewAnchor getAnchorByName(String anchorName){
		
		for(ViewAnchor anchor : allAnchors){
			if (anchor.name.equals(anchorName))
				return anchor;
		}
		
		return null;
	}
	

	
	
	public static ViewAnchor getAnchorByPath(String path){

		for(ViewAnchor anchor : allAnchors){
			if (foramtPath(path).equals(anchor.path))
				return anchor;
		}
		
		return null;
	}
	

	private static String foramtPath(String path){
		String result = path;
		
		if (result.charAt(0) == SPLITER)
			result = result.substring(1);
		
		if (result.charAt(result.length() - 1) == SPLITER)
			result = result.substring(0, result.length() - 1);
		
		return result;
	}
	
	
	private String name;

	
	public String getName() {
		return name;
	}
	
	
	private String path;
	
	
	
	public String getPath() {
		return path;
	}
	
	
	public String parentPath(){
		int index = this.path.lastIndexOf(String.valueOf(SPLITER));
		
		if (index > 0)
			return this.path.substring(0, index);
		else
			return null;
	}

	
	String[] pathNameList;
	
	
	public String[] getPathNameList(){
		return pathNameList;
	}

	
	private ViewAnchor(String path){

		this.path = foramtPath(path);		
			
		pathNameList = this.path.split(String.valueOf(SPLITER));
		
		this.name = pathNameList[pathNameList.length - 1];
		
		allAnchors.add(this);
	}
	

	
	public static ViewAnchor createInstance(String path){

		if (Common.isNullOrEmpty(path) || path.trim().equals(String.valueOf(SPLITER)))
			return null;
		
		ViewAnchor anchor = ViewAnchor.getAnchorByPath(path);
		
		if (anchor != null)
			return anchor;
		
		return new ViewAnchor(path);
		
	}
	

	
	protected Map<ViewAnchor, Filter> navAnchorMap = new ConcurrentHashMap<>(); 

	
	public void add(ViewAnchor navViewAnchor, Filter navAnchorFilter){
		this.navAnchorMap.put(navViewAnchor, navAnchorFilter);
	}
	
	
	public String navAnchorMapStructure(){
		List<ViewAnchor> readedList = new ArrayList<>();		
		return navAnchorMapStructure(this, 0, readedList);
	}
	
	
	private static String navAnchorMapStructure(ViewAnchor anchor, int x, List<ViewAnchor> readedList){

		StringBuilder sb = new StringBuilder();
				
		sb.appendLine(anchor.path);
		readedList.add(anchor);
			
		
		for (ViewAnchor temp : anchor.navAnchorMap.keySet()){
			
			sb.appendSpace(x + 2);
			sb.appendLine("|");
			sb.appendSpace(x + 3);
			sb.append("--");				

			if (readedList.contains(temp))
				sb.appendLine(temp.path);
			else
				sb.append(navAnchorMapStructure(temp, x + 6, readedList));
		}
		
		return sb.toString();
	}
	
	
	private ViewAnchor getNavAnchor(String anchorName){

		for(ViewAnchor va : navAnchorMap.keySet()){
			if (va.name.equals(anchorName))
				return va;
			
		}
		
		return null;
	}
	
	
	protected ViewAnchor moveTo(String name, WebDriver driver){
		
		ViewAnchor va = getNavAnchor(name);

		Filter myFilter = navAnchorMap.get(va);
		
		if (myFilter == null)
			return null;
		
		WebElement element = myFilter.filterElement(driver);

		if (element != null) {
			element.click();
			return va;
		}

		return null;
	}

	
	public boolean isHeadAnchor(){
		if (this.name == this.path)
			return true;
		
		return false;
	}
}
