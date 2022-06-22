package rooms;

public enum RoomLevel {
    LEVEL1(1),
    LEVEL2(2),
    LEVEL3(3),
    LEVEL4(4);

    private final int level;

    RoomLevel(int level) {
        this.level = level;
    }
}
