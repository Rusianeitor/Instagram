package test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.SeguidoresPage;

public class SeguidoresTest {

    private WebDriver driver;
    public SeguidoresPage seguidores;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        seguidores=new SeguidoresPage(driver);
        driver=seguidores.chromeDriverConnection();
        seguidores.visit("https://www.instagram.com");
    }

    @Test
    public void seguidores (){
        seguidores.logeo();
        seguidores.magia();
    }

    @After
    public void tearDown() throws Exception {
    }
}