package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Kotik");
        $("#lastName").setValue("Begemotikov");
        $("#userEmail").setValue("kotik@begemotikov.com");

        $(By.xpath("//label[@for='gender-radio-1']")).click();

        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(By.xpath("//select/option[@value=\"4\"]")).click();
        $(".react-datepicker__year-select").click();
        $(By.xpath("//select/option[@value=\"1990\"]")).click();
        $(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--010\"]")).click();

        $("#subjectsInput").setValue("C");

        $(By.xpath("//*[contains(text(), 'Chemistry')]")).click();

        $(By.xpath("//label[@for='hobbies-checkbox-2']")).click();

        $("#uploadPicture").uploadFromClasspath("1126.jpg");

        $("#currentAddress").setValue("ulitsa Kotikov, don Begemotikov");

        $(By.xpath("//*[contains(text(), 'Select State')]")).click();
        $(By.xpath("//*[contains(text(), 'Haryana')]")).click();

        $(By.xpath("//*[contains(text(), 'Select City')]")).click();
        $(By.xpath("//*[contains(text(), 'Karnal')]")).click();
        $("#submit").click();

        $(By.xpath("//tbody/tr[1]")).shouldHave(text("Kotik Begemotikov"));
        $(By.xpath("//tbody/tr[2]")).shouldHave(text("kotik@begemotikov.com"));
        $(By.xpath("//tbody/tr[3]")).shouldHave(text("Male"));
        $(By.xpath("//tbody/tr[4]")).shouldHave(text("1234567890"));
        $(By.xpath("//tbody/tr[5]")).shouldHave(text("10 May,1990"));
        $(By.xpath("//tbody/tr[6]")).shouldHave(text("Chemistry"));
        $(By.xpath("//tbody/tr[7]")).shouldHave(text("Reading"));
        $(By.xpath("//tbody/tr[8]")).shouldHave(text("1126.jpg"));
        $(By.xpath("//tbody/tr[9]")).shouldHave(text("ulitsa Kotikov, don Begemotikov"));
        $(By.xpath("//tbody/tr[10]")).shouldHave(text("Haryana Karnal"));
    }
}