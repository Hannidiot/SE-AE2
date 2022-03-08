package team.se.ae2.ui.page;

import team.se.ae2.ui.CommandLineUi;
import team.se.ae2.ui.IInputResolver;
import team.se.ae2.ui.IMenuItem;
import team.se.ae2.ui.IMenuPage;

import java.util.ArrayList;

public abstract class BasePage implements IMenuPage, IMenuItem {
    protected ArrayList<IMenuItem> menuItems = new ArrayList<>();
    protected CommandLineUi ui;
    protected boolean isReady = false;

    @Override
    public void onSelectMenuItem(CommandLineUi ui) {
        ui.switchTo(this);
    }

    @Override
    public ArrayList<IMenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public void registerOnUiController(CommandLineUi ui) {
        this.ui = ui;
        if (!isReady) {
            init();
            isReady = true;
        }
    }

    public abstract void init();
}
