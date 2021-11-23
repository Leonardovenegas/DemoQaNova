package testClasses;

import page.*;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import java.io.IOException;
import java.text.ParseException;

public class Logeo {

    private Login login;
    private MatrizInformacion matrizInformacion;
    private CargaInformacion cargaInformacion;
    private CargarArchivos cargarArchivos;

    public Logeo(){
    }

    public void CasoLogin1(String usuario, String clave) throws IOException {
        login = new Login();
        cargaInformacion = new CargaInformacion();
        cargarArchivos = new CargarArchivos();
        matrizInformacion = new MatrizInformacion();
        login.validarTextoUsuario("Nombre del usuario:");
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
        cargarArchivos.ingresarCargarArchivos();
        cargarArchivos.validarDespliegue();
        cargarArchivos.validarTextoTitulo();
        cargarArchivos.cargarArchivo();
        cargarArchivos.clickBtnEnviar();
        matrizInformacion.validarDespliegue();
        PdfQaNovaReports.addReport("Archivo de carga", "Archivo cargado exitosamente", EstadoPrueba.PASSED, false);
    }
}
