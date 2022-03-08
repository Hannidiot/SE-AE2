package team.se.ae2.ui.page;

import team.se.ae2.controller.LoginController;
import team.se.ae2.model.User;
import team.se.ae2.ui.IPermissionControl;
import team.se.ae2.ui.MenuFuncs;

public class LoginPage extends BasePage {
    protected LoginController loginController = new LoginController();
    protected String usernameHint = "Please Input username or return to main page";

    @Override
    public void resolve(String username) {
        String password = ui.getInput("Please input password");

        if (loginController.login(username, password)) ui.switchTo(ui.getRoot());
        else ui.setContentText("Login Failed\n\tincorrect username or password");
    }

    @Override
    public String getMenuItemDescription() {
        return "Login";
    }

    @Override
    public void init() {
        ui.setDefaultHint(usernameHint);
        this.menuItems.add(MenuFuncs.Back2RootMenuFunc.getInstance());
    }
}
