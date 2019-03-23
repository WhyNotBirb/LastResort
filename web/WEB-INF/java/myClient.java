import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.Certificate;
import java.util.Scanner;
import javax.net.ssl.*;
import javax.imageio.ImageIO;

import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;
import javax.swing.text.AbstractDocument;

import com.google.gson.*;

public class myClient {


    private static comic parse(String web, String get) throws JsonIOException, JsonSyntaxException, IOException{



        URL url = new URL(web);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        String redirect = request.getHeaderField("Location");

        if (redirect != null){
            request = (HttpURLConnection)new URL(redirect).openConnection();
        }
        int responsecode = request.getResponseCode();







        if(responsecode != 200)
            throw new RuntimeException("HttpResponseCode: " +responsecode);
        else
        {


            //  request.setRequestMethod("GET");

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            //InputStream stream =  request.getInputStream();

            // JsonElement root = jp.parse(new InputStreamReader( stream));

            // JsonObject rootobj = root.getAsJsonObject();
            comic  resp=new comic();
            String res="";
            if (root instanceof JsonObject) {
                JsonObject  jobject = root.getAsJsonObject();
                Gson gson = new GsonBuilder().create();
                // res = gson.fromJson(jsonString, comic.class);
                res = jobject.toString();
                resp = gson.fromJson(jobject.toString(),comic.class);

            } else if (root instanceof JsonArray) {
                JsonArray jarray =  root.getAsJsonArray();
                res = jarray.toString();
            }

            return  resp;}
    }



    public static comic getImageURL(int page) throws JsonIOException, JsonSyntaxException, IOException{



        comic imageLink = parse("https://xkcd.com/" + page + "/info.0.json", "img");
        return imageLink;
    }




}