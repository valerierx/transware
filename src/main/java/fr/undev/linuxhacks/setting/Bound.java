package fr.undev.linuxhacks.setting;

public class Bound {
    private String min;
    private String max;

    public Bound(String min, String max) {
        this.min = min;
        this.max = max;
    }

    public String getMin() {
        return this.min;
    }

    public String getMax() {
        return this.max;
    }
}
