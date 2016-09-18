/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

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
public class frequencyTest {
    
    public frequencyTest() {
    }
    
    @Test
    public void Test(){
        ATM test = new ATM();
        assertTrue(test.candeposit(3));
        assertFalse(test.candeposit(5));
        assertTrue(test.canwithdraw(2));
        assertFalse(test.canwithdraw(5));
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
