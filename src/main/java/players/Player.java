package players;

import enemies.Enemy;
import items.Item;
import rooms.Room;
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

    private ArrayList<Room> completedRooms;

    private ArrayList<Room> totalRooms;

    private Room currentRoom;

    private boolean finish;




    public Player(String name, int mana, int stamina, int health, Weapon activeWeapon, Room currentRoom, boolean finish) {
        this.name = name;
        this.mana = mana;
        this.stamina = stamina;
        this.health = health;
        this.activeWeapon = activeWeapon;
        weapons = new ArrayList<Weapon>();
        treasures = new ArrayList<Treasure>();
        items = new ArrayList<Item>();
        completedRooms = new ArrayList<>();
        this.currentRoom = currentRoom;
        this.totalRooms = new ArrayList<Room>();
        this.finish = false;


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

    public ArrayList<Room> getCompletedRooms() {
        return completedRooms;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setCompletedRooms(ArrayList<Room> completedRooms) {
        this.completedRooms = completedRooms;
    }

    public void addWeapons(Weapon weapons) {
        this.weapons.add(weapons);
    }

    public void addTreasures(Treasure treasures) {
        this.treasures.add(treasures);
    }
    public void pickTreasures(Treasure treasures, Room room) {
        this.treasures.add(treasures);
    }

    public void addItems(Item items) {
        this.items.add(items);
    }

    public void attackEnemy(Room room, Enemy enemy){

        int enemyHealth = enemy.getHealth();
        if (enemy.getHealth() > this.activeWeapon.getDamage()) {
            enemyHealth -= this.getActiveWeapon().getDamage();
            enemy.setHealth(enemyHealth);

        } else if (enemy.getHealth() <= this.activeWeapon.getDamage()){
            room.getEnemies().remove(enemy);
            if (room.getEnemies().size() == 0) {
                room.setComplete(true);
                if (this.completedRooms.size() == totalRooms.size() ) {
                    this.completeGame(true);
                }
            }
        }

    }

    private void completeGame(boolean finish) {
        this.finish = true;
    }

    public void pickTreasureFromRoom(Room room){
        if (room.getTreasures().size() > 1) {
            Treasure treasure = room.removeTreasure();
            this.treasures.add(treasure);
        } else {
            Treasure treasure = room.removeTreasure();
            this.treasures.add(treasure);
            this.completedRooms.add(room);
            room.setComplete(true);
        }
    }








}
