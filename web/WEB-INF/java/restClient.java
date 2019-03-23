


import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/")

public class restClient {

    DBClient db = new DBClient();
    Connection conn = db.getConn();
    Statement stmt;
    String sql;
    int Id;
    String name="anotherone";
    String addr="two";
    List<String> full = new ArrayList<String>();
    @Path("/post/{name}/{addr}")
   // @POST
    @GET
    @Produces("text/plain")
    public void restPost(
            @PathParam("name")String name,
            @PathParam("addr")String addr)
    {



        try {

          //  stmt = conn.createStatement();
            //String sqlQuery = "GET * FROM DATABAE NAME ";
            //String sqlQuery = ;


            PreparedStatement preparedStmt = conn.prepareStatement("insert into users ( UserName , Address) values ( ?,?)");
           // preparedStmt.setInt(1, );
            preparedStmt.setString (1, name);

            preparedStmt.setString (2, addr);


            // execute the preparedstatement
            preparedStmt.executeUpdate();

            //stmt.execute(sqlQuery);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }


    }
    @Path("/get")
    @GET
    @Produces("text/plain")
   // public String[] getList(@PathParam("Id")String Ids){
    public List<String> getList(){



        try {
//            conn.close();
            stmt = conn.createStatement();

            sql="SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);


            while(rs.next()) {

                Id  = rs.getInt("Id");
                name = rs.getString("UserName");
                addr = rs.getString("Address");
               full.add(Id+" "+name+" "+addr);

            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        if(preparedStmt.next()) {
//            int id = rs.getInt("first_column_name");
//            String str1 = rs.getString("second_column_name");
//        }
return full;
    }
    @Path("/delete/{Id}")
    //@DELETE
    @GET

    public void restDelete(@PathParam("Id") String Id){


        try {

            stmt = conn.createStatement();
            sql="DELETE FROM users where Id ="+Id;
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    @Path("/update/{Id}/{name}/{addr}")
    //@PUT
    @GET
    @Produces("text/plain")
    public void restUpdate(
            @PathParam("Id")String Id,
            @PathParam("name")String name,
            @PathParam("addr")String addr

    ){
        try {
            stmt = conn.createStatement();
          //  sql="UPDATE users SET UserName="+name+", Address="+addr+" where Id="+Id;
            sql="UPDATE users SET UserName = \""+name+"\", Address = \""+addr+"\" where Id="+Id;
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}

