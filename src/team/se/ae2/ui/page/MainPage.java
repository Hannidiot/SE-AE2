package team.se.ae2.ui.page;

import team.se.ae2.DataCollection;
import team.se.ae2.ui.CommandLineUi;
import team.se.ae2.ui.MenuFuncs;

import java.util.ArrayList;

public class MainPage extends BasePage {
    protected DataCollection dc = DataCollection.getInstance();
    protected LoginPage loginPage;
    protected CoursePage coursePage;
    protected TrainingPage trainingPage;
    protected EnrollPage infoEntryPage;

    @Override
    public void onSelectMenuItem(CommandLineUi ui) {
        super.onSelectMenuItem(ui);
    }

    @Override
    public void beforePageDisplayed(CommandLineUi ui) {
        super.beforePageDisplayed(ui);
        updateMenuItems();
    }

    @Override
    public void resolve(String input) {
    }

    @Override
    public String getMenuItemDescription() {
        return "Well, it's the main page, maybe the description is not needed";
    }

    @Override
    public void init() {
        loginPage = new LoginPage(this);
        coursePage = new CoursePage(this);
        trainingPage = new TrainingPage(this);
        infoEntryPage = new EnrollPage(this);


        ui.setContentText("Welcome to the system, just play around and enjoy your time here!");

        updateMenuItems();
    }

    private void updateMenuItems() {
        this.menuItems = new ArrayList<>();

        this.menuItems.add(coursePage);
        this.menuItems.add(trainingPage);
        this.menuItems.add(infoEntryPage);
        if (dc.getLoginUser() == null) this.menuItems.add(loginPage);
        else this.menuItems.add(MenuFuncs.LogoutMenuFunc.getInstance());
    }
}
