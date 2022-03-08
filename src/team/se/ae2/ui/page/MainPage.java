package team.se.ae2.ui.page;

import team.se.ae2.DataCollection;
import team.se.ae2.model.User;
import team.se.ae2.ui.IPermissionControl;
import team.se.ae2.ui.MenuFuncs;

public class MainPage extends BasePage {
    protected DataCollection dc = DataCollection.getInstance();

    @Override
    public void resolve(String input) {
    }

    @Override
    public String getMenuItemDescription() {
        return "Well, it's the main page, maybe the description is not needed";
    }

    @Override
    public void init() {
        LoginPage loginPage = new LoginPage();

        ui.setContentText("Welcome to the system, just play around and enjoy your time here!");

        this.menuItems.add(MenuFuncs.ExitProgramMenuFunc.getInstance());

        if (dc.getLoginUser() == null) this.menuItems.add(loginPage);
        if (dc.getLoginUser() != null) this.menuItems.add(MenuFuncs.LogoutMenuFunc.getInstance());
    }
}
