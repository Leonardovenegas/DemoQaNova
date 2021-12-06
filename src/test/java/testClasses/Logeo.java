package testClasses;

import page.*;
import utils.ReadProperties;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

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
        matrizInformacion.abrirMatrizInformacion();
        matrizInformacion.validarDespliegue();
        matrizInformacion.escribirFiltro("prueba");
        matrizInformacion.clickBtnFiltrar();
        List<String> datosWeb = matrizInformacion.recuperarDatosFiltrados();
        String ip = ReadProperties.readFromConfig("Propiedades.properties").getProperty("ipBaseDeDatos");
        String bd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("baseDeDatos");
        String usuarioBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("usuarioBaseDeDatos");
        String claveBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("claveBaseDeDatos");
        String query = "select * from form where Campo_Texto like '%prueba%' or Campo_Mail like '%prueba%' or Campo_Area_de_Texto like '%prueba%';";
        List<String> datosBd = Utils.consultaBaseDeDatos(ip, bd, usuarioBd, claveBd, query);
        System.out.println("Datos recuperados desde la base de datos: " + datosBd);
        System.out.println("Datos recuperados desde la web: " + datosWeb);
        if (datosBd.equals(datosWeb)){
            PdfQaNovaReports.addReport("Comparacion datos web vs base de datos", "La comparacion de los datos recuperados desde la web contra los datos recuperados desde la base de datos ha sido exitosa, todos los datos recuperados son iguales", EstadoPrueba.PASSED, false);
        } else {
            PdfQaNovaReports.addReport("Comparacion datos web vs base de datos", "La comparacion de los datos recuperados desde la web contra los datos recuperados desde la base de datos ha fallado los datos son distintos", EstadoPrueba.FAILED, false);
        }
    }
}
