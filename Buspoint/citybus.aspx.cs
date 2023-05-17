using System;
using System.Collections;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Xml.Linq;
using System.Data.SqlClient;
public partial class citybus : System.Web.UI.Page
{
    SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["conn"].ConnectionString);
    SqlCommand cmd;
    SqlDataAdapter da;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {

            bindgrid1();

            DropDownList1.Items.Clear();
            cmd = new SqlCommand("select Stops from Busstops", con);
            if (con.State == System.Data.ConnectionState.Closed)
                con.Open();
            SqlDataReader dr1 = cmd.ExecuteReader();
            while (dr1.Read())
            {
                DropDownList1.Items.Add(dr1[0].ToString());
            }
            con.Close();


            DropDownList2.Items.Clear();
            cmd = new SqlCommand("select Stops from Busstops", con);
            if (con.State == System.Data.ConnectionState.Closed)
                con.Open();
            SqlDataReader dr2 = cmd.ExecuteReader();
            while (dr2.Read())
            {
                DropDownList2.Items.Add(dr2[0].ToString());
            }
            con.Close();
        }
      
    }
  
    protected void Button2_Click(object sender, EventArgs e)
    {

        if (con.State == System.Data.ConnectionState.Closed)
            con.Open();

        cmd = new SqlCommand("insert into Busroute values('" + TextBox1.Text + "','" + DropDownList1.Text + "','" + DropDownList2.Text + "','" + TextBox4.Text + "')", con);
                    cmd.ExecuteNonQuery();

                    con.Close();
                    Response.Write("<script>alert('successfully Addeded');</script>");
                    TextBox1.Text = "";
                    Response.Redirect("citybus.aspx");
           

           
        }
   

   


    private void bindgrid1()
    {
        if (con.State == ConnectionState.Closed)
        {
            con.Open();
        }
        cmd = new SqlCommand("select * from Busroute", con);
        SqlDataAdapter adp = new SqlDataAdapter(cmd);
        DataSet ds = new DataSet();
        adp.Fill(ds);
        GridView3.DataSource = ds;
        GridView3.DataBind();
        if (con.State == ConnectionState.Open)
        {
            con.Close();
        }
    }


   
   

   

   
    
    protected void GridView3_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        if (con.State == System.Data.ConnectionState.Closed)
            con.Open();
        try
        {
            string str = GridView3.Rows[e.RowIndex].Cells[1].Text;
            cmd = new SqlCommand("delete from Busroute where id='" + str + "'", con);
            cmd.ExecuteNonQuery();
            GridView3.EditIndex = -1;
            con.Close();
            Response.Redirect("citybus.aspx");
        }
        catch (Exception ex)
        {

        }
    }
    protected void GridView3_SelectedIndexChanging(object sender, GridViewSelectEventArgs e)
    {
        string godata;

        string lat = GridView3.Rows[e.NewSelectedIndex].Cells[7].Text;
        string lon = GridView3.Rows[e.NewSelectedIndex].Cells[8].Text;

        godata = "http://maps.google.com/maps?q=" + lat + "," + lon + "";

        System.Diagnostics.Process.Start(godata);
       
    }
}

    