package tests;

import web_07_DemoQA.manager.HelperStudent;
import web_07_DemoQA.manager.models.StudentDTO;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
                "22 September 2020", "Mathematics",
                "Sport", "London street",
                "USA", "London");

        fillStudentForm(student);
        pause(3);
    }
}
