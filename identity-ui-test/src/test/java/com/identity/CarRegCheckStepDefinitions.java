package com.identity;

import com.identity.pages.HomePage;
import com.identity.support.World;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class CarRegCheckStepDefinitions {

    private final World helper;
    private HomePage homePage;

    public CarRegCheckStepDefinitions(World helper){
        this.helper = helper;
    }

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage =  helper.getBasePage().loadApplication();
    }
    @When("I check {int} registration number")
    public void i_check_registration_number(Integer carPosition) throws IOException {
        homePage = homePage.checkRegNumber(carPosition);
    }

    @Then("I will get result for {int}")
    public void i_will_get_result_for(Integer carPosition) throws InterruptedException, IOException {
       String regNumber = homePage.getRegistrationNumber(carPosition);

       // Get car detail from website
        List<String> carDetailFromWebSite = homePage.getCarDataFromWebApp(regNumber);

        //  Get car detail from local file
        List<String> carDetailFromFile = homePage.getCarDetailFromFile(regNumber);

        // Assertion for the tests
        assertThat(carDetailFromFile, Matchers.containsInAnyOrder(carDetailFromWebSite.toArray()));
    }
}
