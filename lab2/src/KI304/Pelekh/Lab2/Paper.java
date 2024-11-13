package KI304.Pelekh.Lab2;


public class Paper {
    private int sheets;

    public Paper(int sheets) {
        this.sheets = sheets;
    }

    public int getSheets() {
        return sheets;
    }

    public void addSheets(int amount) {
        this.sheets += amount;
    }

    public boolean useSheets(int amount) {
        if (amount <= sheets) {
            sheets -= amount;
            return true;
        }
        return false;
    }
}
