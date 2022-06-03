

<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    String id = request.getParameter("id");

    String connectionURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
    String user = "root";
    String pass = "Root1234";

    Connection con = null;

    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(connectionURL, user, pass);

        PreparedStatement ps = con.prepareStatement("select * from image where id=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            Blob blob = rs.getBlob("photo");
            int x = rs.getInt("id");
            byte byteArray[] = blob.getBytes(1, (int)blob.length());
            response.setContentType("image/gif");
            OutputStream os = response.getOutputStream();
            os.write(byteArray);
            os.write(x);
            System.out.println(x);

            os.flush();
            os.close();
        }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    finally{
        if(con != null){
            try{
                con.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
%>
