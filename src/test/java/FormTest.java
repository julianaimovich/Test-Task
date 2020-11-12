import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {

    @BeforeEach
    public void openSource() {
        open("https://www.dins.ru/?p=internship");
    }

    @Test
    @DisplayName("Form filled in with valid data should be sent")

    void formFilledInWithValidDataShouldBeSent() {
        val formPage = new FormPage();
        formPage.agreeWithCookies();
        formPage.fillingValidData();
        formPage.setAgeOver16();
        formPage.stillStudying();
        formPage.markCheckBoxes();
        val confirmationPage = formPage.sendForm();
        confirmationPage.formSuccessfullySent();
    }

    @Test
    @DisplayName("Sending form without marking check boxes should be failed")

    void sendingFormWithoutMarkingCheckBoxesShouldBeFailed() {
        val formPage = new FormPage();
        formPage.agreeWithCookies();
        formPage.fillingValidData();
        formPage.setAgeOver16();
        formPage.stillStudying();
        formPage.sendForm();
        formPage.getNegativeMessage();
    }

    @Test
    @DisplayName("Sending form filled in with invalid data should be failed")

    void sendingFormFilledInWithInvalidDataShouldBeFailed() {
        val formPage = new FormPage();
        formPage.agreeWithCookies();
        formPage.fillingInvalidData();
        formPage.markCheckBoxes();
        formPage.sendForm();
        formPage.getNegativeMessage();
    }

    @Test
    @DisplayName("Sending form filled in with spaces should be failed")

    void sendingFormFilledInWithSpacesShouldBeFailed() {
        val formPage = new FormPage();
        formPage.agreeWithCookies();
        formPage.fillingSpaces();
        formPage.markCheckBoxes();
        formPage.sendForm();
        formPage.getNegativeMessage();
    }

    @Test
    @DisplayName("Sending empty form should be failed")

    void sendingEmptyFormShouldBeFailed() {
        val formPage = new FormPage();
        formPage.agreeWithCookies();
        formPage.sendForm();
        formPage.getNegativeMessage();
    }
}