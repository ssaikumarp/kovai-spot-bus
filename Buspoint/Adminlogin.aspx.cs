﻿using System;
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

public partial class Adminlogin : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        if (TextBox1.Text == "admin" || TextBox2.Text == "admin")
        {
            Response.Write("<script>alert('Login success');</script>");
            Response.Redirect("Adminhome.aspx");
        
        }
        else
        {
            Response.Write("<script>alert('Login Failed');</script>");
            TextBox1.Text = "";
            TextBox2.Text = "";
         }

    }
}
