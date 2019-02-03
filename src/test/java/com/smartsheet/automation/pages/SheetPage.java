package com.smartsheet.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.smartsheet.automation.utils.WebDriverHelper;

/**
 * This class is created to declare the variables on the Sheet Page. Class also
 * consists of the methods to perform actions on the elements
 * 
 * @author ravimaddali
 *
 */
public class SheetPage extends BasePage {

	@FindBy(xpath = "//*[@id='foid:23']/div/div[1]/div[4]")
	private WebElement _columnLocator;
	@FindBy(xpath = "//*[@id='foid:27']/div/table/tbody/tr[1]/td[2]")
	private WebElement _addLeftColumn;
	@FindBy(xpath = "//*[@id='foid:27']/div/table/tbody/tr[2]/td[2]")
	private WebElement _addRightColumn;
	@FindBy(xpath = "//*[@id='foid:27']/div/table/tbody/tr[3]/td[2]")
	private WebElement _delColumn;
	@FindBy(id = "foid:29")
	private WebElement _columnName;
	@FindBy(id = "foid:44")
	private WebElement _clickOK;

	public SheetPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Adds column to the left of selected column
	 */
	public void addColumnLeft() {
		WebDriverHelper.implicitWaits();
		Actions action = new Actions(driver);
		action.moveToElement(_columnLocator).contextClick().perform();
		WebDriverHelper.implicitWaits();
		action.moveToElement(driver.findElement(By.xpath("//*[@id='foid:26']/div/table/tbody/tr[1]/td[2]")))
				.sendKeys(Keys.RETURN).build().perform();
		_columnName.sendKeys("Left Column");

	}

	/**
	 * Adds column to the right of selected column
	 */
	public void addColumnRight() {
		WebDriverHelper.implicitWaits();
		Actions action = new Actions(driver);
		action.moveToElement(_columnLocator).contextClick().perform();
		WebDriverHelper.implicitWaits();
		action.moveToElement(driver.findElement(By.xpath("//*[@id='foid:26']/div/table/tbody/tr[2]/td[2]")))
				.sendKeys(Keys.RETURN).build().perform();
		_columnName.sendKeys("Right Column");
	}

	/**
	 * Deletes selected column
	 */
	public void deleteColumn() {
		Actions action = new Actions(driver);
		action.moveToElement(_columnLocator).contextClick().perform();
		WebDriverHelper.implicitWaits();
		action.moveToElement(driver.findElement(By.xpath("//*[@id='foid:26']/div/table/tbody/tr[3]/td[3]")))
				.sendKeys(Keys.RETURN).build().perform();
	}

	public void clickOkButton() {
		_clickOK.click();
	}
}
