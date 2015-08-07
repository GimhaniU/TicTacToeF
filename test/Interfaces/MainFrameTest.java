/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DinsuG
 */
public class MainFrameTest {
    
    public MainFrameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of randomClick method, of class MainFrame.
     */
    @Test
    public void testRandomClick() {
        System.out.println("randomClick");
        MainFrame instance = new MainFrame();
        instance.randomClick();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replay method, of class MainFrame.
     */
    @Test
    public void testReplay() {
        System.out.println("replay");
        MainFrame instance = new MainFrame();
        instance.replay();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkSuitableClick method, of class MainFrame.
     */
    @Test
    public void testCheckSuitableClick() {
        System.out.println("checkSuitableClick");
        Component component = null;
        String player = "";
        String machine = "";
        MainFrame instance = new MainFrame();
        boolean expResult = false;
        boolean result = instance.checkSuitableClick(component, player, machine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of humanPart method, of class MainFrame.
     */
    @Test
    public void testHumanPart() {
        System.out.println("humanPart");
        Component component = null;
        MainFrame instance = new MainFrame();
        boolean expResult = false;
        boolean result = instance.humanPart(component);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectButton method, of class MainFrame.
     */
    @Test
    public void testSelectButton() {
        System.out.println("selectButton");
        int j = 0;
        MainFrame instance = new MainFrame();
        int expResult = 0;
        int result = instance.selectButton(j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkToAvoidWin method, of class MainFrame.
     */
    @Test
    public void testCheckToAvoidWin() {
        System.out.println("checkToAvoidWin");
        Component component = null;
        MainFrame instance = new MainFrame();
        boolean expResult = false;
        boolean result = instance.checkToAvoidWin(component);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkToOwnWin method, of class MainFrame.
     */
    @Test
    public void testCheckToOwnWin() {
        System.out.println("checkToOwnWin");
        Component component = null;
        MainFrame instance = new MainFrame();
        boolean expResult = false;
        boolean result = instance.checkToOwnWin(component);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of controlOnePlayerGameHard method, of class MainFrame.
     */
    @Test
    public void testControlOnePlayerGameHard() {
        System.out.println("controlOnePlayerGameHard");
        Component component = null;
        MainFrame instance = new MainFrame();
        instance.controlOnePlayerGameHard(component);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of controlOnePlayerGameMedium method, of class MainFrame.
     */
    @Test
    public void testControlOnePlayerGameMedium() {
        System.out.println("controlOnePlayerGameMedium");
        Component component = null;
        MainFrame instance = new MainFrame();
        instance.controlOnePlayerGameMedium(component);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of controlOnePlayerGameEasy method, of class MainFrame.
     */
    @Test
    public void testControlOnePlayerGameEasy() {
        System.out.println("controlOnePlayerGameEasy");
        Component component = null;
        MainFrame instance = new MainFrame();
        instance.controlOnePlayerGameEasy(component);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of controlOnePlayerGame method, of class MainFrame.
     */
    @Test
    public void testControlOnePlayerGame() {
        System.out.println("controlOnePlayerGame");
        Component component = null;
        MainFrame instance = new MainFrame();
        instance.controlOnePlayerGame(component);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of controlTwoPlayerGame method, of class MainFrame.
     */
    @Test
    public void testControlTwoPlayerGame() {
        System.out.println("controlTwoPlayerGame");
        Component component = null;
        MainFrame instance = new MainFrame();
        instance.controlTwoPlayerGame(component);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of controlNetworkGame method, of class MainFrame.
     */
    @Test
    public void testControlNetworkGame() {
        System.out.println("controlNetworkGame");
        MouseEvent e = null;
        MainFrame instance = new MainFrame();
        instance.controlNetworkGame(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addButtonLabel method, of class MainFrame.
     */
    @Test
    public void testAddButtonLabel() {
        System.out.println("addButtonLabel");
        String[] matrix = null;
        MainFrame instance = new MainFrame();
        instance.addButtonLabel(matrix);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of labelController method, of class MainFrame.
     */
    @Test
    public void testLabelController() {
        System.out.println("labelController");
        MainFrame instance = new MainFrame();
        instance.labelController();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findWinner method, of class MainFrame.
     */
    @Test
    public void testFindWinner() {
        System.out.println("findWinner");
        MainFrame instance = new MainFrame();
        String expResult = "";
        String result = instance.findWinner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newGame method, of class MainFrame.
     */
    @Test
    public void testNewGame() {
        System.out.println("newGame");
        MainFrame instance = new MainFrame();
        instance.newGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkWin method, of class MainFrame.
     */
    @Test
    public void testCheckWin() {
        System.out.println("checkWin");
        MainFrame instance = new MainFrame();
        int expResult = 0;
        int result = instance.checkWin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSymbol method, of class MainFrame.
     */
    @Test
    public void testShowSymbol() {
        System.out.println("showSymbol");
        MainFrame instance = new MainFrame();
        ImageIcon expResult = null;
        ImageIcon result = instance.showSymbol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MainFrame.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MainFrame.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class MainFrame.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        MainFrame instance = new MainFrame();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNetworkMsgLabelText method, of class MainFrame.
     */
    @Test
    public void testSetNetworkMsgLabelText() {
        System.out.println("setNetworkMsgLabelText");
        String text = "";
        MainFrame instance = new MainFrame();
        instance.setNetworkMsgLabelText(text);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
