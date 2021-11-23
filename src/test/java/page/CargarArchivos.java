package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.ReadProperties;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

import java.io.File;

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

    public void ingresarCargarArchivos(){
        btnCargaArchivos.click();
    }

    public void validarDespliegue(){
        Validaciones.validarObjeto(titulo, "Titulo pagina");
    }

    public void validarTextoTitulo(){
        Validaciones.validarTexto(titulo, "Carga de Archivos");
    }

    public void cargarArchivo(){
        String ruta = ReadProperties.readFromConfig("Propiedades.properties").getProperty("directorioCargas");
        String archivo = "Archivo de prueba.pdf";
        File file = new File(ruta+"\\"+archivo);
        if (file.exists()){
            System.out.println("Existe archivo a cargar");
            PdfQaNovaReports.addReport("Archivo "+archivo, "El archivo '"+archivo+"' existe en la ruta '"+ruta+"'.", EstadoPrueba.PASSED, false);
        } else  {
            System.out.println("NO existe archivo a cargar");
            PdfQaNovaReports.addReport("Archivo "+archivo, "El archivo '"+archivo+"' NO existe en la ruta '"+ruta+"'.", EstadoPrueba.FAILED, true);
        }
        inputCarga.sendKeys(file.getAbsolutePath());
        PdfQaNovaReports.addWebReportImage("Carga de archivo "+archivo, "El archivo '"+archivo+"' se ha ubicado existosamente para su carga.", EstadoPrueba.PASSED, false);
    }

    public void clickBtnEnviar(){
        btnEnviar.click();
        PdfQaNovaReports.addReport("Click boton enviar", "Se ha presionado el boton enviar, para cargar el archivo.", EstadoPrueba.PASSED, false);
    }
}
