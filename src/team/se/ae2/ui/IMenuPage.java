package team.se.ae2.ui;

import java.util.ArrayList;

public interface IMenuPage extends IInputResolver {
    ArrayList<IMenuItem> getMenuItems();
    void registerOnUiController(CommandLineUi ui);
}
