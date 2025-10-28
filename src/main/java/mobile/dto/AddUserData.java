package mobile.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
public class AddUserData {

    private final String userFirstName;
    private final String userLastName;
    private final String userEmail;
    private final String userPassword;
    private final String userPasswordConfirmation;

    public AddUserData(String userFirstName, String userLastName, String userEmail,
                       String userPassword, String userPasswordConfirmation) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPasswordConfirmation = userPasswordConfirmation;
    }

    public String getUserFirstName() {
        return userFirstName;
    }
    public String getUserLastName() {
        return userLastName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public String getUserPasswordConfirmation() {
        return userPasswordConfirmation;
    }

}
