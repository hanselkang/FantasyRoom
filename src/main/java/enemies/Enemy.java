package enemies;

import players.Player;
import weapons.Weapon;

public abstract class Enemy {
    private String name;
    private int health;
    private Weapon weapon;

    public Enemy(String name, int health,Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attackPlayer(Player player){
        int playerHealth = player.getHealth();
        playerHealth -= this.getWeapon().getDamage();
        player.setHealth(playerHealth);
    }
}
