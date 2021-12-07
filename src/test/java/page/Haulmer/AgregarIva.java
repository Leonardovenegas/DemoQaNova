package page.Haulmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.Validaciones;

public class AgregarIva {

    @FindBy(xpath = "//span[text()=' 19.0% - Impuesto al valor agregado (IVA) ']")
    private WebElement iva19;

    @FindBy(xpath = "//span[text()=' Agregar ']")
    private WebElement agregarIva;

    public AgregarIva(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void agregar(){
        Validaciones.validarObjeto(iva19, "IVA");
        iva19.click();
        agregarIva.click();
    }
}
