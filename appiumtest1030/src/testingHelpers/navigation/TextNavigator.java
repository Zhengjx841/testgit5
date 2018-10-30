package testingHelpers.navigation;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.openqa.selenium.WebDriver;

import testingHelpers.util.Common;



public class TextNavigator extends Navigator {

	private final static String CONFIG_DIRECTORY_NAME = "config";
	
	
	
	
		
	// 配置文件中的元素分隔符
	private static String SPLITER = " |\t";
	
	
	public static void setSpliter(String spliter){
		if (!Common.isNullOrEmpty(spliter))
			TextNavigator.SPLITER = spliter;
	}
	
	
	public TextNavigator(WebDriver driver) {

		this("navigator.txt", driver);
		
		// TODO Auto-generated constructor stub
		
	}
	
	
	public TextNavigator(String configFileName, WebDriver driver){
		super(configFileName, driver);
		
	}
	


	
	private static boolean isComment(String text){
		if (text.charAt(0) == Common.SHARP)
			return true;
		
		return false;
	}
	
	@Override
	protected void initAnchors() {
		
		File classpathRoot = new File(Common.currentPath());
		File testConfigDir = new File(classpathRoot, CONFIG_DIRECTORY_NAME);
		File navigatorInfo = new File(testConfigDir, this.sharedObj.toString());
		
		
		// TODO Auto-generated method stub
		if (! navigatorInfo.exists())
			return;


		FileReader fr;
		try {
			fr = new FileReader(navigatorInfo);
			BufferedReader br = new BufferedReader(fr);
			
			String temp = br.readLine();
			
			while (temp != null){
				if (!isComment(temp)){					
					AnchorHelper ah = AnchorHelper.loadElements(temp.split(TextNavigator.SPLITER));

					if (ah.getCurrentAnchor().isHeadAnchor())
						this.startAnchor = ah.getCurrentAnchor();
				}
				
				temp = br.readLine();
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
