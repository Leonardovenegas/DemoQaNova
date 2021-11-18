package page;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class LeerJson {

    public LeerJson(){

    }

    public void recuperarJson() throws IOException {
        String url = "https://farmanet.minsal.cl/index.php/ws/getLocalesTurnos";
        InputStream is = new URL(url).openStream();
        Gson gson = new Gson();
        String fichero = "";
        try(BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")))){
            String lineas;
            while ((lineas = rd.readLine()) != null){
                fichero = fichero + lineas;
            }
            Type listadoFarmacias = new TypeToken<List<Farmacia>>(){}.getType();
            List<Farmacia> farmacias = gson.fromJson(fichero, listadoFarmacias);
            System.out.println("resulto");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
