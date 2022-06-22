package players;

import items.HealingPotion;
import items.ManaPotion;
import org.junit.Before;
import org.junit.Test;
import treasures.Gold;
import treasures.Jewel;
import weapons.Axe;
import weapons.Club;
import weapons.Sword;

import static org.junit.Assert.*;

public class BarbarianTest {

    Barbarian barbarian1;
    Sword sword;
    Axe axe;
    Club club;

    Gold gold;
    Jewel jewel;
    HealingPotion healingPotion;
    ManaPotion manaPotion;

    @Before
    public void before(){
        sword = new Sword("Sword",20);
        axe = new Axe("Axe",25);
        club = new Club("Club",15);
        healingPotion = new HealingPotion("HP");
        manaPotion = new ManaPotion("MP");
        gold = new Gold("Gold");
        jewel = new Jewel("Diamond");
        barbarian1 = new Barbarian("Conan",50,100,200, sword);
    }

    @Test
    public void hasName(){
        assertEquals("Conan", barbarian1.getName());
    }

    @Test
    public void hasMana(){
        assertEquals(50, barbarian1.getMana());
    }
    @Test
    public void hasStamina(){
        assertEquals(100, barbarian1.getStamina());
    }
    @Test
    public void hasHealth(){
        assertEquals(200, barbarian1.getHealth());
    }

    @Test
    public void hasActiveWeapon(){
        assertEquals(sword,barbarian1.getActiveWeapon());
    }

    @Test
    public void canAddWeaponList(){
        barbarian1.addWeapons(axe);
        barbarian1.addWeapons(club);
        assertEquals(2, barbarian1.getWeapons().size());
    }

    @Test
    public void canAddItemList(){
        barbarian1.addItems(healingPotion);
        barbarian1.addItems(manaPotion);
        assertEquals(2,barbarian1.getItems().size());
    }

    @Test
    public void canAddTreasureList(){
        barbarian1.addTreasures(gold);
        barbarian1.addTreasures(jewel);
        assertEquals(2,barbarian1.getTreasures().size());
    }



}