package enemies;

import org.junit.Before;
import org.junit.Test;
import players.Barbarian;
import weapons.Club;
import weapons.Weapon;

import static org.junit.Assert.*;

public class TrollTest {

    Troll troll;
    Club club;

    Barbarian barbarian;


    @Before
    public void before(){
        club = new Club("Club",20);
        troll = new Troll("John",50,club);
        barbarian = new Barbarian("Stuart",10,20,30,club);
    }

    @Test
    public void hasName(){
        assertEquals("John",troll.getName());
    }

    @Test
    public void hasHealth(){
        assertEquals(50,troll.getHealth());
    }

    @Test
    public void hasWeapon(){
        assertEquals(club,troll.getWeapon());
    }

    @Test
    public void canAttack(){
        troll.attackPlayer(barbarian);
        assertEquals(10,barbarian.getHealth());
    }


}