package team.se.ae2.ui.page;

import team.se.ae2.ui.CommandLineUi;
import team.se.ae2.ui.IMenuItem;
import team.se.ae2.ui.IMenuPage;

import java.util.ArrayList;

public abstract class BasePage implements IMenuPage, IMenuItem {
    protected ArrayList<IMenuItem> menuItems = new ArrayList<>();
    protected CommandLineUi ui;
    protected boolean isReady = false;

    protected IMenuPage parent;

    public BasePage() {
        this.parent = null;
    }

    public BasePage(IMenuPage parent) {
        this.parent = parent;
    }

    @Override
    public void onSelectMenuItem(CommandLineUi ui) {
        ui.switchTo(this);
    }

    @Override
    public ArrayList<IMenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public void beforePageDisplayed(CommandLineUi ui) {
        this.ui = ui;
        if (!isReady) {
            init();
            isReady = true;
        }
        this.ui.setContentText("");
    }

    public IMenuPage getParent() {
        return parent;
    }

    public abstract void init();
}
