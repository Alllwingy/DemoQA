package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import web_07_DemoQA.manager.HelperStudent;
import web_07_DemoQA.manager.models.StudentDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web_07_DemoQA.manager.models.StudentDTOLombok;

public class StudentRegistrationFormTests extends TestBase implements HelperStudent {

    @BeforeMethod
    public void precondition() {

        selectForm();
        selectPracticeForm();
    }

    @Test
    public void studentRegistrationFormPositiveTest() {

        StudentDTO student = new StudentDTO("Bilbo", "Baggins",
                "baggins@mail.com", "MAIL", "1234567890",
                "22 Sep 2020", "Maths,Physics",
                "Sports,Music", "London street",
                "NCR", "Delhi");

        StudentDTOLombok studentDTOLombok = StudentDTOLombok.builder()
                .firstName("Bilbo")
                .lastName("Baggins")
                .email("baggins@mail.com")
                .gender("MAIL")
                .mobile("1234567890")
                .dateOfBirth("22 Sep 2020")
                .subjects("Maths,Physics")
                .hobbies("Sports,Music")
                .address("London street")
                .state("NCR")
                .city("Delhi")
                .build();

        fillStudentFormLombok(studentDTOLombok);
        pause(3);
        Assert.assertTrue(isElementPresent_Thanks_for_submitting());

    }

    @AfterTest
    public void afterMethod() {

//        clickButtonSubmitJS();
        clickButtonCloseByRectangle();
    }
}
