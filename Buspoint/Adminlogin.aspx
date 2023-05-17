<%@ Page Language="C#" MasterPageFile="~/home.master" EnableEventValidation="false" AutoEventWireup="true" CodeFile="Adminlogin.aspx.cs" Inherits="Adminlogin" Title="Untitled Page" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <br />
<div align=center>
    <asp:Panel ID="Panel1" runat="server" BackColor="#FF6600">
<table>
<tr>
<td style="text-align: center">
    <b>Admin Login</b>
</td>
</tr>
</table>
  
<table cellpadding="5" cellspacing="5">
<tr>
<td>
    <asp:Label ID="Label1" runat="server" Text="User Name"></asp:Label>
</td>
<td>
    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
</td>
</tr>
<tr>
<td>
    <asp:Label ID="Label2" runat="server" Text="Password"></asp:Label>
</td>
<td>
    <asp:TextBox ID="TextBox2" runat="server" TextMode="Password"></asp:TextBox>
</td>
</tr>
</table>
<table>
<tr>
<td>
    <asp:Button ID="Button1" runat="server" Text="Login" onclick="Button1_Click" />
</td>
</tr>
</table>
    </asp:Panel>
</div>
</asp:Content>

