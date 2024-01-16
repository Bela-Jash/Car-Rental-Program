package screen_managers;

import screens.owner_screens.*;

public class OwnerScreenManagerImplementer implements OwnerScreenManager {
    private final AccountScreen accountScreen;
    private final AddCarScreen addCarScreen;
    private final AllAdminsScreen allAdminsScreen;
    private final AllCarsScreen allCarsScreen;
    private final AllRentedCarsScreen allRentedCarsScreen;
    private final AllUsersScreen allUsersScreen;
    private final ChangeBaseRateScreen changeBaseRateScreen;
    private final ChangeBrandScreen changeBrandScreen;
    private final ChangeColorScreen changeColorScreen;
    private final ChangeEmailScreen changeEmailScreen;
    private final ChangeModelScreen changeModelScreen;
    private final ChangeNameScreen changeNameScreen;
    private final ChangePasswordScreen changePasswordScreen;
    private final ChangePhoneNumberScreen changePhoneNumberScreen;
    private final ChangeQuantityScreen changeQuantityScreen;
    private final ChangeTypeScreen changeTypeScreen;
    private final ChangeYearScreen changeYearScreen;
    private final CompanyNameScreen companyNameScreen;
    private final CreateAdminScreen createAdminScreen;
    private final DeleteAdminScreen deleteAdminScreen;
    private final DeleteCarScreen deleteCarScreen;
    private final DeleteUserScreen deleteUserScreen;
    private final ManageAdminsScreen manageAdminsScreen;
    private final ManageCarsScreen manageCarsScreen;
    private final ManageUsersScreen manageUsersScreen;
    private final ModifyCarScreen modifyCarScreen;
    private final OwnerScreen ownerScreen;
    private final SearchAdminScreen searchAdminScreen;
    private final SearchCarScreen searchCarScreen;
    private final SearchUserScreen searchUserScreen;
    private final WelcomeScreen welcomeScreen;

    public OwnerScreenManagerImplementer() {
        accountScreen = new AccountScreen(this);
        addCarScreen = new AddCarScreen(this);
        allAdminsScreen = new AllAdminsScreen(this);
        allCarsScreen = new AllCarsScreen(this);
        allRentedCarsScreen = new AllRentedCarsScreen(this);
        allUsersScreen = new AllUsersScreen(this);
        changeBaseRateScreen = new ChangeBaseRateScreen(this);
        changeBrandScreen = new ChangeBrandScreen(this);
        changeColorScreen = new ChangeColorScreen(this);
        changeEmailScreen = new ChangeEmailScreen(this);
        changeModelScreen = new ChangeModelScreen(this);
        changeNameScreen = new ChangeNameScreen(this);
        changePasswordScreen = new ChangePasswordScreen(this);
        changePhoneNumberScreen = new ChangePhoneNumberScreen(this);
        changeQuantityScreen = new ChangeQuantityScreen(this);
        changeTypeScreen = new ChangeTypeScreen(this);
        changeYearScreen = new ChangeYearScreen(this);
        companyNameScreen = new CompanyNameScreen(this);
        createAdminScreen = new CreateAdminScreen(this);
        deleteAdminScreen = new DeleteAdminScreen(this);
        deleteCarScreen = new DeleteCarScreen(this);
        deleteUserScreen = new DeleteUserScreen(this);
        manageAdminsScreen = new ManageAdminsScreen(this);
        manageCarsScreen = new ManageCarsScreen(this);
        manageUsersScreen = new ManageUsersScreen(this);
        modifyCarScreen = new ModifyCarScreen(this);
        ownerScreen = new OwnerScreen(this);
        searchAdminScreen = new SearchAdminScreen(this);
        searchCarScreen = new SearchCarScreen(this);
        searchUserScreen = new SearchUserScreen(this);
        welcomeScreen = new WelcomeScreen(this);
    }
    public void switchScreen(String screenName) {
        switch (screenName) {
            case "AccountScreen": accountScreen.display(); break;
            case "AddCarScreen": addCarScreen.display(); break;
            case "AllAdminsScreen": allAdminsScreen.display(); break;
            case "AllCarsScreen": allCarsScreen.display(); break;
            case "AllRentedCarsScreen": allRentedCarsScreen.display(); break;
            case "AllUsersScreen": allUsersScreen.display(); break;
            case "ChangeBaseRateScreen": changeBaseRateScreen.display(); break;
            case "ChangeBrandScreen": changeBrandScreen.display(); break;
            case "ChangeColorScreen": changeColorScreen.display(); break;
            case "ChangeEmailScreen": changeEmailScreen.display(); break;
            case "ChangeModelScreen": changeModelScreen.display(); break;
            case "ChangeNameScreen": changeNameScreen.display(); break;
            case "ChangePasswordScreen": changePasswordScreen.display(); break;
            case "ChangePhoneNumberScreen": changePhoneNumberScreen.display(); break;
            case "ChangeQuantityScreen": changeQuantityScreen.display(); break;
            case "ChangeTypeScreen": changeTypeScreen.display(); break;
            case "ChangeYearScreen": changeYearScreen.display(); break;
            case "CompanyNameScreen": companyNameScreen.display(); break;
            case "CreateAdminScreen": createAdminScreen.display(); break;
            case "DeleteAdminScreen": deleteAdminScreen.display(); break;
            case "DeleteCarScreen": deleteCarScreen.display(); break;
            case "DeleteUserScreen": deleteUserScreen.display(); break;
            case "ManageAdminsScreen": manageAdminsScreen.display(); break;
            case "ManageCarsScreen": manageCarsScreen.display(); break;
            case "ManageUsersScreen": manageUsersScreen.display(); break;
            case "ModifyCarScreen": modifyCarScreen.display(); break;
            case "OwnerScreen": ownerScreen.display(); break;
            case "SearchAdminScreen": searchAdminScreen.display(); break;
            case "SearchCarScreen": searchCarScreen.display(); break;
            case "SearchUserScreen": searchUserScreen.display(); break;
            case "WelcomeScreen": welcomeScreen.display(); break;
        }
    }
}
