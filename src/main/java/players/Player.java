package players;

import items.Item;
import treasures.Treasure;
import weapons.Weapon;

import java.util.ArrayList;

public abstract class Player {
    private String name;
    private int mana;
    private int stamina;
    private int health;
    private Weapon activeWeapon;
    private ArrayList<Weapon> weapons;
    private ArrayList<Treasure> treasures;
    private ArrayList<Item> items;


    public Player(String name, int mana, int stamina, int health, Weapon activeWeapon) {
        this.name = name;
        this.mana = mana;
        this.stamina = stamina;
        this.health = health;
        this.activeWeapon = activeWeapon;
        weapons = new ArrayList<Weapon>();
        treasures = new ArrayList<Treasure>();
        items = new ArrayList<Item>();

    }

    public String getName() {
        return name;
    }

    public int getMana() {
        return mana;
    }

    public int getStamina() {
        return stamina;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public ArrayList<Item> getItems() {
        return items;
    }


}
