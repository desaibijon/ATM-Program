package testpackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import atm.*;

/**
 *
 * @author bijondesai
 */
public class depositTest {
    
    public depositTest() {
    }
    
    @Test
    public void Test(){
        ATM test = new ATM();
        assertEquals(190000, test.deposit(40000), 0);
        assertEquals(230000, test.deposit(40000), 0);
        assertEquals(270000, test.deposit(40000), 0);
        assertEquals(290000, test.deposit(20000), 0);
        assertEquals(290000, test.deposit(15000), 0);
        assertEquals(290000, test.deposit(45000), 0);
        assertEquals(290000, test.deposit(0), 0);
        assertEquals(290000, test.deposit(-50), 0);
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
