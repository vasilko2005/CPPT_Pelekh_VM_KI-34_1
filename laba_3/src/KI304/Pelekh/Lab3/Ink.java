
package KI304.Pelekh.Lab3;


public class Ink {
    private int level; // від 0 до 100

    public Ink(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void refill() {
        this.level = 100; // Заправка до 100%
    }

    public boolean useInk(int amount) {
        if (level >= amount) {
            level -= amount;
            return true;
        }
        return false;
    }
}