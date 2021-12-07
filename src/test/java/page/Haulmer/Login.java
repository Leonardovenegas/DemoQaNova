package page.Haulmer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.Validaciones;

public class Login {

    @FindBy(xpath = "//div[text() = 'Iniciar con Google']")
    private WebElement loginGoogle;

    @FindBy(id = "identifierId")
    private WebElement correo;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement clave;

    public Login(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue(){
        Validaciones.validarObjeto(loginGoogle, "Boton Google");
    }

    public void ingresarConGoogle(){
        loginGoogle.click();
    }

    public void ingresarUsuario(){
        Validaciones.validarObjeto(correo, "Input Correo");
        correo.sendKeys("lvenegas@tqimport.com");
        correo.sendKeys(Keys.ENTER);
    }

    public void ingresarClave(){
        Validaciones.validarObjeto(clave, "Input Clave");
        clave.sendKeys("87156316Leo");
        clave.sendKeys(Keys.ENTER);
    }
}
