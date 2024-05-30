package commons;

import driver.DriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.admin.AdminHomePageObject;
import pageObjects.admin.AdminLoginPageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static commons.BasePageUI.*;
import static commons.GlobalConstants.*;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.testng.Assert.assertTrue;
import static pageUIs.admin.AdminLoginPageUI.*;

public class BasePage {
    public AdminHomePageObject goToAdminHomePage() {
        AdminLoginPageObject loginPage = new AdminLoginPageObject(VIB_ADMIN_LOGIN);
        AdminHomePageObject homePage;
        homePage = loginPage.loginWebsite(ADMIN_ACCOUNT_TEXT, ADMIN_PASSWORD_TEXT);
        return new AdminHomePageObject();
    }

    public static BasePage getBasePageObject() {
        return new BasePage();
    }

    public void openPageUrl(String pageUrl) {
        DriverManager.getDriver().get(pageUrl);
    }

    public AdminHomePageObject clickGoToAdminHomePageIcon() {
        sleepInSecond(SHORT_TIMEOUT);
        waitForElementClickable(BasePageUI.HOME_PAGE_ICON);
        clickToElement(BasePageUI.HOME_PAGE_ICON);
        return new AdminHomePageObject();
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

    protected String getPageUrl() {
        return DriverManager.getDriver().getTitle();
    }

    protected String getPageSourceCode() {
        return DriverManager.getDriver().getPageSource();
    }

    protected void backToPage() {
        DriverManager.getDriver().navigate().back();
    }

    protected void forwardToPage() {
        DriverManager.getDriver().navigate().forward();
    }

    public void refreshCurrentPage() {
        DriverManager.getDriver().navigate().refresh();
    }

    public Set<Cookie> getAllCookies() {
        return DriverManager.getDriver().manage().getCookies();
    }

    public void setCookies(Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            DriverManager.getDriver().manage().addCookie(cookie);
        }
        sleepInSecond(3);
    }

    protected Alert waitForAlertPresence() {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert() {
        waitForAlertPresence().accept();
    }

    protected void cancelAlert() {
        waitForAlertPresence().dismiss();
    }

    protected String getTextAlert() {
        return waitForAlertPresence().getText();
    }

    protected void sendKeyToAlert(String textValue) {
        waitForAlertPresence().sendKeys(textValue);
    }

    protected void switchToWindowByID(String windowID) {
        Set<String> allWindowIDs = DriverManager.getDriver().getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(windowID)) {
                DriverManager.getDriver().switchTo().window(id);
                break;
            }
        }
    }

    protected void switchToWindowByPageTitle(String expectedPageTitle) {
        Set<String> allWindowIDs = DriverManager.getDriver().getWindowHandles();
        for (String id : allWindowIDs) {
            DriverManager.getDriver().switchTo().window(id);
            // sleepInSecond(2);
            String actualPageTitle = DriverManager.getDriver().getTitle().trim();
            if (actualPageTitle.equals(expectedPageTitle)) {
                break;
            }
        }
    }

    protected void closeAllWindowWithoutParent(String parentID) {
        Set<String> allWindowIDs = DriverManager.getDriver().getWindowHandles();
        for (String id : allWindowIDs) {
            if (!id.equals(parentID)) {
                DriverManager.getDriver().switchTo().window(id);
                DriverManager.getDriver().close();
            }
            DriverManager.getDriver().switchTo().window(parentID);
        }
    }

    private String getDynamicXpath(String locator, String... dynamicValues) {
        locator = String.format(locator, (Object[]) dynamicValues);
        return locator;
    }


    private WebElement getWebElement(String locatorType) {
        return DriverManager.getDriver().findElement(By.xpath(locatorType));
    }

    public List<WebElement> getListWebElement(String locator) {
        return DriverManager.getDriver().findElements(By.xpath(locator));
    }

    public void clickToElement(String locatorType) {
        this.getWebElement(locatorType).click();
    }

    public void clickToElement(String locatorType, String... dynamicValues) {
        this.getWebElement(getDynamicXpath(locatorType, dynamicValues)).click();
    }

    public void clickAndHold(String locatorType) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.clickAndHold(this.getWebElement(locatorType)).moveByOffset(-1000, 0).release().build().perform();
    }

    public void dragAndDrop(String locatorFrom, String locatorTo) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.dragAndDrop(this.getWebElement(locatorFrom), this.getWebElement(locatorTo)).build().perform();
    }

    public void sendKeyToElement(String locatorType, String textValue) {
        WebElement element = this.getWebElement(locatorType);
        clearElementText(locatorType);
        element.sendKeys(textValue);
    }

    public void clearElementText(String locatorType) {
        WebElement element = getWebElement(locatorType);
        sleepMiliSecond(200);
        getActions().click(element).keyDown(element, Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
        if (!"".equals(element.getText()))
            getActions().keyDown(element, Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
        sleepMiliSecond(200);
    }

    public void clearElementText(String locatorType, String... dynamicValues) {
        WebElement element = this.getWebElement(getDynamicXpath(locatorType, dynamicValues));
        sleepMiliSecond(200);
        getActions().click(element).keyDown(element, Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
        if (!"".equals(element.getText()))
            getActions().keyDown(element, Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build().perform();
        sleepMiliSecond(200);
    }

    public static Actions getActions() {
        return new Actions(DriverManager.getDriver());
    }

    public void clearValueInElementByDeleteKey(String locatorType) {
        WebElement element = this.getWebElement(locatorType);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void sendKeyToElement(String locatorType, String textValue, String... dynamicValues) {
        WebElement element = this.getWebElement(getDynamicXpath(locatorType, dynamicValues));
        clearElementText(locatorType, dynamicValues);
        element.sendKeys(textValue);
    }

    public String getElementText(String locatorType) {
        return this.getWebElement(locatorType).getText();
    }

    public String getElementText(String locatorType, String... dynamicValues) {
        return this.getWebElement(getDynamicXpath(locatorType, dynamicValues)).getText();
    }

    public void selecItemInDefaultDropdown(String locatorType, String textItem) {
        Select select = new Select(this.getWebElement(locatorType));
        select.selectByVisibleText(textItem);
    }

    public void selecItemInDefaultDropdown(String locatorType, String textItem, String... dynamicValues) {
        Select select = new Select(this.getWebElement(getDynamicXpath(locatorType, dynamicValues)));
        select.selectByVisibleText(textItem);
    }

    public String getSelectedItemDefaultDropdown(String locatorType) {
        Select select = new Select(this.getWebElement(locatorType));
        return select.getFirstSelectedOption().getText();
    }

    public String getSelectedItemDefaultDropdown(String locatorType, String... dynamicValues) {
        Select select = new Select(this.getWebElement(getDynamicXpath(locatorType, dynamicValues)));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropDownMultiple(String locatorType) {
        Select select = new Select(this.getWebElement(locatorType));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(String parentLocator, String childLocator) {
        sleepInSecond(2);
        this.getWebElement(parentLocator).click();
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
        for (WebElement item : allItems) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
            sleepInSecond(1);
            item.click();
            break;
        }
    }

    public String getTextByJs (String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        WebElement element = DriverManager.getDriver().findElement(By.xpath(locator));
        String contents = (String) jsExecutor.executeScript("return arguments[0].innerHTML;", element);
        return contents;
    }

    public String getTextByJs (String locator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        String element = getWebElement(getDynamicXpath(locator, dynamicValues)).getText();
        String contents = (String) jsExecutor.executeScript("return arguments[0].innerHTML;", element);
        return contents;
    }

    public String getElementAttribute(String locatorType, String attributeName) {
        return this.getWebElement(locatorType).getAttribute(attributeName);
    }

    public String getElementAttribute(String locatorType, String attributeName, String... dynamicValues) {
        return this.getWebElement(getDynamicXpath(locatorType, dynamicValues)).getAttribute(attributeName);
    }

    public String getCssValue(String locator, String propertyName) {
        return this.getWebElement(locator).getCssValue(propertyName);
    }

    public String getHexaColorFromRGBA(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementsSize(String locatorType) {
        return getListWebElement(locatorType).size();
    }

    public int getElementsSize(String locatorType, String... dynamicValues) {
        return getListWebElement(getDynamicXpath(locatorType, dynamicValues)).size();
    }

    public void checkToDefaultCheckBoxOrRadio(String locatorType) {
        WebElement element = this.getWebElement(locatorType);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void checkToDefaultCheckBoxOrRadio(String locatorType, String... dynamicValues) {
        WebElement element = this.getWebElement(getDynamicXpath(locatorType, dynamicValues));
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckBox(String locatorType) {
        WebElement element = this.getWebElement(locatorType);
        if (element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToDefaultCheckBox(String locatorType, String... dynamicValues) {
        WebElement element = this.getWebElement(getDynamicXpath(locatorType, dynamicValues));
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplay(String locatorType) {
        return this.getWebElement(locatorType).isDisplayed();
    }

    public boolean isElementUndisplayed(String locatorType) {
        overrideImplicitTimeout(shortTimeout);
        List<WebElement> elements = getListWebElement(locatorType);
        overrideImplicitTimeout(longTimeout);

        // ko có trong DOM
        if (elements.size() == 0) {
            return true;

            // có trong DOM nhưng ko hiển thị
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementUndisplayed(String locatorType, String... dynamicValues) {
        overrideImplicitTimeout(shortTimeout);
        List<WebElement> elements = getListWebElement(getDynamicXpath(locatorType, dynamicValues));
        overrideImplicitTimeout(longTimeout);

        if (elements.size() == 0) {
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void overrideImplicitTimeout(long timeOut) {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public boolean isElementDisplay(String locatorType, String... dynamicValues) {
        return this.getWebElement(getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
    }

    public boolean isElementEnable(String locator) {
        return this.getWebElement(locator).isEnabled();
    }

    public boolean isElementSelected(String locator) {
        return this.getWebElement(locator).isSelected();
    }

    public void switchToFrameIframe(String locator) {
        DriverManager.getDriver().switchTo().frame(this.getWebElement(locator));
    }

    public void switchToDefaultContent() {
        DriverManager.getDriver().switchTo().defaultContent();
    }

    public void hoverMouseToElement(String locatorType) {
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(this.getWebElement(locatorType)).perform();
    }

    public void pressKeyToElement(String locatorType, Keys key) {
        Actions action = new Actions(DriverManager.getDriver());
        action.sendKeys(this.getWebElement(locatorType), key).perform();
    }

    public void pressKeyToElement(String locatorType, Keys key, String... dynamicValues) {
        Actions action = new Actions(DriverManager.getDriver());
        action.sendKeys(this.getWebElement(getDynamicXpath(locatorType, dynamicValues)), key).perform();
    }

    public void scrollToBottomPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void scrollToTopPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("window.scrollTo(0,0)");
    }
    public void highlightElement(String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        WebElement element = this.getWebElement(locatorType);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void highlightElement(String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        WebElement element = this.getWebElement(getDynamicXpath(locatorType, dynamicValues));
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
    }

    public void clickToElementByJS(String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("arguments[0].click();", this.getWebElement(locatorType));
    }

    public void clickToElementByJS(String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("arguments[0].click();", this.getWebElement(getDynamicXpath(locatorType, dynamicValues)));
    }

    public void scrollToElement(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", this.getWebElement(locator));
    }

    public void scrollToElement(String locator, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", this.getWebElement(getDynamicXpath(locator, dynamicValues)));
    }

    public void removeAttributeInDOM(String locator, String attributeRemove) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", this.getWebElement(locator));
    }

//    public boolean areJQueryAndJSLoadedSuccess() {
//        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply() {
//                try {
//                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
//                } catch (Exception e) {
//                    return true;
//                }
//            }
//        };
//
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply() {
//                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
//            }
//        };
//        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
//    }

    public String getElementValidationMessage(String locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", this.getWebElement(locator));
    }

    public boolean isImageLoaded(String locatorType) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(locatorType));
        if (status) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImageLoaded(String locatorType, String... dynamicValues) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) DriverManager.getDriver();
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                getWebElement(getDynamicXpath(locatorType, dynamicValues)));
        return status;
    }

    public void uploadImage(String locator, String imagePath) {
        WebElement element = this.getWebElement(locator);
        element.sendKeys(imagePath);
    }

    public void waitForElementVisible(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorType)));
    }

    public void waitForElementVisible(String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForAllElementVisible(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locatorType)));
    }

    public void waitForAllElementVisible(String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForElementInvisible(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorType)));
    }

    /*
     * Wait for element undisplayed in DOM or not in DOM and override implicit timeout
     */
    public void waitForElementUndisplayed(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(shortTimeout));
        overrideImplicitTimeout(shortTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorType)));
        overrideImplicitTimeout(longTimeout);
    }


    public void waitForAllElementInvisible(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(locator)));
    }

    public void waitForElementClickable(String locatorType) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorType)));
    }

    public void waitForElementClickable(String locatorType, String... dynamicValues) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(getDynamicXpath(locatorType, dynamicValues))));
    }

    public void waitForLoadingIconInvisible() {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADING_ICON)));
    }

    public void waitForLoadingItemInvisible() {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(LOADING_ITEM)));
    }

    /**
     * Enter to dynamic Textbox by ID
     *
     * @param textboxID
     * @param value
     */
    public void inputToTextboxByID(String textboxID, String value) {
        waitForElementVisible(DYNAMIC_TEXTBOX_BY_ID, textboxID);
        sendKeyToElement(DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
    }

    /**
     * Click to dynamic Button by text
     *
     * @param buttonText
     */
    public void clickToButtonByText(String buttonText) {
        waitForElementClickable(DYNAMIC_BUTTON_BY_TEXT, buttonText);
        clickToElement(DYNAMIC_BUTTON_BY_TEXT, buttonText);
    }

    public void clickToInputByPlaceholder(String inputText) {
        waitForElementClickable(DYNAMIC_INPUT_BY_PLACEHOLDER, inputText);
        clickToElement(DYNAMIC_INPUT_BY_PLACEHOLDER, inputText);
    }

    public void inputByPlaceholder(String inputText, String value) {
        waitForElementClickable(DYNAMIC_INPUT_BY_PLACEHOLDER, inputText);
        sendKeyToElement(DYNAMIC_INPUT_BY_PLACEHOLDER, value, inputText);
    }

    public void inputDynamic(String inputText, String value) {
        waitForElementClickable(DYNAMIC_INPUT, inputText);
        sendKeyToElement(DYNAMIC_INPUT, value, inputText);
    }

    public String getErrorInputByPlaceholder(String errorTextInput) {
        waitForElementVisible(DYNAMIC_ERROR_INPUT_BY_PLACEHOLDER, errorTextInput);
        return getElementText(DYNAMIC_ERROR_INPUT_BY_PLACEHOLDER, "value", errorTextInput);
    }

    /**
     * Select to Dynamic Dropdown by name attribute
     *
     * @param itemValue
     */
    public void selectToDropdownByName(String dropDownAttributeName, String itemValue) {
        waitForElementClickable(DYNAMIC_DROPDOWN_BY_NAME, dropDownAttributeName);
        selecItemInDefaultDropdown(DYNAMIC_DROPDOWN_BY_NAME, itemValue, dropDownAttributeName);
    }

    /**
     * Select to Dynamic Radio by label
     *
     * @param radioButtonLabelName
     */
    public void clickToRadioButtonByLabel(String radioButtonLabelName) {
        waitForElementVisible(DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
        checkToDefaultCheckBoxOrRadio(DYNAMIC_RADIO_BUTTON_BY_LABEL, radioButtonLabelName);
    }

    /**
     * Select to Dynamic Checkbox by label name
     *
     * @param checkboxLabelName
     */
    public void clickToCheckboxByLabel(String checkboxLabelName) {
        waitForElementVisible(DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
        checkToDefaultCheckBoxOrRadio(DYNAMIC_CHECKBOX_BY_LABEL, checkboxLabelName);
    }

    /**
     * Get Dynamic value in Textbox by ID
     */
    public String getTextboxValueByID(String textboxID) {
        waitForElementVisible(DYNAMIC_TEXTBOX_BY_ID, textboxID);
        return getElementAttribute(DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
    }

    public void sleepInSecond(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepMiliSecond(double miliSecond) {
        try {
            Thread.sleep((long) (miliSecond));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomInt() {
        return randomNumeric(5);
    }

    public static String getRandomIntEightNumber() {
        return randomNumeric(8);
    }

    public static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    private int longTimeout = GlobalConstants.LONG_TIMEOUT;
    private int shortTimeout = GlobalConstants.SHORT_TIMEOUT;

    public void switchWindowsByIndex (Integer tabNumber){
        Set<String> allHandles = driver.DriverManager.getDriver().getWindowHandles();
        List<String> handlesList = new ArrayList<>(allHandles);
        driver.DriverManager.getDriver().switchTo().window(handlesList.get(tabNumber));
    }

    public void zoomPage (WebDriver driver, Double zoomNumber) {
        // Sử dụng JavascriptExecutor để thực hiện zoom out
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.body.style.zoom='"+ zoomNumber +"'");
    }
}
