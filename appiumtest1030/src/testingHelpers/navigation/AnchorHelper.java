package testingHelpers.navigation;

import testingHelpers.util.Common;


public class AnchorHelper {
	private ViewAnchor currentAnchor; // 当前锚点
	
	
	public ViewAnchor getCurrentAnchor() {
		return currentAnchor;
	}


	ViewAnchor parentAnchor; 
	Filter inFilter; 
	ViewAnchor backAnchor;	
	Filter backFilter; 
	
	
	
	public static AnchorHelper loadElements(String[] elements){
		
		if (elements.length == 0)
			return null;
		
		AnchorHelper helper = new AnchorHelper(elements);
		return helper;
		
	}
	
	
	private AnchorHelper(String[] elements){

		this.currentAnchor = ViewAnchor.createInstance(elements[0]);
		
				
		this.initInFilter(elements);
		this.initParentAnchor();
		
		
		this.initBackAnchor(elements);
		this.initBackFilter(elements);
		
		if (this.backAnchor != null){
			this.currentAnchor.add(this.backAnchor, this.backFilter);
		}
		
	}
	
	
	private void initParentAnchor() {
		String parentPath = this.currentAnchor.parentPath();
		
		this.parentAnchor = ViewAnchor.createInstance(parentPath);
		
		if (this.parentAnchor != null)
			this.parentAnchor.add(this.currentAnchor, inFilter);
	}

	
	private void initInFilter(String[] elements){

		if (elements.length > 2){
						
			FilterType ft = FilterType.parse(elements[1]);
			
			this.inFilter = new Filter(ft, elements[2]);
		}
	}
	
	
	private void initBackAnchor(String[] elements){
		if (elements.length > 3){
			String backPath = Common.EMPTY;
			for (int i = 0; i < this.currentAnchor.getPathNameList().length; i++){
				backPath += this.currentAnchor.getPathNameList()[i] + ViewAnchor.SPLITER;
				if (this.currentAnchor.getPathNameList()[i].equals(elements[3]))
					break;
			}
				
			this.backAnchor = ViewAnchor.createInstance(backPath);
		}
	}
	
	
	private void initBackFilter(String[] elements){
		if (elements.length > 5){
			
			FilterType ft = FilterType.parse(elements[4]);
			
			this.backFilter = new Filter(ft, elements[5]);
		}
	}
	
}
