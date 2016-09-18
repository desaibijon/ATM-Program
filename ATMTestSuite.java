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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author bijondesai
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ testpackage.depositTest.class, testpackage.withdrawalTest.class, testpackage.quitTest.class, 
                    testpackage.getbalanceTest.class, testpackage.userInputTest.class, testpackage.frequencyTest.class})
public class ATMTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
