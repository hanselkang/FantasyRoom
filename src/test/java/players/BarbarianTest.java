package players;

import org.junit.Before;
import org.junit.Test;
import weapons.Sword;
import weapons.Weapon;

import static org.junit.Assert.*;

public class BarbarianTest {

    Barbarian barbarian1;
    Sword sword;
    @Before
    public void before(){
        sword = new Sword("Sword",20);
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

}