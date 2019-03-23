

// Import required java libraries

import com.google.gson.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

// Extend HttpServlet class
@WebServlet(name = "apiServlet", urlPatterns = "/yo")
public class apiservlet extends HttpServlet {



  //private helloworld message = new helloworld();
    int random = (int)(Math.random() * 2117 + 1);
    public void init() throws ServletException {
        // Do required initialization

       // message = "Hello World";
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        if (request.getParameter("button1") != null) {
            random--;
        } else if (request.getParameter("button2") != null) {
           random++;
        }

            // Set response content type
            response.setContentType("text/html");
            String imgUrl=myClient.getImageURL(random).img;
            String alt=myClient.getImageURL(random).alt;
            String title=myClient.getImageURL(random).safe_title;

            // Actual logic goes here.
            // PrintWriter out = response.getWriter();
            // out.println("<img src="+getImageURL(random)+"></img>");

            request.setAttribute("name", imgUrl);
            request.setAttribute("alttext",alt);
            request.setAttribute("title",title);
            // request.getRequestDispatcher("index.jsp").forward(request, response);
            request.getRequestDispatcher("index.jsp").include(request, response);



    }


    public void destroy() {
        // do nothing.
    }
}
//
//
//
//@WebServlet(name = "apiServlet",urlPatterns = {"/yo"})
//public class apiservlet extends HttpServlet {
//
//
//
//
//
//
//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("image/png");
//        request.setAttribute("imgurl",hello.getClichedMessage()); // 'time' would be  shown on JSP page
//
//
//
//        RequestDispatcher view = getServletContext().getRequestDispatcher("/hello.jsp");
//        view.forward(request, response);
//    }
////    @Override
////    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        doGet(request, response);
////    }
//
//}