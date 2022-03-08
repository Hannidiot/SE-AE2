package team.se.ae2.ui;

import team.se.ae2.DataCollection;
import team.se.ae2.model.User;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

/*
    Ui is composed of HEADER_BOX, CONTENT_BOX, MENU_BOX and INPUT_BOX.
    Since all pages share same ui element, use a centralized class to control how the ui will behave.
 */
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

    /*
        switch to the target page
     */
    public void switchTo(IMenuPage page) {
        this.current_page = page;
        page.registerOnUiController(this);
        resolveMenu();
    }

    /*
        the main loop that the ui runs

        every time it receives some input, first the internal resolveNavigation function will resolve the input and
        figure out whether it targets to another page

        after it is resolved by internal resolver, the page resolver will get the input and execute
        customized logic defined by the page.
     */
    public void run() {
        String input;
        while (isRunning) {
            show();
            input = inputBox.getInput(defaultHint);
            if (resolveNavigation(input)) continue;
            current_page.resolve(input);
        }
    }

    /*
        terminate the ui
     */
    public void exit() {
        this.isRunning = false;
        inputBox.close();
    }

    /*
        resolve how the menu is shown

        generate a dictionary for resolveNavigation() function to use
     */
    protected void resolveMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        num2MenuMap = new Hashtable<>();
        ArrayList<IMenuItem> menuItems = this.current_page.getMenuItems();

        for (int i = 0; i < menuItems.size(); i++) {

            // check if the user has the permission to access the page
            if (dc.getLoginUser() != null && menuItems.get(i) instanceof IPermissionControl) {
                boolean flag = false;
                User.Role[] permittedRoles = ((IPermissionControl) menuItems.get(i)).getPermittedRoles();
                for (User.Role role :
                        permittedRoles) {
                    if (role == dc.getLoginUser().getRole()) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) continue;
            }

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

    /*
        intend to clear the terminal, however the command does not work under MacOS

        so use 3 new-line as a dirty implementation :(
     */
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
