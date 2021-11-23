package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.Validaciones;

public class CargarArchivos {

    @FindBy(xpath = "//span[@class='imMnMnTextLabel' and text()='Carga de Archivos']")
    private WebElement btnCargaArchivos;

    @FindBy(id = "imPgTitle")
    private WebElement titulo;

    @FindBy(id = "imObjectForm_1_2")
    private WebElement inputCarga;

    @FindBy(id = "imObjectForm_1_submit")
    private WebElement btnEnviar;

    @FindBy(xpath = "//input[@value = 'Resetear']")
    private  WebElement btnResetear;

    public CargarArchivos(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue(){
        Validaciones.validarObjeto(titulo, "Titulo pagina");
    }

    public void validarTextoTitulo(){
        Validaciones.validarTexto(titulo, "Carga de Archivos");
    }

    
}
