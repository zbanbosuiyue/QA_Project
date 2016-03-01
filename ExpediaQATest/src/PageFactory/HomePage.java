package PageFactory;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import Common.CommonMethods;

public class HomePage {
	private WebDriver driver;
	CommonMethods CM;
	public String pageURL;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		CM = new CommonMethods(driver);
		CM.goToHome();
		PageFactory.initElements(driver, this);
	}
	
	////////////////////////						
	/*   Top Menu Header   */
	////////////////////////
	
	@FindBy(id = "primary-header-home")
	public  WebElement primaryHeaderHome;
	
	@FindBy(id = "primary-header-package")
	public WebElement primaryHeaderPackage;
	
	@FindBy(id = "primary-header-hotel")
	public WebElement primaryHeaderHotel;
	
	@FindBy(id = "primary-header-car")
	public WebElement primaryHeaderCars;
	
	@FindBy(id = "primary-header-flight")
	public WebElement primaryHeaderFlight;
	
	@FindBy(id = "primary-header-cruise")
	public WebElement primaryHeaderCruise;
	
	@FindBy(id = "primary-header-activity")
	public WebElement primaryHeaderThingToDo;
	
	@FindBy(id = "primary-header-deals")
	public WebElement primaryHeaderDeals;
	
	@FindBy(id = "primary-header-rewards")
	public WebElement primaryHeaderRewards;
	
	@FindBy(id = "primary-header-mobile")
	public WebElement primaryHeaderMobile;
	
	@FindBy(id = "header-account-menu")
	public WebElement	accountHeader;
	
	@FindBy(id = "header-account-signin-button")
	public WebElement signInButton;
	
	////////////////////////						
	/*   Tab Catelog  */
	////////////////////////

	@FindBy(id = "tab-flight-tab")
	public WebElement flightTab;
	
	@FindBy(id = "tab-hotel-tab")
	public WebElement hotelTab;
	
	@FindBy(id = "tab-package-tab")
	public WebElement packageTab;
	
	@FindBy(id = "tab-car-tab")
	public WebElement carTab;
	
	@FindBy(id = "tab-cruises-tab")
	public WebElement cruiseTab;
	
	@FindBy(id = "tab-activity-tab")
	public WebElement thingToDoTab;
	
	////////////////////////						
	/*   Flight Catelog  */
	////////////////////////
	
	@FindBy(id = "flight-type-roundtrip-label")
	public WebElement flightRoundTrip;
	
	@FindBy(id = "flight-type-one-way-label")
	public WebElement flightOneWay;	
	
	@FindBy(id = "flight-type-multi-dest-label")
	public WebElement flightMultiDest;
	
	@FindBy(id = "flight-origin")
	public WebElement flightOrigin;
	
	@FindBy(id = "flight-destination")
	public WebElement flightDestination;
	
	@FindBy(id = "flight-departing")
	public WebElement flightDepartingDate;
	
	@FindBy(id = "flight-returning")
	public WebElement flightReturningDate;
	
	@FindBy(id = "flight-adults")
	public WebElement flightAdult;
	
	@FindBy(id = "flight-children")
	public WebElement flightChildren;
	
	@FindBy(id = "advanced-options")
	public WebElement advancedOptions;
	
	@FindBy(id = "advanced-flight-nonstop-label")
	public WebElement flightNonStop;
	
	@FindBy(id = "advanced-flight-refundable-label")
	public WebElement flightRefundableFlight;
	
	@FindBy(id = "flight-advanced-preferred-airline")
	public WebElement flightPreferredAirline;

	@FindBy(id = "flight-advanced-preferred-class")
	public WebElement flightPreferredClass;
	
	@FindBy(id = "flight-add-hotel-checkbox")
	public WebElement flightAddHotelCheckbox;
	
	@FindBy(xpath = "//*[@id='flight-tab']/div[2]/label[1]")
	public WebElement flightAddHotelLabel;
	
	@FindBy(id = "flight-hotel-checkin")
	public WebElement flightHotelCheckIn;
	
	@FindBy(id = "flight-hotel-checkout")
	public WebElement flightHotelCheckOut;
	
	@FindBy(id = "flight-hotel-rooms")
	public WebElement flightHotelRooms;
	
	@FindBy(id = "flight-add-car-checkbox")
	public WebElement fightAddCarCheckbox;
	
	@FindBy(xpath = "//*[@id='flight-tab']/div[2]/label[2]")
	public WebElement flightAddCarLabel;
	
	@FindBy(id = "search-button")
	public WebElement searchButton;
	
	
	
	////////////////////////						
	/*   Hotels Catelog  */
	////////////////////////	
	
	@FindBy(id = "hotel-destination")
	public WebElement hotelGoingTo;
	
	@FindBy(id = "hotel-checkin")
	public WebElement hotelCheckIn;
	
	@FindBy(id = "hotel-checkout")
	public WebElement hotelCheckOut;
	
	@FindBy(id = "hotel-1-guest")
	public WebElement hotelGuests;
	
	@FindBy(id = "hotel-add-flight-checkbox")
	public WebElement hotelAddFlightCheckbox;
		
	@FindBy(xpath = "//*[@id='hotel']/div[2]/label[1]")
	public WebElement hotelAddFlightLabel;
	
	@FindBy(id = "hotel-add-car-checkbox")
	public WebElement hotelAddCarCheckbox;
		
	@FindBy(xpath = "//*[@id='hotel']/div[2]/label[2]")
	public WebElement hotelAddCarLabel;
	
	////////////////////////						
	/*   Functions  */
	////////////////////////

	public void goToSignIn(){
		Actions action = new Actions(driver);
		action.moveToElement(accountHeader).click().build().perform();
		signInButton.click();
	}
	
	public void setFlightFlyingFrom(String city){
		flightOrigin.clear();
		flightOrigin.sendKeys(city);
	}
	
	public void setFlightFlyingTo(String city){
		flightDestination.clear();
		flightDestination.sendKeys(city);
	}
	
	public void setDepartingDate(String sDate){
		flightDepartingDate.clear();
		flightDepartingDate.sendKeys(sDate);
	}
	
	public void setReturningDate(String sDate){
		flightReturningDate.clear();
		flightReturningDate.sendKeys(sDate);
	}
	
	public void setFlightAdults(String number){
		new Select(flightAdult).selectByValue(number);
	}
	
	public void setFlightChildren(String number){
		new Select(flightChildren).selectByValue(number);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		int num = Integer.parseInt(number);
		int i = 1;
		while(i<=num){
			Random ram = new Random();
			int age = ram.nextInt(12) + 5;		
			Select childSelect = new Select(driver.findElement(By.id("flight-age-select-"+i)));
			childSelect.selectByValue(String.valueOf(age));
			i++;
		}
	}
	
	public void flightAddHotel(){
		flightAddHotelLabel.click();
	}
	
	public void setFlightHotelCheckInDate(String sDate){
		flightHotelCheckIn.clear();
		flightHotelCheckIn.sendKeys(sDate);
	}
	
	public void setFlightHotelCheckOutDate(String sDate){
		flightHotelCheckOut.clear();
		flightHotelCheckOut.sendKeys(sDate);
	}
	
	public void setFlightHotelRooms(String number){
		new Select(flightHotelRooms).selectByValue(number);
	}
	
	public void flightAddCar(){
		flightAddCarLabel.click();
	}
	
	public void searchSubmit(){
		searchButton.click();
	}
	
}
