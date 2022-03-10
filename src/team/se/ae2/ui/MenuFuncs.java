package team.se.ae2.ui;

import team.se.ae2.controller.LoginController;

public class MenuFuncs {
    public static class Back2RootMenuFunc implements IMenuItem {
        private final static Back2RootMenuFunc instance = new Back2RootMenuFunc();
        private Back2RootMenuFunc() {}

        public static Back2RootMenuFunc getInstance() {
            return instance;
        }

        @Override
        public void onSelectMenuItem(CommandLineUi ui) {
            ui.switchTo(ui.getRoot());
        }

        @Override
        public String getMenuItemDescription() {
            return "Back to homepage";
        }
    }

    public static class ExitProgramMenuFunc implements IMenuItem {
        private static final ExitProgramMenuFunc instance = new ExitProgramMenuFunc();
        private ExitProgramMenuFunc() {}

        public static ExitProgramMenuFunc getInstance() {
            return instance;
        }

        @Override
        public void onSelectMenuItem(CommandLineUi ui) {
            ui.exit();
        }

        @Override
        public String getMenuItemDescription() {
            return "Exit Program";
        }
    }

    public static class LogoutMenuFunc implements IMenuItem {
        private static final LogoutMenuFunc instance = new LogoutMenuFunc();
        private LogoutMenuFunc() {}

        private final LoginController loginController = new LoginController();

        public static LogoutMenuFunc getInstance() {
            return instance;
        }

        @Override
        public void onSelectMenuItem(CommandLineUi ui) {
            loginController.logout();
            ui.switchTo(ui.getRoot());
        }

        @Override
        public String getMenuItemDescription() {
            return "Logout";
        }
    }

    public static class Back2ParentFunc implements IMenuItem {
        private static final Back2ParentFunc instance = new Back2ParentFunc();
        private Back2ParentFunc() {}

        public static Back2ParentFunc getInstance() {
            return instance;
        }

        @Override
        public void onSelectMenuItem(CommandLineUi ui) {
            if (ui.current_page.getParent() == null) {
                ui.setContentText("No last page recorded");
            }
            else {
                ui.switchTo(ui.current_page.getParent());
            }
        }

        @Override
        public String getMenuItemDescription() {
            return "Back To Last Page";
        }
    }
}
