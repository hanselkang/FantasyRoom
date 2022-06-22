package rooms;

import enemies.Enemy;
import treasures.Treasure;

import java.util.ArrayList;

public abstract class Room {
    private String name;
    private boolean complete;
    private ArrayList<Enemy> enemies;
    private ArrayList<Treasure> treasures;
    private RoomLevel roomLevel;

    public Room(String name, boolean complete, ArrayList<Enemy> enemies, ArrayList<Treasure> treasures, RoomLevel roomLevel) {
        this.name = name;
        this.complete = complete;
        this.enemies = enemies;
        this.treasures = treasures;
        this.roomLevel = roomLevel;
    }

    public String getName() {
        return name;
    }

    public boolean isComplete() {
        return complete;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public RoomLevel getRoomLevel() {
        return roomLevel;
    }


}
