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
public partial class Addlocation : System.Web.UI.Page
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
            cmd = new SqlCommand("select Busno from Busroute", con);
            if (con.State == System.Data.ConnectionState.Closed)
                con.Open();
            SqlDataReader dr1 = cmd.ExecuteReader();
            while (dr1.Read())
            {
                DropDownList1.Items.Add(dr1[0].ToString());
            }
            con.Close();


          
        }
    }
    protected void Button1_Click(object sender, EventArgs e)
    {

        if (con.State == System.Data.ConnectionState.Closed)
            con.Open();

        cmd = new SqlCommand("insert into curlocation values('" + DropDownList1.Text + "','" + TextBox1.Text + "','" + TextBox2.Text + "','" + System.DateTime.Now.ToString() + "')", con);
        cmd.ExecuteNonQuery();

        con.Close();
        //Response.Write("<script>alert('successfully Addeded');</script>");
       // TextBox1.Text = "";
        Response.Redirect("Addlocation.aspx");

    }

    private void bindgrid1()
    {
        if (con.State == ConnectionState.Closed)
        {
            con.Open();
        }
        cmd = new SqlCommand("select * from curlocation", con);
        SqlDataAdapter adp = new SqlDataAdapter(cmd);
        DataSet ds = new DataSet();
        adp.Fill(ds);
        GridView1.DataSource = ds;
        GridView1.DataBind();
        if (con.State == ConnectionState.Open)
        {
            con.Close();
        }
    }
    protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
    {
        if (con.State == System.Data.ConnectionState.Closed)
            con.Open();
        try
        {
            string str = GridView1.Rows[e.RowIndex].Cells[2].Text;
            cmd = new SqlCommand("delete from curlocation where id='" + str + "'", con);
            cmd.ExecuteNonQuery();
            GridView1.EditIndex = -1;
            con.Close();
            Response.Redirect("Addlocation.aspx");
        }
        catch (Exception ex)
        {

        }
    }
    protected void GridView1_SelectedIndexChanging(object sender, GridViewSelectEventArgs e)
    {
        string godata;

        string lat = GridView1.Rows[e.NewSelectedIndex].Cells[4].Text;
        string lon = GridView1.Rows[e.NewSelectedIndex].Cells[5].Text;

        godata = "http://maps.google.com/maps?q=" + lat + "," + lon + "";

        System.Diagnostics.Process.Start(godata);
    }
}
