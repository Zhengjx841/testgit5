package testingHelpers.appiumHelpers;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Rectangle;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;


public class GesturePassword {

	AppiumDriver<?> driver;
	MobileElement gestureElement;

	int xSize = 3; 
	int ySize = 3; 

	int x0;
	int y0; 

	public GesturePassword(AppiumDriver<?> driver, MobileElement gestureElement) {
		this.driver = driver;
		this.gestureElement = gestureElement;

		this.x0 = this.gestureElement.getSize().width / xSize;
		this.y0 = this.gestureElement.getSize().height / ySize;

	}

	
	public void perform(int... sequence) {

		TouchAction ta = new TouchAction(driver);

		List<Integer> mySequence = new ArrayList<Integer>();
		for (int i : sequence) {
		
			if (isCorrectIndex(i))
				mySequence.add(i);
		}

		
		ta = ta.press(this.gestureElement.getLocation().x + getXOffset(mySequence.get(0)),
				this.gestureElement.getLocation().y + getYOffset(mySequence.get(0)));

		
		int prevIndex = mySequence.get(0);

		for (int i = 1; i < mySequence.size(); i++) {
			
			if (moveTo(ta, prevIndex, sequence[i])) {
				prevIndex = mySequence.get(i);
			}
		}

	
		ta.moveTo(1, 1).release().perform();

	}

	
	private boolean isCorrectIndex(int index) {
		if (index > 0 && index <= xSize * ySize)
			return true;

		return false;
	}


	@Deprecated
	public static Rectangle getRectangle(MobileElement element) {

		String[] bounds = element.getCssValue("bounds").split("\\[|\\]|,");
		int x = Integer.parseInt(bounds[0]);
		int y = Integer.parseInt(bounds[1]);
		int width = Integer.parseInt(bounds[2]) - x;
		int height = Integer.parseInt(bounds[3]) - y;

		return new Rectangle(x, y, height, width);
	}


	private int getXOffset(int index) {
		return ((index % xSize == 0) ? xSize : index % xSize) * x0 - x0 / 2;
	}


	private int getYOffset(int index) {
		return (index / xSize + ((index % xSize == 0) ? 0 : 1)) * y0 - y0 / 2;
	}

	
	private boolean moveTo(TouchAction ta, int startIndex, int endIndex) {

		ta.waitAction(500);
		int xoffset = getXOffset(endIndex) - getXOffset(startIndex);
		int yoffset = getYOffset(endIndex) - getYOffset(startIndex);

		ta = ta.moveTo(xoffset, yoffset);

		return true;
	}

}
