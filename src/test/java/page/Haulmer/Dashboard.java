package page.Haulmer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.Validaciones;

import java.util.concurrent.TimeUnit;

public class Dashboard {

    @FindBy(xpath = "//table")
    private WebElement tabla;

    @FindBy(xpath = "/html/body/app-root/div[1]/app-products/section/button")
    private WebElement anadirProducto;

    @FindBy(id = "mat-input-1")
    private WebElement nombre;

    @FindBy(xpath = "(//mat-icon[text()='add'])[1]")
    private WebElement sumarIva;

    @FindBy(id = "mat-input-2")
    private WebElement descripcion;

    @FindBy(id = "mat-input-3")
    private WebElement precio;

    @FindBy(id = "mat-input-4")
    private WebElement sku;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnGuardar;

    public Dashboard(){
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    public void validarDespliegue(){
        Validaciones.validarObjeto(tabla, "Tabla");
    }

    public void clickAnadirProducto(){
        anadirProducto.click();
    }

    public void validarFormulario(int puntero) throws InterruptedException {
        nombre = DriverContext.getDriver().findElement(By.id("mat-input-"+puntero));
        descripcion = DriverContext.getDriver().findElement(By.id("mat-input-"+(puntero+1)));
        precio = DriverContext.getDriver().findElement(By.id("mat-input-"+(puntero+2)));
        sku = DriverContext.getDriver().findElement(By.id("mat-input-"+(puntero+3)));
        Validaciones.validarDisponibilidadObjeto(nombre, "Input nombre");
        Thread.sleep(5000);
    }

    public void rellenarFormulario(String nombreProducto, String descripcionProducto, String precioProducto, String skuProducto){
        nombre.sendKeys(nombreProducto);
        descripcion.sendKeys(descripcionProducto);
        sumarIva.click();
        AgregarIva agregarIva = new AgregarIva();
        agregarIva.agregar();
        Validaciones.validarDisponibilidadObjeto(precio, "Precio");
        precio.sendKeys(precioProducto);
        sku.sendKeys("381922"+skuProducto);
    }

    public void anadir() throws InterruptedException {
        btnGuardar.click();
        Thread.sleep(4000);
        if (btnGuardar.isDisplayed()){
            btnGuardar.click();
        }
    }
}
