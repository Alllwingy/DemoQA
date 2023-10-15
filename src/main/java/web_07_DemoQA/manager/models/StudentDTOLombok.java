package web_07_DemoQA.manager.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Setter
@Getter

public class StudentDTOLombok {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobile;
    private String dateOfBirth;
    private String subjects;
    private String hobbies;
    private String address;
    private String state;
    private String city;
}
