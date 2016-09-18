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
public class withdrawalTest {
    
    public withdrawalTest() {
    }
    
    @Test
    public void Test(){
        ATM test = new ATM();
        assertEquals(150000, test.withdrawal(160000), 0);
        assertEquals(130000, test.withdrawal(20000), 0);
        assertEquals(110000, test.withdrawal(20000), 0);
        assertEquals(110000, test.withdrawal(15000), 0);
        assertEquals(110000, test.withdrawal(25000), 0);
        assertEquals(110000, test.withdrawal(0), 0);
        assertEquals(110000, test.withdrawal(-50), 0);
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
