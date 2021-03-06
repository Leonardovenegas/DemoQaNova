package testSuites;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClasses.Haulmer;
import testClasses.Logeo;
import utils.Constants.Navegador;
import utils.DriverContext;
import utils.ReadProperties;
import utils.Reporte.PdfQaNovaReports;
import utils.Utils;

import java.beans.Transient;
import java.io.IOException;
import java.text.ParseException;

public class Prueba {

    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome, ReadProperties.readFromConfig("Propiedades.properties").getProperty("url"));
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    public void closeDriver(){
        //DriverContext.closeDriver();
    }

    @Test
    public void pruebaLogin() throws ParseException, IOException {
        Logeo logeo = new Logeo();
        String usuario = ReadProperties.readFromConfig("Propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("Propiedades.properties").getProperty("clave");
        logeo.CasoLogin1(usuario, clave);
        PdfQaNovaReports.closePDF();
        //Utils.enviarCorreo("lvenegas@qanova.cl");
    }

    @Test
    public void haulmer() throws InterruptedException {
        Haulmer haulmer = new Haulmer();
        haulmer.ingresarProductos();
        PdfQaNovaReports.closePDF();
    }
}