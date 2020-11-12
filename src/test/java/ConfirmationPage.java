import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class ConfirmationPage {
    private SelenideElement successfullySentMessage = $(withText("Ваша заявка на стажировку отправлена"));
    private SelenideElement returnLink = $(byText("Назад на страницу о стажировке"));

    public void formSuccessfullySent() {
        successfullySentMessage.shouldBe(visible);
        returnLink.shouldBe(visible);
    }
}
