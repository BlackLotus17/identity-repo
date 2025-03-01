package com.identity.pages;

import com.identity.utilites.PlateNumReader;
import com.identity.utilites.TextExtractor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(id="subForm1")
    private WebElement vrmInput = null;

    @FindBy(css="button[class*='check-now-button']")
    private WebElement formButton = null;

    @FindBy(css = "table[class*='table table-responsive']")
    private WebElement carDataElement = null;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage checkRegNumber(Integer carPosition) throws IOException {
        String regNumber = this.getRegistrationNumber(carPosition);

        vrmInput.sendKeys(regNumber);
        formButton.click();
        return this;
    }

    public List<String> getCarDataFromWebApp(String regNumber) throws InterruptedException, IOException {
        Thread.sleep(1000);
        List<String> data = new ArrayList<>();
        data.add(regNumber);
        List<WebElement> cells = carDataElement.findElements(By.tagName("td"));
        int[] indicesToCollect = {1, 3, 7}; // 0-based indices for 1st, 3rd, and 7th <td>

        for (int index : indicesToCollect) {
            if (index < cells.size()) {
                String cellText = cells.get(index).getText();
                if (cellText != null && !cellText.isEmpty()) {
                    data.add(cellText.replaceAll("\\s", ""));
                }
            }
        }
        return data;
    }


    public List<String> getCarDetailFromFile(String regNumber) throws IOException {
        List<String> fromOutFile = TextExtractor.extractValues();

        List<String> myList = new ArrayList<>();
        // Find and print elements starting with the prefix
        for (String fileLine : fromOutFile) {
            if (fileLine.startsWith(regNumber.substring(0, 3))) {
                String[] indChar = fileLine.replaceAll("\\s", "").split(",");
                myList = Arrays.asList(indChar);
            }
        }
        return myList;
    }

    public String getRegistrationNumber(Integer carPosition) throws IOException {
        PlateNumReader extractorFactory = new PlateNumReader();
        List<String> store = extractorFactory.extractRegNumber();
        return store.get(carPosition);
    }
}
