package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import exceptions.CultivoException;
import model.*;
import exceptions.CofreException;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.LinkedList;
import model.SimpleLinkedListCultivos;

public class CofreController {
    private Cofre cofre;
    private File dataDirectory;
    private File jsonFile;


    public CofreController() {
        cofre = new Cofre();
        SimulacionEstaciones simulacion = new SimulacionEstaciones();

        simulacion.iniciarSimulacion();
        File projectDir = new File(System.getProperty("user.dir"));
        this.dataDirectory = new File(projectDir + "/src/main/data");
        this.jsonFile = new File(dataDirectory.getAbsolutePath() + "/cofre.json");
    }

    public void createResources() throws IOException {
        if (!dataDirectory.exists()) {
            dataDirectory.mkdirs();
        }
        if (!jsonFile.exists()) {
            jsonFile.createNewFile();
        }
    }
    //Arreglar esto
  //  public void addCultivo(Cultivo cultivo) throws CultivoException {
    //    SimulacionEstaciones simulacion = new SimulacionEstaciones();
      //  String estacionActual = simulacion.obtenerEstacionActual();
        //if (!cultivo.getEstacion().equalsIgnoreCase(estacionActual)) {
          //  throw new CultivoException("El cultivo no corresponde a la estación actual: " + estacionActual);
        //}
        //SimpleLinkedListCultivos.agregarCultivo(cultivo);
   // }

}
