package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageControlUtils {

    private WebDriver driver;
    
    public PageControlUtils(WebDriver driver) {
	this.driver = driver;
    }
    
    public void getDataFromTable(WebElement tableElement, String Reqdata) {
	
	
	List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
	int rowCount = rows.size();
	
	for(int i=0; i<rowCount;i++) {
	    
	    List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
	    int columnsCount = columns.size();
	    
	    for(int j=0; j<columnsCount;j++) {
		String cellText = columns.get(j).getText();
		if(cellText.equals(Reqdata)) {
		    String data = columns.get(j).getText();
		}
	    }
	}
    }
}
