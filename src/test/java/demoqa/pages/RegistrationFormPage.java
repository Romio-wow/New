package demoqa.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    public RegistrationFormPage openPage() {
        open("automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFistName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String date,String month,String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1983");
        $(byText("12")).click();
        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        $("#uploadPicture").uploadFromClasspath(value);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#state").click();
        $(".css-26l3qy-menu").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        $(".css-26l3qy-menu").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage clickSubmit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkResult(String key,String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }


}