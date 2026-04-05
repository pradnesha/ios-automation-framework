package Pages;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage{

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    public HomePage()
    {

    }


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]")
    private WebElement firstCell;

//    @iOSXCUITFindBy(xpath = "//XCUImentTypeCell[1]")
//    private WebElement firstCell;

    public void clickFirstCell() {
//        firstCell.click();
          waitForElement(firstCell);
          click(firstCell);
          log.info("Clicked first cell from HomePage");
    }
}
