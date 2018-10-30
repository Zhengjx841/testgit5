package testingHelpers.navigation;


public enum FilterType {
	ByAccessibilityId(1), 
	ByClassName(2), 
	ByCssSelector(3), 
	ById(4), 
	ByLinkText(5), 
	ByName(6), 
	ByPartialLinkText(7), 
	ByTagName(8), 
	ByXPath(9);

	public final static String BY_ID = "id";
	public final static String BY_LINK_TEXT = "link text";
	public final static String BY_PARTIAL_LINK_TEXT = "partial link text";
	public final static String BY_TAG_NAME = "tag name";
	public final static String BY_NAME = "name";
	public final static String BY_CLASS_NAME = "class name";
	public final static String BY_CSS_SELECTOR = "css selector";
	public final static String BY_XPATH = "xpath";

	public final static String BY_ACCESSIBILITY_ID = "accessibility id";

	private String description;

	public String getDescription() {
		return description;
	}

	private FilterType(int index) {
		switch (index) {
		case 1:
			this.description = BY_ACCESSIBILITY_ID;
			break;

		case 2:
			this.description = BY_CLASS_NAME;
			break;

		case 3:
			this.description = BY_CSS_SELECTOR;
			break;

		case 4:
			this.description = BY_ID;
			break;

		case 5:
			this.description = BY_LINK_TEXT;
			break;

		case 6:
			this.description = BY_NAME;
			break;

		case 7:
			this.description = BY_PARTIAL_LINK_TEXT;
			break;

		case 8:
			this.description = BY_TAG_NAME;
			break;

		case 9:
			this.description = BY_XPATH;
			break;

		default:
			this.description = BY_XPATH;
			break;
		}
	}

	// @Override
	// public String toString(){
	// return this.name;
	// }

	
	public static FilterType parse(int value) {	
		switch (value) {
		case 1:
			return FilterType.ByAccessibilityId;

		case 2:
			return FilterType.ByClassName;

		case 3:
			return FilterType.ByCssSelector;

		case 4:
			return FilterType.ById;

		case 5:
			return FilterType.ByLinkText;

		case 6:
			return FilterType.ByName;

		case 7:
			return FilterType.ByPartialLinkText;

		case 8:
			return FilterType.ByTagName;

		case 9:

		default:
			return FilterType.ByXPath;
		}
	}


	public static FilterType parse(String value){
		try{
		int index = Integer.parseInt(value);
		return parse(index);
		}catch(Exception e){
			return FilterType.valueOf(value);
		}
		
	}
	
}
