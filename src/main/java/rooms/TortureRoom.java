package rooms;

import enemies.Enemy;
import treasures.Treasure;

import java.util.ArrayList;

public class TortureRoom extends Room{
    public TortureRoom(String name, boolean complete, ArrayList<Enemy> enemies, ArrayList<Treasure> treasures, RoomLevel roomLevel) {
        super(name, complete, enemies, treasures, roomLevel);
    }
}
