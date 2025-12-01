package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountInformationPage {

    WebDriver driver;

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender1")
    public WebElement mrRadio;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement days;

    @FindBy(id = "months")
    public WebElement months;

    @FindBy(id = "years")
    public WebElement years;

    @FindBy(id = "first_name")
    public WebElement firstName;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    public WebElement createAccountButton;

    public void fillAccountInfo() {
        mrRadio.click();
        password.sendKeys("Pass1234");
        days.sendKeys("10");
        months.sendKeys("July");
        years.sendKeys("2000");
        firstName.sendKeys("Abanoub");
        lastName.sendKeys("Youssef");
        address.sendKeys("Cairo");
        country.sendKeys("Canada");
        state.sendKeys("Ontario");
        city.sendKeys("Toronto");
        zipcode.sendKeys("A1A1A1");
        mobileNumber.sendKeys("01000000000");
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }
}
