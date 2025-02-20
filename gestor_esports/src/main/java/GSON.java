import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class GSON {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /** Retorna un JsonArray amb el contingut del fitxer JSON */
    public static JsonArray retornaFitxerJson(String fitxer) throws IOException {
        try (Reader reader = new FileReader(fitxer)) {
            return JsonParser.parseReader(reader).getAsJsonArray();
        }
    }

    /** Retorna el contingut d'un fitxer JSON com a String */
    public static String retornaFitxerJsonAString(String fitxer) throws IOException {
        return gson.toJson(retornaFitxerJson(fitxer));
    }

    /** Escriu un String JSON en un fitxer */
    public static void escriuStringJsonAFitxer(String rutaDesti, String contingut) throws IOException {
        try (Writer writer = new FileWriter(rutaDesti)) {
            writer.write(contingut);
        }
    }

    /** Escriu un fitxer JSON formatat amb Pretty Print */
    public static void sobreEscriuStringJsonAmbPrettyFormat(String rutaDesti, String contingutJson) throws IOException {
        JsonElement jsonElement = JsonParser.parseString(contingutJson);
        try (Writer writer = new FileWriter(rutaDesti)) {
            gson.toJson(jsonElement, writer);
        }
    }

    /** Sobreescriu un fitxer JSON existent en format Pretty */
    public static void sobreEscriuArxiuJsonAmbPrettyFormat(String fitxerOriginal, String fitxerDesti) throws IOException {
        JsonArray jsonArray = retornaFitxerJson(fitxerOriginal);
        try (Writer writer = new FileWriter(fitxerDesti)) {
            gson.toJson(jsonArray, writer);
        }
    }

    /** Escriu i acumula un objecte JSON en un fitxer */
    public static void escriuObjecteJAVAaFitxerJson(String rutaFitxer, Object objJson, boolean pretty) throws IOException {
        Gson gsonToUse = pretty ? gson : new Gson();
        try (Writer writer = new FileWriter(rutaFitxer, true)) {
            gsonToUse.toJson(objJson, writer);
        }
    }

    /** Mostra un String JSON en format Pretty */
    public static String jsonAPrettyFormat(String jsonString) {
        JsonElement jsonElement = JsonParser.parseString(jsonString);
        return gson.toJson(jsonElement);
    }

    /** Mostra el contingut d'un fitxer JSON per consola */
    public static void mostraFitxerJsonConsola(String fitxer) throws IOException {
        System.out.println(retornaFitxerJsonAString(fitxer));
    }

    /** Mostra el contingut d'un fitxer JSON en format Pretty per consola */
    public static void mostraFitxerJsonConsolaPrettyFormat(String fitxer) throws IOException {
        System.out.println(jsonAPrettyFormat(retornaFitxerJsonAString(fitxer)));
    }

    /** Cerca una dada dins d'un fitxer JSON i la mostra per consola */
    public static void cercarJsonConsola(String fitxer, String dadaACercar) throws IOException {
        List<JsonObject> jsonList = retornaJsonLlista(fitxer);
        for (JsonObject obj : jsonList) {
            if (obj.toString().contains(dadaACercar)) {
                System.out.println(obj);
            }
        }
    }

    /** Retorna els objectes JSON que coincideixen amb la dada cercada */
    public static List<JsonObject> retornaJsonLlista(String fitxer) throws IOException {
        try (Reader reader = new FileReader(fitxer)) {
            Type listType = new TypeToken<List<JsonObject>>() {}.getType();
            return gson.fromJson(reader, listType);
        }
    }

    /** Cerca una dada en un fitxer i retorna un JsonArray amb les coincidències */
    public static JsonArray cercaJsonArray(String fitxer, String dadaACercar) throws IOException {
        JsonArray jsonArray = retornaFitxerJson(fitxer);
        JsonArray resultats = new JsonArray();
        for (JsonElement element : jsonArray) {
            if (element.toString().contains(dadaACercar)) {
                resultats.add(element);
            }
        }
        return resultats;
    }
}
