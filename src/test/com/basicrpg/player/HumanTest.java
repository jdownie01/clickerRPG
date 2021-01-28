package test.com.basicrpg.player;

import com.basicrpg.items.WorldItems;
import com.basicrpg.player.Human;
import com.basicrpg.player.Inventory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Human Tester.
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 1.0
 * @since <pre>Jan 25, 2021</pre>
 */
public class HumanTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: GetName()
     */
    @Test
    public void testGetName() throws Exception {
        Human test_human = new Human("Jake");
        assert test_human.GetName().equals("Jake");
    }

    /**
     * Method: GetBlood()
     */
    @Test
    public void testGetBlood() throws Exception {
        Human test_human = new Human("Jake");
        assert test_human.GetBlood() == 3000;
    }

    /**
     * Method: getLevel()
     */
    @Test
    public void testGetLevel() throws Exception {
        Human test_human = new Human("Jake");
        assert test_human.getLevel() == 0;

    }

    /**
     * Method: GetHealth()
     */
    @Test
    public void testGetHealth() throws Exception {
        Human test_human = new Human("Jake");
        assert test_human.GetHealth() == 100;
    }

    /**
     * Method: lifeTick()
     */
    @Test
    public void testLifeTick() throws Exception {
        Human test_human = new Human("Jake");
        test_human.setHealth(99);
        test_human.lifeTick();
        assert test_human.GetHealth() == 100;
    }

    /**
     * Method: handleDamage(int damage, String type)
     * When a thousand damage is dealt, health must be 0.
     */
    @Test
    public void testHandleDamage() throws Exception {
        Human test_human = new Human("Jake");
        test_human.handleDamage(10000, "Cutting");
        assert test_human.GetHealth() == 0;
    }

    /**
     * Method: getInventory()
     */
    @Test
    public void testGetInventory() throws Exception {
        Human jake = new Human("Jake");
        Inventory x = jake.getInventory();
    }

    /**
     * Method: handleEquip(Item newItem)
     */
    @Test
    public void testHandleEquip() throws Exception {
        Human jake = new Human("Jake");
        jake.handleEquip(WorldItems.apple);
        assert jake.getInventory().getItem() == WorldItems.apple;
    }

    /**
     * Method: setHealth(int this_health)
     */
    @Test
    public void testSetHealth() throws Exception {
        Human test_human = new Human("Jake");
        test_human.setHealth(500);
        assert test_human.GetHealth() == 500;
    }


    /**
     * Method: HandleXpGain()
     */
    @Test
    public void testHandleXpGain() throws Exception {
        Human test_human = new Human("Jake");
        test_human.setXP(104);
        test_human.HandleXpGain();
        assert test_human.getLevel() == 1;
    }

} 
