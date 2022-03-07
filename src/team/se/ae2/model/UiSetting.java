package team.se.ae2.model;

public class UiSetting {
    protected int boxWidth;

    public UiSetting() {}

    public int getBoxWidth() {
        return boxWidth;
    }

    public void setBoxWidth(int boxWidth) {
        this.boxWidth = boxWidth;
    }

    @Override
    public String toString() {
        return "boxWidth=" + boxWidth +
                "" ;
    }
}
