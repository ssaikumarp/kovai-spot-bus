using System;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Xml.Linq;
using System.Data.SqlClient;
using System.IO;
using System.Data;
using System.Net;


using System.Data.SqlClient;
using System.IO;
using System.Data;
using System.Net;
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class Service : System.Web.Services.WebService
{
    SqlConnection con = new SqlConnection("server=.\\sqlexpress;database=Citybusapp;Integrated security=true;");
    SqlCommand cmd;
    String Cdate;
    public Service()
    {

        //Uncomment the following line if using designed components 
        //InitializeComponent(); 
    }



    //[WebMethod]
    //public String Citydetails(String res)
    //{
    //    String Result = "";
    //    if (con.State == System.Data.ConnectionState.Closed) con.Open();
    //    cmd = new SqlCommand("select city from city", con);
    //    SqlDataReader dr;
    //    dr = cmd.ExecuteReader();
    //    while (dr.Read())
    //    {
    //        Result += dr[0].ToString() + "#";

    //    }
    //    dr.Close();
    //    con.Close();
    //    return Result;

    //}

    //[WebMethod]
    //public String Viewroute(String res)
    //{
    //    String Result = "";
    //    if (con.State == System.Data.ConnectionState.Closed) con.Open();
    //    cmd = new SqlCommand("select Places from route where City='" + res + "'", con);
    //    SqlDataReader dr;
    //    dr = cmd.ExecuteReader();
    //    while (dr.Read())
    //    {
    //        Result +=  dr[0].ToString() + "#";

    //    }
    //    dr.Close();
    //    con.Close();
    //    return Result;

    //}


    [WebMethod]
    public String routeview(String res)
    {
        String Result = "";
        if (con.State == System.Data.ConnectionState.Closed) con.Open();
        cmd = new SqlCommand("select Stops from Busstops", con);
        SqlDataReader dr;
        dr = cmd.ExecuteReader();
        while (dr.Read())
        {
            Result += dr[0].ToString() + "#";

        }
        dr.Close();
        con.Close();
        return Result;

    }

     [WebMethod]
    public String Busroutedetails(String Source, String Destination)
     {
         String Result = "";
         if (con.State == System.Data.ConnectionState.Closed) con.Open();
         cmd = new SqlCommand("select * from Busroute where Frombus='" + Source + "' and ToBus='" + Destination + "'", con);
         SqlDataReader dr;
         dr = cmd.ExecuteReader();
         while (dr.Read())
         {
             Result += dr[1].ToString() + "," + dr[2].ToString() + "," + dr[3].ToString() + "," + dr[4].ToString() + "#";

         }
         dr.Close();
         con.Close();
         return Result;

     }


     [WebMethod]
     public String Busdetails(String Busno)
     {
         String Result = "";
         if (con.State == System.Data.ConnectionState.Closed) con.Open();
         cmd = new SqlCommand("select * from Busroute where Busno='" + Busno + "'", con);
         SqlDataReader dr;
         dr = cmd.ExecuteReader();
         while (dr.Read())
         {
             Result += dr[5].ToString() + "," + dr[6].ToString() + "#";

         }
         dr.Close();
         con.Close();
         return Result;

     }

     [WebMethod]
     public string Viewbus(string res)
     {

         string Result = "";

         if (con.State == System.Data.ConnectionState.Closed) con.Open();
         cmd = new SqlCommand("select Busno from curlocation", con);
         //cmd = new SqlCommand("select * from Attendance", con);
         SqlDataReader dr;
         dr = cmd.ExecuteReader();
         while (dr.Read())
         {
             Result += dr[0].ToString() + "#";

         }
         dr.Close();

         con.Close();

         return Result;

     }

     [WebMethod]
     public string Viewbusall(string res)
     {

         string Result = "";

         if (con.State == System.Data.ConnectionState.Closed) con.Open();
         cmd = new SqlCommand("select Busno from Busroute", con);
         //cmd = new SqlCommand("select * from Attendance", con);
         SqlDataReader dr;
         dr = cmd.ExecuteReader();
         while (dr.Read())
         {
             Result += dr[0].ToString() + "#";

         }
         dr.Close();

         con.Close();

         return Result;

     }

     [WebMethod]
     public String getlocation(String p1)
     {
         String s = "";
         if (con.State == ConnectionState.Closed)
             con.Open();

         cmd = new SqlCommand("select latitude,longitude from curlocation where Busno='" + p1 + "'", con);
         SqlDataReader dr = cmd.ExecuteReader();
         if (dr.Read())
         {
             s = "http://maps.google.com/maps?q=" + dr[0].ToString() + "," + dr[1].ToString() + "";
         }
         else
         {
             s = "not OK";
         }
         dr.Close();
         return s;
     }


     [WebMethod]
     public String updatelocation(String p1, String p2, String p3)
     {
         String s = "";
         if (con.State == ConnectionState.Closed)
             con.Open();
         cmd = new SqlCommand("delete from curlocation where Busno='" + p1 + "'", con);
         cmd.ExecuteNonQuery();
         cmd = new SqlCommand("insert into curlocation values ('" + p1 + "','" + p2 + "','" + p3 + "','" + System.DateTime.Now.ToString() + "')", con);
         cmd.ExecuteNonQuery();   
         s = "ok";
         return s;
     }

        


}
