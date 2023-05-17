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
public partial class Addroute : System.Web.UI.Page
{
    SqlConnection con = new SqlConnection(ConfigurationManager.ConnectionStrings["conn"].ConnectionString);
    SqlCommand cmd;
    SqlDataAdapter da;
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {

            bindgrid1();
        }
      
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        if (con.State == System.Data.ConnectionState.Closed)
            con.Open();

        cmd = new SqlCommand("insert into Busstops values('" + TextBox1.Text + "')", con);
        cmd.ExecuteNonQuery();

        con.Close();
        Response.Write("<script>alert('successfully Addeded');</script>");
        TextBox1.Text = "";
        Response.Redirect("Addroute.aspx");
    }
    protected void GridView3_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        if (con.State == System.Data.ConnectionState.Closed)
            con.Open();
        try
        {
            string str = GridView3.Rows[e.RowIndex].Cells[1].Text;
            cmd = new SqlCommand("delete from Busstops where id='" + str + "'", con);
            cmd.ExecuteNonQuery();
            GridView3.EditIndex = -1;
            con.Close();
            Response.Redirect("Addroute.aspx");
        }
        catch (Exception ex)
        {

        }
    }

    private void bindgrid1()
    {
        if (con.State == System.Data.ConnectionState.Closed)
            con.Open();
        cmd = new SqlCommand("select * from Busstops", con);
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
}
