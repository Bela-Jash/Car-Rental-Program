package screen_managers;

import screens.user_screens.*;

import static java.lang.System.exit;

public class UserScreenManagerImplementer implements UserScreenManager {
    private final AccountScreen accountScreen;
    private final AllCarsScreen allCarsScreen;
    private final BookCarScreen bookCarScreen;
    private final CarBrandScreen carBrandScreen;
    private final CarFilterScreen carFilterScreen;
    private final CarTypeScreen carTypeScreen;
    private final CarYearScreen carYearScreen;
    private final ChangeEmailScreen changeEmailScreen;
    private final ChangeNameScreen changeNameScreen;
    private final ChangePasswordScreen changePasswordScreen;
    private final ChangePhoneNumberScreen changePhoneNumberScreen;
    private final DeleteAccountScreen deleteAccountScreen;
    private final FaqScreen faqScreen;
    private final LoginScreen loginScreen;
    private final LogoutScreen logoutScreen;
    private final RentedCarsScreen rentedCarsScreen;
    private final SearchCarScreen searchCarScreen;
    private final SignupScreen signupScreen;
    private final UserScreen userScreen;
    private final WelcomeScreen welcomeScreen;

    public UserScreenManagerImplementer() {
        accountScreen = new AccountScreen(this);
        allCarsScreen = new AllCarsScreen(this);
        bookCarScreen = new BookCarScreen(this);
        carBrandScreen = new CarBrandScreen(this);
        carFilterScreen = new CarFilterScreen(this);
        carTypeScreen = new CarTypeScreen(this);
        carYearScreen = new CarYearScreen(this);
        changeEmailScreen = new ChangeEmailScreen(this);
        changeNameScreen = new ChangeNameScreen(this);
        changePasswordScreen = new ChangePasswordScreen(this);
        changePhoneNumberScreen = new ChangePhoneNumberScreen(this);
        deleteAccountScreen = new DeleteAccountScreen(this);
        faqScreen = new FaqScreen(this);
        loginScreen = new LoginScreen(this);
        logoutScreen = new LogoutScreen(this);
        rentedCarsScreen = new RentedCarsScreen(this);
        searchCarScreen = new SearchCarScreen(this);
        signupScreen = new SignupScreen(this);
        userScreen = new UserScreen(this);
        welcomeScreen = new WelcomeScreen(this);
    }
    @Override
    public void switchScreen(String screenName) {
        switch (screenName) {
            case "AccountScreen": accountScreen.display(); break;
            case "AllCarsScreen": allCarsScreen.display(); break;
            case "BookCarScreen": bookCarScreen.display(); break;
            case "CarBrandScreen": carBrandScreen.display(); break;
            case "CarFilterScreen": carFilterScreen.display(); break;
            case "CarTypeScreen": carTypeScreen.display(); break;
            case "CarYearScreen": carYearScreen.display(); break;
            case "ChangeEmailScreen": changeEmailScreen.display(); break;
            case "ChangeNameScreen": changeNameScreen.display(); break;
            case "ChangePasswordScreen": changePasswordScreen.display(); break;
            case "ChangePhoneNumberScreen": changePhoneNumberScreen.display(); break;
            case "DeleteAccountScreen": deleteAccountScreen.display(); break;
            case "FaqScreen": faqScreen.display(); break;
            case "LoginScreen": loginScreen.display(); break;
            case "LogoutScreen": logoutScreen.display(); break;
            case "RentedCarsScreen": rentedCarsScreen.display(); break;
            case "SearchCarScreen": searchCarScreen.display(); break;
            case "SignupScreen": signupScreen.display(); break;
            case "UserScreen": userScreen.display(); break;
            case "WelcomeScreen": welcomeScreen.display(); break;
            default:
                System.out.println("Invalid screen name."); exit(1);
        }
    }
}
