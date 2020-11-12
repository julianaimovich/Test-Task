import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.TAB;

public class FormPage {
    private SelenideElement cookieButton = $("[class='cookies-button']");
    private SelenideElement lastName = $("[name='last_name']");
    private SelenideElement firstName = $("[name='first_name']");
    private SelenideElement middleName = $("[name='middle_name']");
    private SelenideElement birthDate = $("[name='birth_date']");
    private SelenideElement phone = $("[name='phone']");
    private SelenideElement email = $("[name='email']");
    private SelenideElement university = $("[name='university']");
    private SelenideElement yearOfStudy = $("[name='year']");
    private SelenideElement faculty = $("[name='faculty']");
    private SelenideElement studyField = $("[name='field_of_study']");
    private SelenideElement fieldOfInterest = $$("[class='internship-form-inline-checkbox']").first();
    private SelenideElement interestingTechnologies = $("[name='interested_in_technologies']");
    private SelenideElement technologiesWorkedWith = $("[name='experience_in_technologies']");
    private SelenideElement startMonth = $("[data-value='12']");
    private SelenideElement invalidStartMonth = $("[data-value='5']");
    private SelenideElement availableTime = $("[name='hours_per_week_available']");
    private SelenideElement agreementCheckBox = $(withText("Подтверждаю свое"));
    private SelenideElement submitButton = $(byText("Отправить заявку на стажировку"));
    private SelenideElement failedMessage = $(byText("Пожалуйста, заполните все обязательные поля"));

    public void agreeWithCookies () {
        cookieButton.click();
    }

    public void fillingValidData() {
        lastName.click();
        lastName.setValue(DataHelper.randomLastName).pressTab();
        firstName.setValue(DataHelper.randomFirstName).pressTab();
        middleName.setValue(DataHelper.randomMiddleName);
        phone.click();
        phone.setValue(DataHelper.phoneNumber).pressTab();
        email.setValue(DataHelper.randomEmail).pressTab();
        university.setValue(DataHelper.universityName);
        faculty.click();
        faculty.setValue(DataHelper.facultyName).pressTab();
        studyField.setValue(DataHelper.studyFieldName);
        fieldOfInterest.click();
        interestingTechnologies.click();
        interestingTechnologies.setValue(DataHelper.interestingTechnologiesList).pressTab();
        technologiesWorkedWith.setValue(DataHelper.technologiesWorkedWith).pressTab();
        startMonth.click();
        availableTime.click();
        availableTime.setValue(DataHelper.availableTimeHours);
    }

    public void markCheckBoxes () {
        agreementCheckBox.click();
        switchTo().frame($x("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]"));
        $("div.rc-anchor-content").click();
        switchTo().defaultContent();
    }

    public void setAgeOver16() {
        birthDate.click();
        birthDate.setValue(DataHelper.grownUpBirthDate);
    }

    public void setAgeUnder16() {
        birthDate.click();
        birthDate.setValue(DataHelper.minorBirthDate);
    }

    public void stillStudying() {
        yearOfStudy.click();
        yearOfStudy.setValue(String.valueOf(DataHelper.randomYearOfStudy));
    }

    public void graduatingFromUniversity() {
        yearOfStudy.click();
        yearOfStudy.setValue("-");
    }

    public ConfirmationPage sendForm() {
        submitButton.click();
        return new ConfirmationPage();
    }

    public void getNegativeMessage() {
        failedMessage.shouldBe(visible);
    }

    public void fillingInvalidData() {
        lastName.click();
        lastName.setValue(DataHelper.randomNumber).pressTab();
        firstName.setValue(DataHelper.randomNumber).pressTab();
        middleName.setValue(DataHelper.randomNumber).pressTab();
        birthDate.setValue(DataHelper.randomText).pressTab();
        phone.setValue(DataHelper.randomText).pressTab();
        email.setValue(DataHelper.randomNumber).pressTab();
        university.setValue(DataHelper.randomNumber).pressTab();
        yearOfStudy.setValue(DataHelper.randomSymbolsSet).pressTab();
        faculty.setValue(DataHelper.randomSymbolsSet).pressTab();
        studyField.setValue(DataHelper.randomSymbolsSet);
        fieldOfInterest.click();
        interestingTechnologies.click();
        interestingTechnologies.setValue(DataHelper.randomSymbolsSet).pressTab();
        technologiesWorkedWith.setValue(DataHelper.randomSymbolsSet).pressTab();
        invalidStartMonth.click();
        availableTime.click();
        availableTime.setValue(DataHelper.randomText);
    }

    public void fillingSpaces() {
        lastName.click();
        lastName.sendKeys(Keys.SPACE, TAB);
        firstName.sendKeys(Keys.SPACE, TAB);
        middleName.sendKeys(Keys.SPACE, TAB);
        birthDate.sendKeys(Keys.SPACE, TAB);
        phone.sendKeys(Keys.SPACE, TAB);
        email.sendKeys(Keys.SPACE, TAB);
        university.sendKeys(Keys.SPACE, TAB);
        yearOfStudy.sendKeys(Keys.SPACE, TAB);
        faculty.sendKeys(Keys.SPACE, TAB);
        studyField.sendKeys(Keys.SPACE);
        fieldOfInterest.click();
        interestingTechnologies.click();
        interestingTechnologies.sendKeys(Keys.SPACE, TAB);
        technologiesWorkedWith.sendKeys(Keys.SPACE, TAB);
        startMonth.click();
        availableTime.click();
        availableTime.sendKeys(Keys.SPACE);
    }
}