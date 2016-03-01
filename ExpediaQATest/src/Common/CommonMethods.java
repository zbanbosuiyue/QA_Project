package Common;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

public class CommonMethods {
	public String baseURL;
	public String PATH_CHROME_DRIVER;
	//public static WebDriver defaultWebDriver = new FirefoxDriver();
	private WebDriver driver;
	
	public CommonMethods(WebDriver driver){
		this.driver = driver;
		try {
			FileInputStream fis = new FileInputStream(new File("./QATest.properties"));
			Properties prop = new Properties();
			try {
				prop.load(fis);
				
				baseURL = prop.getProperty("BaseURL");
				PATH_CHROME_DRIVER = prop.getProperty("CHROME_PATH");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Can't find the properties file.");
			e.printStackTrace();
		}	
	}
	
	public WebDriver openBrowser(String browserType){
		String type = browserType.toLowerCase();
		if (type.contains("fire")){
			this.driver = new FirefoxDriver();
		}
		else if(type.contains("chrome")){
			
			File chromedriver = new File(PATH_CHROME_DRIVER);
			System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
			DesiredCapabilities Capabilities = new DesiredCapabilities();
			Capabilities = DesiredCapabilities.chrome();
			Capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			this.driver = new ChromeDriver();
		}
		else if(type.contains("ie")){
			this.driver = new InternetExplorerDriver();
		}
		else{
			this.driver = new FirefoxDriver();
			System.out.println("Driver Not Setup, change to default Firefox driver");
		}
		driver.manage().window().maximize();
		
		return this.driver;
	}
	
	public void goToHome(){
		//System.out.println(baseURL);
		driver.get(baseURL);
	}
	
	public String getTitle(){
		try{
			return driver.getTitle();
		}
		catch(Exception e){
			return "Not able to capture title";
		}
	}
	
	
	public void clickElementByXPATH(String element){
		try{
			driver.findElement(By.xpath(element)).click();
			String name = driver.findElement(By.xpath(element)).getText();
			System.out.println("Element '" + name + "' is being clicked");
		}catch(NoSuchElementException e){
			System.out.println(element+" not found");
		}
	 }


	public void clickElementByLinkText(String element){
		try{
			driver.findElement(By.linkText(element)).click();
			System.out.println(element+" clicked");
		}catch(Exception e){
			System.out.println(element+" not found");
		}
	 }

	public void setValueByName(String elementName, String sValue){
		try{
			driver.findElement(By.name(elementName)).clear();
			driver.findElement(By.name(elementName)).sendKeys(sValue);
			System.out.println(sValue+" entered");
		}catch(Exception e){
			System.out.println(elementName+" not found");
		}
		
	}
	
	 
	 public void verifyText(String XPath,String ExpectedText){
		 try{
			 String ActualText = driver.findElement(By.xpath(XPath)).getText();
			 Assert.assertEquals(ActualText, ExpectedText);
		 }
		 catch(NoSuchElementException e){
			 Assert.fail("Can't No find the XPath");
		 }
	 }
	 
	 public void verifyContainText(String XPath, String ExpectedText){
		 try{
			 String ActualText = driver.findElement(By.xpath(XPath)).getText();
			 System.out.println("ActualText: " + ActualText);
			 System.out.println("ExpectedText: " + ExpectedText);
			 Assert.assertTrue(ActualText.contains(ExpectedText));
		 }
		 catch(NoSuchElementException e){
			 Assert.fail("Can't No find the XPath");
		 }
	 }
	 
	 
	 public void clearCookies(){
		 driver.manage().deleteAllCookies();
	 }
	 

	 public int iframeHandler(String xpath){
		 int index = -1;
		 List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		 for(int i=0; i<frames.size(); i++){
			 driver.switchTo().frame(i);
			 if(!driver.findElements(By.xpath(xpath)).isEmpty()){
				 System.out.println("IframeHandler: \nThe element is in the Number " + i 
						 + " Frame." );
				 index = i;
				 return index;
			 }
		 }
		 
		 if(index == -1){
			 System.out.println("Not Found Element in Each Frames.");
		 }
		 
		 return index;
	 }
	 
		public List<List<String>> readData(String filePath){
			List<List<String>> data = new ArrayList<List<String>>(); 
			try{
				FileInputStream file = new FileInputStream(new File(filePath));
				XSSFWorkbook workbook = new XSSFWorkbook(file);
				XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = sheet.iterator(); 
				while (rowIterator.hasNext()){
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					List<String> rowData = new ArrayList<String>();
					
					while(cellIterator.hasNext()){
						Cell cell = cellIterator.next();
						switch(cell.getCellType()){
						case Cell.CELL_TYPE_NUMERIC:
							if(DateUtil.isCellDateFormatted(cell)) {
								SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
								String newDate = sdf.format(cell.getDateCellValue());
								rowData.add(newDate);
							}
							else
								rowData.add(String.valueOf((int) cell.getNumericCellValue()));
							break;
							
						case Cell.CELL_TYPE_STRING:
							rowData.add(cell.getStringCellValue());
							break;
						}
					}
					data.add(rowData);
				}
				//System.out.println(data);
				file.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return data;
		}
}
