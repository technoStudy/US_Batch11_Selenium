package day05;

import org.junit.*;

public class C03_BeforeClassAfterClassAnotations {

    // @BeforeClass must be static. This is because the method needs to be invoked
    // without creating an instance of the test class.
    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class Method Run");
    }

    @Before
    public void setUp(){
        System.out.println("Before Method Run");
    }

    @Test
    public void test01(){
        System.out.println("test1 Run");
    }
    @Test
    public void test02(){
        System.out.println("test2 Run");
    }
    @Test
    public void test03(){
        System.out.println("test3 Run");
    }
    // @AfterClass runs only once at the end of the test execution,
    // not after each test method.b
    @AfterClass
    public static void tearDownClass(){
        System.out.println("After Class Method Run");
    }

    @After
    public void tearDown(){
        System.out.println("After Method Run");
    }

}
