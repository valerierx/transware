package fr.undev.linuxhacks.setting;

// Hacky temporary string-based settings thingy made in 5 min pls replace asap
// TODO Create proper settings
public class Setting {
    private String name;
    private String value;
    private Bound bounds;

    public Setting(String name, String value, String min, String max) {
        this.name = name;
        this.value = value;
        this.bounds = new Bound(min, max);
    }

    public Setting(String name, String value, Bound bounds) {
        this.name = name;
        this.value = value;
        this.bounds = bounds;
    }

    public Setting(String name, String value) {
        this.name = name;
        this.value = value;
        this.bounds = null;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueAsString() {
        return this.value;
    }

    // Will return -1 if unable to parse number
    public int getValueAsInt() {
        try {
            return Integer.parseInt(this.value);
        } catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    public double getValueAsDouble() {
        try {
            return Double.parseDouble(this.value);
        } catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    public float getValueAsFloat() {
        try {
            return Float.parseFloat(this.value);
        } catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    public long getValueAsLong() {
        try {
            return Long.parseLong(this.value);
        } catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    // Unsafe
    public boolean getValueAsBooleanUnsafe() {
        return Boolean.parseBoolean(this.value);
    }

    public boolean hasBounds() {
        return this.bounds != null;
    }

    public Bound getBounds() {
        if (hasBounds()) return bounds;
        return null;
    }

    public int getMinAsInt() {
        if (hasBounds()) return Integer.parseInt(bounds.getMin());
        return -1;
    }

    public double getMinAsDouble() {
        if (hasBounds()) return Double.parseDouble(bounds.getMin());
        return -1;
    }
    public float getMinAsFloat() {
        if (hasBounds()) return Float.parseFloat(bounds.getMin());
        return -1;
    }
    public long getMinAsLong() {
        if (hasBounds()) return Long.parseLong(bounds.getMin());
        return -1;
    }

    public int getMaxAsInt() {
        if (hasBounds()) return Integer.parseInt(bounds.getMax());
        return -1;
    }

    public double getMaxAsDouble() {
        if (hasBounds()) return Double.parseDouble(bounds.getMax());
        return -1;
    }
    public float getMaxAsFloat() {
        if (hasBounds()) return Float.parseFloat(bounds.getMax());
        return -1;
    }
    public long getMaxAsLong() {
        if (hasBounds()) return Long.parseLong(bounds.getMax());
        return -1;
    }
}
