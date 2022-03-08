package team.se.ae2.ui;

import team.se.ae2.DataCollection;
import team.se.ae2.model.UiSetting;

public class UiDisplayElement extends UiBase {
    protected String text;

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text + "\n" + this.productDivLine();
    }

    public void print() {
        System.out.print(toString());
    }

    protected String productDivLine() {
        return "-".repeat(Math.max(0, UI_SETTING.getBoxWidth())) + "\n" ;
    }
}
