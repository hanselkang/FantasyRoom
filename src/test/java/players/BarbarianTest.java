package players;

import enemies.Enemy;
import enemies.Orc;
import enemies.Troll;
import items.HealingPotion;
import items.ManaPotion;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;
import rooms.ThroneRoom;
import rooms.TortureRoom;
import treasures.Gold;
import treasures.Jewel;
import treasures.Treasure;
import weapons.Axe;
import weapons.Club;
import weapons.Sword;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static rooms.RoomLevel.LEVEL1;
import static rooms.RoomLevel.LEVEL2;

public class BarbarianTest {

    Barbarian barbarian1;
    Sword sword;
    Axe axe;
    Club club;

    Gold gold;
    Jewel jewel;
    HealingPotion healingPotion;
    ManaPotion manaPotion;

    Troll troll;
    ThroneRoom throneRoom;
    TortureRoom tortureRoom;
    Troll troll1;
    Troll troll2;
    Troll troll3;
    Orc orc;
    ArrayList<Enemy> enemies1;
    ArrayList<Enemy> enemies2;
    ArrayList<Treasure> treasures1;
    ArrayList<Treasure> treasures2;
    ArrayList<Room> totalRoom;

    @Before
    public void before(){
        sword = new Sword("Sword",20);
        axe = new Axe("Axe",25);
        club = new Club("Club",15);
        healingPotion = new HealingPotion("HP");
        manaPotion = new ManaPotion("MP");
        gold = new Gold("Gold");
        jewel = new Jewel("Diamond");
        barbarian1 = new Barbarian("Conan",50,100,200, sword, throneRoom, false);
        troll = new Troll("Fiona",40,sword);


        troll1 = new Troll("Andrew",20,club);
        troll2 = new Troll("Emma", 15,sword);
        troll3 = new Troll("Derek", 25,axe);
        orc = new Orc("Cam",30,sword);


        enemies1 = new ArrayList<>();
        enemies1.add(troll1);

        enemies2 = new ArrayList<>();
        enemies2.add(troll1);

        treasures1 = new ArrayList<>();
        treasures1.add(gold);
        treasures1.add(jewel);

        treasures2 = new ArrayList<>();
        treasures2.add(gold);
        treasures2.add(jewel);

        throneRoom = new ThroneRoom("001",false,enemies1,treasures1, LEVEL1);
        tortureRoom = new TortureRoom("002",false,enemies2,treasures2, LEVEL2);

        totalRoom = new ArrayList<>();
        totalRoom.add(throneRoom);
        totalRoom.add(tortureRoom);
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

    @Test
    public void canAttack(){
        barbarian1.attackEnemy(throneRoom, troll1);
        assertEquals(20,troll1.getHealth());
    }

    @Test
    public void canBeAttacked(){
        troll.attackPlayer(barbarian1);
        assertEquals(180,barbarian1.getHealth());
    }

    @Test
    public void hasCompletedRooms(){
        assertEquals(0,barbarian1.getCompletedRooms().size());
    }

    @Test
    public void canPickTreasures(){
        barbarian1.pickTreasureFromRoom(throneRoom);
        assertEquals(1,barbarian1.getTreasures().size());
        assertEquals(1,throneRoom.getTreasures().size());
    }

    @Test
    public void canCompleteRoomByPickingTreasures(){

        barbarian1.pickTreasureFromRoom(throneRoom);
        barbarian1.pickTreasureFromRoom(throneRoom);

        assertEquals(1,barbarian1.getCompletedRooms().size());
        assertEquals(true,throneRoom.isComplete());
    }

    @Test
    public void canCompleteRoomByKillingEnemies(){
        barbarian1.attackEnemy(throneRoom, troll1);
        barbarian1.attackEnemy(tortureRoom, troll1);
        assertEquals(0,throneRoom.getEnemies().size());
        assertEquals(true,throneRoom.isComplete());
        assertEquals(true,barbarian1.isFinish() );


    }
}