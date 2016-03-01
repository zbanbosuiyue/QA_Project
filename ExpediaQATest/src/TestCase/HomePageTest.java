package TestCase;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.CommonMethods;
import PageFactory.HomePage;
import PageFactory.HomePageParameters;

public class HomePageTest implements HomePageParameters{
	private WebDriver driver;
	
	public CommonMethods CM;
	public List<List<String>> data;
	public List<String> titles;
	public HomePage HP;
	
	private int testCaseIndex;

	public String filePath = "./data/HomePageTestCase.xlsx";
	
	
	@BeforeTest
	public void prepareData(){
		CM = new CommonMethods(driver);
		driver = CM.openBrowser("Chrome");
		data = CM.readData(filePath);
		titles = data.get(0);
	}
	
	@BeforeMethod
	public void clearCookies(){
		CM.clearCookies();
	}

	
	@Test
	public void BookingTest01(){
		testCaseIndex = 1;
		System.out.println("Round Trip.");
		System.out.println(data.get(testCaseIndex));
		HP = new HomePage(driver);
		HP.flightTab.click();
		HP.flightRoundTrip.click();
			
		HP.setFlightFlyingFrom(data.get(testCaseIndex).get(FlyingFrom));
		HP.setFlightFlyingTo(data.get(testCaseIndex).get(FlyingTo));
		HP.setDepartingDate(data.get(testCaseIndex).get(DepartingDate));
		HP.setReturningDate(data.get(testCaseIndex).get(ReturningDate));
		HP.setFlightAdults(data.get(testCaseIndex).get(Adults));
		HP.setFlightChildren(data.get(testCaseIndex).get(Children));
		
		if(data.get(testCaseIndex).get(isAddHotel)=="1"){
			HP.setFlightHotelCheckInDate(data.get(testCaseIndex).get(HotelCheckIn));
			HP.setFlightHotelCheckOutDate(data.get(testCaseIndex).get(HotelCheckOut));
			HP.setFlightHotelRooms(data.get(testCaseIndex).get(HotelRooms));
		}
		
		HP.searchSubmit();
		
		//Verify
		if(data.get(testCaseIndex).get(isPositive) == "1"){
			CM.verifyContainText("//*[@id='titleBar']/h1/div/span[1]", data.get(testCaseIndex).get(FlyingTo));
		}
	}
	
	@Test
	public void BookingTest02(){
		testCaseIndex = 2;
		System.out.println("Round Trip.");
		System.out.println(data.get(testCaseIndex));
		HP = new HomePage(driver);
		HP.flightTab.click();
		HP.flightRoundTrip.click();
			
		HP.setFlightFlyingFrom(data.get(testCaseIndex).get(FlyingFrom));
		HP.setFlightFlyingTo(data.get(testCaseIndex).get(FlyingTo));
		HP.setDepartingDate(data.get(testCaseIndex).get(DepartingDate));
		HP.setReturningDate(data.get(testCaseIndex).get(ReturningDate));
		HP.setFlightAdults(data.get(testCaseIndex).get(Adults));
		HP.setFlightChildren(data.get(testCaseIndex).get(Children));
		
		if(data.get(testCaseIndex).get(isAddHotel)=="1"){
			HP.setFlightHotelCheckInDate(data.get(testCaseIndex).get(HotelCheckIn));
			HP.setFlightHotelCheckOutDate(data.get(testCaseIndex).get(HotelCheckOut));
			HP.setFlightHotelRooms(data.get(testCaseIndex).get(HotelRooms));
		}
		
		HP.searchSubmit();
		//Verify
		if(data.get(testCaseIndex).get(isPositive) == "1"){
			CM.verifyContainText("//*[@id='titleBar']/h1/div/span[1]", data.get(testCaseIndex).get(FlyingTo));
		}
	}
	
	@Test
	public void BookingTest03(){
		testCaseIndex = 3;
		System.out.println("Round Trip.");
		System.out.println(data.get(testCaseIndex));
		HP = new HomePage(driver);
		HP.flightTab.click();
		HP.flightRoundTrip.click();
			
		HP.setFlightFlyingFrom(data.get(testCaseIndex).get(FlyingFrom));
		HP.setFlightFlyingTo(data.get(testCaseIndex).get(FlyingTo));
		HP.setDepartingDate(data.get(testCaseIndex).get(DepartingDate));
		HP.setReturningDate(data.get(testCaseIndex).get(ReturningDate));
		HP.setFlightAdults(data.get(testCaseIndex).get(Adults));
		HP.setFlightChildren(data.get(testCaseIndex).get(Children));
		
		if(data.get(testCaseIndex).get(isAddHotel)=="1"){
			HP.setFlightHotelCheckInDate(data.get(testCaseIndex).get(HotelCheckIn));
			HP.setFlightHotelCheckOutDate(data.get(testCaseIndex).get(HotelCheckOut));
			HP.setFlightHotelRooms(data.get(testCaseIndex).get(HotelRooms));
		}
		
		HP.searchSubmit();
		//Verify
		if(data.get(testCaseIndex).get(isPositive) == "1"){
			CM.verifyContainText("//*[@id='titleBar']/h1/div/span[1]", data.get(testCaseIndex).get(FlyingTo));
		}
	}
	
	@Test
	public void BookingTest04(){
		testCaseIndex = 4;
		System.out.println("Round Trip.");
		System.out.println(data.get(testCaseIndex));
		HP = new HomePage(driver);
		HP.flightTab.click();
		HP.flightRoundTrip.click();
			
		HP.setFlightFlyingFrom(data.get(testCaseIndex).get(FlyingFrom));
		HP.setFlightFlyingTo(data.get(testCaseIndex).get(FlyingTo));
		HP.setDepartingDate(data.get(testCaseIndex).get(DepartingDate));
		HP.setReturningDate(data.get(testCaseIndex).get(ReturningDate));
		HP.setFlightAdults(data.get(testCaseIndex).get(Adults));
		HP.setFlightChildren(data.get(testCaseIndex).get(Children));
		
		if(data.get(testCaseIndex).get(isAddHotel)=="1"){
			HP.setFlightHotelCheckInDate(data.get(testCaseIndex).get(HotelCheckIn));
			HP.setFlightHotelCheckOutDate(data.get(testCaseIndex).get(HotelCheckOut));
			HP.setFlightHotelRooms(data.get(testCaseIndex).get(HotelRooms));
		}
		
		HP.searchSubmit();
		//Verify
		if(data.get(testCaseIndex).get(isPositive) == "1"){
			CM.verifyContainText("//*[@id='titleBar']/h1/div/span[1]", data.get(testCaseIndex).get(FlyingTo));
		}
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
