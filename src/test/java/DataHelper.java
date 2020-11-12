import com.github.javafaker.Faker;
import java.util.Locale;

public class DataHelper {
    static Faker faker = new Faker(new Locale("ru"));
    public static String randomLastName = faker.name().lastName();
    public static String randomFirstName = faker.name().firstName();
    public static String randomMiddleName = faker.name().firstName();
    public static String grownUpBirthDate = "02.01.1990";
    public static String minorBirthDate = "11.11.2010";
    public static String phoneNumber = "+7 (999) 123-45-67";
    public static String randomEmail = faker.internet().emailAddress();
    public static String universityName = "СПбГУАП";
    public static int randomYearOfStudy = (int) (1 + Math.random() * 6);
    public static String facultyName = "Институт информационных систем и защиты информации";
    public static String studyFieldName = "Информационные системы и технологии в бизнесе";
    public static String interestingTechnologiesList = "Linux, TestRail и многое другое";
    public static String technologiesWorkedWith = "Windows, Java и многое другое";
    public static String availableTimeHours = "40";
    public static String randomNumber = String.valueOf(faker.number().randomNumber());
    public static String randomText = faker.matz().quote();
    public static String randomSymbolsSet = ",</!@&().";
}