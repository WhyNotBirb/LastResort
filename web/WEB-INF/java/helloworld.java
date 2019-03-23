//import javax.imageio.ImageIO;
//import javax.json.Json;
//import javax.json.JsonArray;
//import javax.swing.*;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import java.awt.*;
//import java.io.IOException;
//import java.net.URL;
//
//// The Java class will be hosted at the URI path "/helloworld"
//@Path("/helloworld") //this is where the magic happens
//public class helloworld  {
//    // The Java method will process HTTP GET requests
//    @GET
//    // The Java method will produce content identified by the MIME Media type "text/plain"
//    //@Produces("image/png")
//    @Produces("text/plain")
//    public String getClichedMessage(int math) throws IOException {
//
//
//
//
//
//        myClient cli = new myClient();
//        URL url = new URL(cli.getImageURL(math));
//        Image image = ImageIO.read(url);
//
//        ImageIcon icon = new ImageIcon(image);
//        Image i = icon.getImage();
//
//
//        return url.toString();
//
//
//
//
//
//    }
//
//}
//
