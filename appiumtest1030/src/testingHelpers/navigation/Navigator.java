package testingHelpers.navigation;



import org.openqa.selenium.WebDriver;


public abstract class Navigator {

	protected Object sharedObj; 

	
	protected ViewAnchor currentAnchor;

	public ViewAnchor getCurrentAnchor() {
		return currentAnchor;
	}

	
	protected ViewAnchor startAnchor;

	
	protected abstract void initAnchors();

	WebDriver driver;

	protected Navigator(Object sharedObj, WebDriver driver) {
		this.sharedObj = sharedObj;
		
		initAnchors();

		this.currentAnchor = startAnchor;
		this.driver = driver;
	}

	public boolean moveTo(String anchorName) {

		ViewAnchor newAnchor = ViewAnchor.getAnchorByName(anchorName);

		if (newAnchor != null) {

			int index = moveToSameParentAnchor(newAnchor);

			for (int i = index + 1; i < newAnchor.getPathNameList().length; i++) {
				ViewAnchor anchor = this.currentAnchor.moveTo(newAnchor.getPathNameList()[i], driver);
				if (anchor != null)
					this.currentAnchor = anchor;
			}

			return true;

		}

		return false;
	}

	
	protected int moveToSameParentAnchor(ViewAnchor anchor) {
		
		int index = getMaxIndexOfSameElement(this.currentAnchor.getPathNameList(), 
				anchor.getPathNameList());

		if (index < this.currentAnchor.getPathNameList().length - 1) {
			for (int i = this.currentAnchor.getPathNameList().length - 2; i >= 0; i--) {
				ViewAnchor va = this.currentAnchor.moveTo(this.currentAnchor.getPathNameList()[i], driver);

				if (va != null) {
					this.currentAnchor = va;
					if (i <= index) {
						index = i;
						break;
					}
				}
			}
		}

		return index;

	}

	private static int getMaxIndexOfSameElement(String[] array1, String[] array2) {

		int length = (array1.length < array2.length) ? array1.length : array2.length;

		for (int i = 0; i < length; i++) {
			if (!array1[i].equals(array2[i]))
				return i - 1;
		}

		return length - 1;
	}

}
