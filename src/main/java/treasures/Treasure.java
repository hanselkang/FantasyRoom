package treasures;

public abstract class Treasure {
    private String name;

    public Treasure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
