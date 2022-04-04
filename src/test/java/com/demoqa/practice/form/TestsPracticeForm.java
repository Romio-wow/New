package com.demoqa.practice.form;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestsPracticeForm {
    @BeforeAll

    static void preconditions(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTests () {

        Selenide.open("automation-practice-form");

        String name = "Rick";
        String surname = "Sanchez";
        String mail = "roman.mi@mail.ru";
        String phoneNumber = "8916445858";
        String month = "November";
        String year = "1983";
        String subject = "History";
        String currentAddressText = "Hello world";


        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(mail);
        $(byText("Male")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(byText("12")).click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue(currentAddressText);
        $(".css-1wa3eu0-placeholder").click();
        $(byText("NCR")).click();
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text(name + " " + surname),
                text(mail),text("Gender Male"),text(phoneNumber),
                text(phoneNumber),text("Date of Birth" + " " + "12 November,1983"),
                text(subject),text("Hobbies" + " " + "Sports"),
                text("Picture" + " " + "1.jpg"),text(currentAddressText),
                text("State and City" + " " + "NCR Delhi"));
    }
}
