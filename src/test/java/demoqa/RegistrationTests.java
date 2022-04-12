package demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;


public class RegistrationTests {
    @BeforeAll

    static void preconditions() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTests() {
        Faker faker = new Faker();
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();


        String name = faker.name().firstName(),
                lastName = faker.name().lastName(),
                mail = faker.internet().emailAddress(),
                phoneNumber = faker.numerify("##########"),
                gender = faker.demographic().sex(),
                month = "November",
                year = "1983",
                day = "12",
                subject = "History",
                hobby = "Sports",
                picture = "1.jpg",
                currentAddressText = faker.address().streetAddress(),
                state = "NCR",
                sity = "Delhi";

        String expendetFullname = format("%s %s", name, lastName);
        String expendetFulldateOfBirth = format("%s %s", day, month, year);
        String expendetFullStateAndSity = format("%s %s", state, sity);


        registrationFormPage.openPage()
                .setFistName(name)
                .setLastName(lastName)
                .setEmail(mail)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobby)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddressText)
                .setState(state)
                .setCity(sity)
                .clickSubmit()

                //проверки
                .checkResult("Student Name", (expendetFullname))
                .checkResult("Student Email", mail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", expendetFulldateOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddressText)
                .checkResult("State and City", expendetFullStateAndSity)
        ;


    }
}
