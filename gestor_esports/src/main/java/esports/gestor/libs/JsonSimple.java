package esports.gestor.libs;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

public class JsonSimple {


    // JSON SIMPLE


    /********/
    // JSON //
    /********/

    public JsonSimple(){

    }


    /**
     * Retorna un objecte JSONArray amb tot el contingut del fitxer JSON
     *
     * @param fitxer nom del fitxer
     * @return JSONArray amb el contingut de tol el fiter JSON
     * @throws IOException    Excepció d'I/O
     * @throws ParseException Excepció de Parser
     */
    public JSONArray retornaFitxerJson(String fitxer) throws IOException, ParseException, org.json.simple.parser.ParseException {

        JSONParser parser = new JSONParser();            // creem el parser
        Object obj = parser.parse(new FileReader(fitxer));    // llegim el fitxer

        // convert object to JSONArray
        JSONArray jsonArray = (JSONArray) obj;            // escrivim el contingut
        // del fitxer en un JSONArray
        return jsonArray;                        // retornem el JSONArray
    }

    /**
     * Retorna un objecte JSONArray amb tot el contingut del fitxer JSON
     *
     * @param fitxer nom del fitxer
     * @return JSONArray amb el contingut de tol el fiter JSON
     * @throws IOException    Excepció d'I/O
     * @throws ParseException Excepció de Parser
     */
    public String retornaFitxerJsonAString(String fitxer) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONArray ja = retornaFitxerJson(fitxer);
        return ja.toJSONString();                       // retornem l'String
    }

    /**
     * Escriu un String ja amb format json a un fitxer Json
     * @param rutaDesti Ruta del fitxer destí
     * @param contingut contingut de l'String amb format json
     * @throws IOException excepció d'E/S
     */
    public void escriuStringJsonAFitxerJson(String rutaDesti,
                                            String contingut) throws IOException {
        Files.write(Paths.get(rutaDesti), contingut.getBytes());
        // false pq hem d'escriure l'arxiu sencer cada cop
    }



    /**
     * Escriu un fitxer en format json. Aquesta funció sols permetrà parells de dades.
     * Per exemple (nom, cognom, edat, telèfon(sols 1), adreça(sols 1), etc
     *
     * @param fitxer    ruta del fitxer json
     * @param camps     noms dels camps: nom, cognom, edat
     * @param contingut contingut dels camps: vicent, bellver, 34
     * @param afegir    true -- afegeix a l'arxiu existent. False -- substitueix l'arxiu
     */
    public void escriuEnFitxerJSONParellsDeDades(String fitxer,
                                                 String[] camps,
                                                 String[] contingut,

                                                 boolean afegir) {

        // creating JSONObject
        JSONObject jo = new JSONObject();
        int i = 0;


        // putting data to JSONObject
        do {
            jo.put(camps[i], contingut[i]);
            i++;
        }
        while (i < camps.length);


        //Write JSON file
        try (FileWriter file = new FileWriter(fitxer, afegir)) {
            file.write(jo.toJSONString());
            file.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * En principi hauria de mostrar un fitxer JSON per consola
     *
     * @param fitxer fitxer a mostrar
     * @throws IOException    Excepció d'E/S
     * @throws ParseException Excepció de parser
     */
    public void mostraFitxerJSONConsola(String fitxer) throws IOException, ParseException, org.json.simple.parser.ParseException {

        JSONArray ja = retornaFitxerJson(fitxer);
        String arxiuJson = ja.toJSONString();
        System.out.println(arxiuJson);
    }



    /**
     * En principi hauria de cercar "dada a Cercar" dintre d'un fitxer JSON
     *
     * @param fitxer      fitxer a obrir
     * @param dadaACercar dada a cercar
     * @throws IOException    Excepció d'E/S
     * @throws ParseException Excepció de parser
     */
    public void cercarJSONConsola(String fitxer,
                                  String dadaACercar) throws IOException, ParseException, org.json.simple.parser.ParseException {

        JSONParser parser = new JSONParser();
        File file = new File(fitxer);
        FileReader reader = new FileReader(file);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        JSONArray dades = (JSONArray) jsonObject.get(dadaACercar);

        Map<String, String> map = new HashMap<String, String>();
        List<Map<String, String>> lstmap = new ArrayList<Map<String, String>>();

        Iterator<String> iter = null;
        Iterator<String> iter2 = null;

        for (int i = 0; i < dades.size(); i++) {

            JSONObject firstarr = (JSONObject) dades.get(i);

            iter = firstarr.keySet().iterator();
            //iter2 = firstarr.values().iterator();

            while (iter.hasNext()) {
                String key = (String) iter.next();
                String value = firstarr.toJSONString();
                //String value = (String)iter2.next();

                map.put(key, value);
                lstmap.add(i, map);
                System.out.println(i + ":  " + key + "  " + map.get(key));

            }
        }

//        for(int i=0;i<lstmap.size();i++){
//
//            Map<String,String> mapget = lstmap.get(i);
//
//            for (Map.Entry<String, String> entry : mapget.entrySet()) {
//                System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
//            }
//        }

    }


    /**
     * Retorna el contingut d'un fitxer JSON a una llista de JSONObject. Tots els que coincideixin amb dadaACercar.
     * CREC QUE NO FUNCIONA!!
     *
     * @param fitxer      Fitxer a
     * @param dadaACercar Camp a cercar
     * @return Llista d'objectes JSONObject
     * @throws IOException    Excepció d'E/S
     * @throws ParseException Excepció de parse
     */
    public List<JSONObject> retornaJSONLlista(String fitxer,
                                              String dadaACercar) throws IOException, ParseException, org.json.simple.parser.ParseException {

        JSONParser parser = new JSONParser();
        File file = new File(fitxer);
        FileReader reader = new FileReader(file);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        JSONArray dades = (JSONArray) jsonObject.get(dadaACercar);

//        Map<String,String> map = new HashMap<String,String>();
//        List<Map<String, String>> lstmap = new ArrayList<Map<String, String>>();
        List<JSONObject> llista = new ArrayList<>();

        Iterator<String> iter = null;

        for (int i = 0; i < dades.size(); i++) {

            JSONObject firstarr = (JSONObject) dades.get(i);
            llista.add(firstarr);

        }
        return llista;
    }

    /**
     * Cerca una dada al fitxer i ens retorna un JSONarray
     *
     * @param fitxer      Ruta del fitxer JSON
     * @param dadaACercar Dada a cercar
     * @return retorna JSONArray que correspon amb la dada a cercar
     * @throws IOException    Excepció d'E/S
     * @throws ParseException Excepció de parse
     */
    public JSONArray cercarJSON(String fitxer,
                                String dadaACercar) throws IOException, ParseException, org.json.simple.parser.ParseException {

        JSONParser parser = new JSONParser();
        File file = new File(fitxer);
        FileReader reader = new FileReader(file);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);

        JSONArray dades = (JSONArray) jsonObject.get(dadaACercar);

        Map<String, String> map = new HashMap<String, String>();
        List<Map<String, String>> lstmap = new ArrayList<Map<String, String>>();

        Iterator<String> iter = null;
        Iterator<String> iter2 = null;

        return dades;

    }

    /**
     * Canvia dades que li passem per paràmetre
     *
     * @param fitxer       fitxer JSON a modificar
     * @param nomCamp      nom del camp a modificar
     * @param dadaACanviar valor que volem canviar
     */
    public void canviarDadesJson(String fitxer,
                                 String nomCamp,
                                 String dadaACanviar) {


    }


}
