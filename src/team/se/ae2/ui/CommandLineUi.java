package team.se.ae2.ui;

import team.se.ae2.DataCollection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class CommandLineUi {
    protected UiDisplayElement header, content, menu;
    protected UiInputElement inputBox;
    protected Dictionary<String, IMenuItem> num2MenuMap = new Hashtable<>();
    protected IMenuPage current_page;
    protected IMenuPage root;
    protected DataCollection dc = DataCollection.getInstance();

    protected boolean isRunning = true;
    protected String defaultHint = "";

    public CommandLineUi(IMenuPage root) {
        this.root = root;
        header = new UiDisplayElement();
        content = new UiDisplayElement();
        menu = new UiDisplayElement();
        inputBox = new UiInputElement();

        switchTo(root);
    }

    public void switchTo(IMenuPage page) {
        this.current_page = page;
        page.registerOnUiController(this);
        resolveMenu();
    }

    public void run() {
        String input;
        while (isRunning) {
            show();
            input = inputBox.getInput(defaultHint);
            if (resolveNavigation(input)) continue;
            current_page.resolve(input);
        }
    }

    public void exit() {
        this.isRunning = false;
        inputBox.close();
    }

    protected void resolveMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        num2MenuMap = new Hashtable<>();
        ArrayList<IMenuItem> menuItems = this.current_page.getMenuItems();
        for (int i = 0; i < menuItems.size(); i++) {
            menuBuilder.append(i)
                    .append(". ")
                    .append(menuItems.get(i).getMenuItemDescription());
            if (menuItems.size() != i + 1) menuBuilder.append("\n");

            num2MenuMap.put(String.valueOf(i), menuItems.get(i));
        }
        this.menu.setText(menuBuilder.toString());
    }

    protected boolean resolveNavigation(String input) {
        IMenuItem menuItem = num2MenuMap.get(input.strip());
        if (menuItem == null) return false;

        menuItem.onSelectMenuItem(this);
        return true;
    }

    public void show() {
        refresh();
        printHeader();
        this.content.print();
        this.menu.print();
    }

    protected void printHeader() {
        if (dc.getLoginUser() == null) {
            this.header.setText("Hello passenger~");
        }
        else {
            this.header.setText("Hello " + dc.getLoginUser().getUsername() + ", please have a sit and enjoy your time");
        }
        this.header.print();
    }

    protected void refresh() {
        System.out.println();
        System.out.println();
        System.out.println();
//        try {
//            Runtime.getRuntime().exec("clear");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    // Getter and Setter
    public IMenuPage getRoot() {
        return this.root;
    }

    public String getInput(String hint) {
        return this.inputBox.getInput(hint);
    }

    public void setDefaultHint(String defaultHint) {
        this.defaultHint = defaultHint;
    }

    public void setContentText(String text) {
        this.content.setText(text);
    }
}
