package testClasses;

import page.Haulmer.Dashboard;
import page.Haulmer.Login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Haulmer {

    Login login = new Login();
    Dashboard dashboard;

    public Haulmer(){

    }

    public void ingresarProductos() throws InterruptedException {
        login.validarDespliegue();
        login.ingresarConGoogle();
        login.ingresarUsuario();
        login.ingresarClave();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        List<String> productos = new ArrayList<>();
        try {
            archivo = new File ("C:\\Users\\leona\\Downloads\\productos.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null) {
                System.out.println(linea);
                productos.add(linea);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        int puntero = 1;
        //*************************************************************
        for (String producto: productos) {
            List<String> detalle = Arrays.asList(producto.split(","));
            dashboard = new Dashboard();
            dashboard.validarDespliegue();
            dashboard.clickAnadirProducto();
            dashboard.validarFormulario(puntero);
            dashboard.rellenarFormulario(detalle.get(2), detalle.get(1), detalle.get(3), detalle.get(0));
            dashboard.anadir();
            dashboard.validarDespliegue();
            System.out.println("Hecho");
            puntero = puntero + 7;
        }
    }
}
