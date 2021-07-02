package com.upet.stepdefinitions;

import com.upet.pages.Dashboard;
import com.upet.pages.Profile;
import com.upet.pages.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSteps {

    SignUpPage signup = new SignUpPage();
    Dashboard dashboard = new Dashboard();
    Profile profile = new Profile();

    @Given("user is on the upet signup page and fill the information")
    public void user_is_on_the_upet_signup_page() {
        signup.fillForm();
    }

    @When("clicks the signup button")
    public void clicks_the_signup_button() {
        signup.clickCreateAccount();
    }

    @Then("user is taken to the dashboard")
    public void user_is_taken_to_the_dashboard() {
        dashboard.verifyDashboard();
    }

    @Then("user upload the profile picture")
    public void user_upload_the_profile_picture() {
        dashboard.goToProfile();
        profile.uploadProfilePicture();
    }
}
