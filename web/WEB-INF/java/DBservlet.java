import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DBServlet", urlPatterns = "/oy")
public class DBservlet extends HttpServlet {


private restClient client;


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        client = new restClient();
        int listSize = client.getList().size();
        List<String> myList=client.full;
        String listItem="";

     //   String listItem=myList.toString();
        response.setContentType("text/html");
        for(int i = 0; i<listSize; i++){
            listItem ="<li>" +client.full.get(i)+"</li>";// <<<< this doesnt wotk fix it
            request.setAttribute("listicle", listItem);
            request.getRequestDispatcher("list.jsp").include(request, response);
        }
        client = new restClient();
        String name= request.getParameter("name");
        String addr= request.getParameter("address");
        String Idd= request.getParameter("Id");
        request.getRequestDispatcher("button.jsp").include(request, response);
        if (request.getParameter("add") != null) {

            client.restPost(name,addr);
            response.setIntHeader("Refresh",0);


        }

            else if (request.getParameter("update")!=null) {
            client.restUpdate(Idd, name, addr);
            response.setIntHeader("Refresh",0);


        }
                else if(request.getParameter("delete")!=null){
                    client.restDelete(Idd);
            response.setIntHeader("Refresh",0);


    }




    }

}
