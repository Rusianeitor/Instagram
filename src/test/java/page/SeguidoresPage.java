package page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SeguidoresPage extends Base {
    By nameLocator= By.name("username");
    By passLocator=By.name("password");
    By btnIniciarLocator=By.xpath("//div[text()='Iniciar sesión']");
    By btnNotificacionLocator=By.xpath("//button[text()='Ahora no']");
    By tabPerfilLocator=By.xpath("//span[text()='Perfil']");
    By txtSeguidoresLocator=By.xpath("//a[text()=' seguidores']");
    By btnEliminarLocator=By.xpath("//div[text()='Eliminar']");
    By btnConfirmarLocator=By.cssSelector("button[class='_a9-- _ap36 _a9-_']");
    By btnCerrarLocator=By.cssSelector("svg[aria-label='Cerrar']");
    public SeguidoresPage(WebDriver driver) {
        super(driver);
    }

    public void logeo(){
        esperaExplicita(10, nameLocator);
        type("si62.jsotoe@gmail.com",nameLocator);
        type("Backinblack12",passLocator);
        esperaExplicita(10, btnIniciarLocator);
        click(btnIniciarLocator);
    }

    public void magia(){
        esperaExplicita(10,btnNotificacionLocator);
        click(btnNotificacionLocator);
        click(tabPerfilLocator);

        for (short i=0; i<2; i++){ //poner el i<2 a 5000
            esperaExplicita(10, txtSeguidoresLocator);
            click(txtSeguidoresLocator);
            esperaExplicita(10, btnEliminarLocator);
            List<WebElement> botones=new ArrayList<>();
            botones=findElements(btnEliminarLocator);
            for(short j=0; j<2; j++){ //poner el j<2 a 5
                click(botones.get(j));
                esperaExplicita(10,btnConfirmarLocator);
                click(btnConfirmarLocator);
            }
            esperaExplicita(10,btnCerrarLocator);
            click(btnCerrarLocator);
        }
    }
}
