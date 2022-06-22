package players;

import rooms.Room;
import weapons.Weapon;

public class Barbarian extends Player {
    public Barbarian(String name, int mana, int stamina, int health, Weapon activeWeapon, Room currentRoom, boolean finish) {
        super(name, mana, stamina, health, activeWeapon, currentRoom, finish);
    }



}
