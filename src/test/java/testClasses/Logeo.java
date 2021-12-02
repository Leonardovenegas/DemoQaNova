package testClasses;

import page.*;
import utils.ReadProperties;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Utils;

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
        /*login = new Login();
        cargaInformacion = new CargaInformacion();
        cargarArchivos = new CargarArchivos();
        matrizInformacion = new MatrizInformacion();
        login.validarTextoUsuario("Nombre del usuario:");
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
        matrizInformacion.abrirMatrizInformacion();
        matrizInformacion.validarDespliegue();*/
        String ip = ReadProperties.readFromConfig("Propiedades.properties").getProperty("ipBaseDeDatos");
        String bd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("baseDeDatos");
        String usuarioBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("usuarioBaseDeDatos");
        String claveBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("claveBaseDeDatos");
        String query = "select * from form where id = 1;";
        Utils.consultaBaseDeDatos(ip, bd, usuarioBd, claveBd, query);
    }
}
