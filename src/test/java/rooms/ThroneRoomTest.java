package rooms;

import enemies.Enemy;
import enemies.Orc;
import enemies.Troll;
import items.HealingPotion;
import items.ManaPotion;
import org.junit.Before;
import org.junit.Test;
import players.Barbarian;
import treasures.Gold;
import treasures.Jewel;
import treasures.Treasure;
import weapons.Axe;
import weapons.Club;
import weapons.Sword;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static rooms.RoomLevel.LEVEL1;

public class ThroneRoomTest {
    Barbarian barbarian1;
    Sword sword;
    Axe axe;
    Club club;

    Gold gold;
    Jewel jewel;
    HealingPotion healingPotion;
    ManaPotion manaPotion;

    Troll troll1;
    Troll troll2;
    Troll troll3;
    Orc orc;
    ArrayList<Enemy> enemies;
    ArrayList<Treasure> treasures;

    ThroneRoom throneRoom;



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
        troll1 = new Troll("Andrew",20,club);
        troll2 = new Troll("Emma", 15,sword);
        troll3 = new Troll("Derek", 25,axe);
        orc = new Orc("Cam",30,sword);


        enemies = new ArrayList<>();
        enemies.add(troll1);
        enemies.add(troll2);
        enemies.add(troll3);
        enemies.add(orc);
        treasures = new ArrayList<>();
        treasures.add(gold);
        treasures.add(jewel);

        throneRoom = new ThroneRoom("Throne Room",false,enemies,treasures, LEVEL1);
    }

    @Test
    public void isComplete(){
        assertEquals(false, throneRoom.isComplete());
    }

    @Test
    public void hasName(){
        assertEquals("Throne Room", throneRoom.getName());
    }

    @Test
    public void hasEnemies(){
        assertEquals(4,throneRoom.getEnemies().size());
    }

    @Test
    public void hasTreasures(){
        assertEquals(2,throneRoom.getTreasures().size());
    }

    @Test
    public void hasLevel(){
        assertEquals(LEVEL1,throneRoom.getRoomLevel());
    }
}