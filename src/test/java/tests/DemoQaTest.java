package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Kotik");
        $("#lastName").setValue("Begemotikov");
        $("#userEmail").setValue("kotik@begemotikov.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__month").$(byText("10")).click();

        $("#subjectsInput").setValue("C");
        $(".subjects-auto-complete__menu-list").$(byText("Chemistry")).click();

        $("#hobbiesWrapper").shouldHave(text("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("1126.jpg");

        $("#currentAddress").setValue("ulitsa Kotikov, don Begemotikov");

        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(text("Student Name Kotik Begemotikov"));
        $(".table-responsive").shouldHave(text("Student Email kotik@begemotikov.com"));
        $(".table-responsive").shouldHave(text("Gender Male"));
        $(".table-responsive").shouldHave(text("Mobile 1234567890"));
        $(".table-responsive").shouldHave(text("Date of Birth 10 May,1990"));
        $(".table-responsive").shouldHave(text("Subjects Chemistry"));
        $(".table-responsive").shouldHave(text("Hobbies Reading"));
        $(".table-responsive").shouldHave(text("Picture 1126.jpg"));
        $(".table-responsive").shouldHave(text("Address ulitsa Kotikov, don Begemotikov"));
        $(".table-responsive").shouldHave(text("State and City Haryana Karnal"));
    }
}