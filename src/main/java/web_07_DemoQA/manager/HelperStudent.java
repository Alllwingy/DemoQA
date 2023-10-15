package web_07_DemoQA.manager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import web_07_DemoQA.manager.models.StudentDTO;
import web_07_DemoQA.manager.models.StudentDTOLombok;

public interface HelperStudent extends HelperBase {

    default void selectForm() {

        if (isElementPresent(By.id("adplus-anchor")))
            hideAds();
        if (isElementPresent(By.cssSelector("footer")))
            hideFooter();
        if (isElementPresent(By.id("close-fixedban")))
            hideDiv();
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }

    default void selectPracticeForm() {

        click(By.xpath("//span[text()='Practice Form']"));
    }

    default void fillStudentForm(StudentDTO student) {

        hideFooter();
        type(By.id("firstName"), student.getFirstName());
        type(By.id("lastName"), student.getLastName());
        type(By.id("userEmail"), student.getEmail());

        selectGender(student.getGender());
        type(By.id("userNumber"), student.getMobile());
//        type(By.id("dateOfBirthInput"), student.getDateOfBirth()); // clear() - doesn't work
        typeBirthday(student.getDateOfBirth());

        addSubject(student.getSubjects());

        selectHobby(student.getHobbies());

        loadPicture();

        type(By.id("currentAddress"), student.getAddress());

        typeDate(student.getState());
        typeCity(student.getCity());

        clickButtonSubmit();
    }

    default void fillStudentFormLombok(StudentDTOLombok student) {

        hideFooter();
        type(By.id("firstName"), student.getFirstName());
        type(By.id("lastName"), student.getLastName());
        type(By.id("userEmail"), student.getEmail());

        selectGender(student.getGender());
        type(By.id("userNumber"), student.getMobile());
//        type(By.id("dateOfBirthInput"), student.getDateOfBirth()); // clear() - doesn't work
        typeBirthday(student.getDateOfBirth());

        addSubject(student.getSubjects());

        selectHobby(student.getHobbies());

        loadPicture();

        type(By.id("currentAddress"), student.getAddress());

        typeDate(student.getState());
        typeCity(student.getCity());

        clickButtonSubmit();
    }

    default void clickButtonSubmit() {

        click(By.id("submit"));
    }

    default void clickButtonSubmitJS() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#closeLargeModal').click()");
    }

    default void typeCity(String city) {

        driver.findElement(By.id("react-select-4-input")).sendKeys(city);
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }

    default void typeDate(String state) {

        driver.findElement(By.id("react-select-3-input")).sendKeys(state);
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }

    default void loadPicture() {

        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\Alll.wingy\\Pictures\\Screenshots\\M4U_Logo.jpg");
    }

    default void selectHobby(String hobbies) {

        String[] hobbiesArray = hobbies.split(",");

        for (String element : hobbiesArray) {

            switch (element) {
                case "Sports":
                    click(By.xpath("//*[@for='hobbies-checkbox-1']"));
                    break;
                case "Reading":
                    click(By.xpath("//*[@for='hobbies-checkbox-2']"));
                    break;
                case "Music":
                    click(By.xpath("//*[@for='hobbies-checkbox-3']"));
                    break;
            }
        }
    }

    default void addSubject(String subjects) {

        String[] subjectsArray = subjects.split(",");

        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.click();

        for (String element : subjectsArray) {

            subject.sendKeys(element);
            subject.sendKeys(Keys.ENTER);
        }
    }

    default void typeBirthday(String birthday) {

        WebElement date = driver.findElement(By.id("dateOfBirthInput"));
        date.click();
        date.sendKeys(Keys.LEFT_CONTROL, "a");
        date.sendKeys(birthday);
        date.sendKeys(Keys.ENTER);
    }

    default void selectGender(String gender) {

        if (gender.equals("Male")) {

            click(By.xpath("//label[@for='gender-radio-1']"));

        } else if (gender.equals("Female")) {

            click(By.xpath("//label[@for='gender-radio-2']"));

        } else {

            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }

    default boolean isElementPresent_Thanks_for_submitting() {

        return isElementPresent(By.id("example-modal-sizes-title-lg"));
    }

    default void clickButtonCloseByRectangle() {

        WebElement element = driver.findElement(By.id("closeLargeModal"));
        Rectangle rectangle = element.getRect();

        int x = rectangle.getX();
        int y = rectangle.getY();
        int w = rectangle.getWidth();
        int h = rectangle.getHeight();

        System.out.println("x = " + x + " y = " + y + " w = " + w + " h = " + h);

        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform(); // click on the middle of the element
    }
}
