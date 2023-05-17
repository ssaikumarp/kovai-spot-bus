<%@ Page Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="Search.aspx.cs" Inherits="Search" Title="Untitled Page" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<div align=center>
<br />
<table>
<tr>
<td>
    <asp:Label ID="Label1" runat="server" Text="Search Here"></asp:Label>
</td>
</tr>
</table>
<br />

<table width="300" height="100">

<tr>
<td>
    <asp:Label ID="Label3" runat="server" Text="Busno"></asp:Label>
</td>
<td>
    <asp:DropDownList ID="DropDownList1" runat="server" Width="200px">
    </asp:DropDownList>
</td>
</tr>

</table>
    <asp:Button ID="Button1" runat="server" Text="Search" onclick="Button1_Click" />
<br />
<table>
<tr>
<td>
    <asp:GridView ID="GridView1" runat="server" CellPadding="4" ForeColor="#333333" 
        GridLines="None" Width="600px" 
        onselectedindexchanging="GridView1_SelectedIndexChanging">
        <Columns>
            <asp:CommandField ShowSelectButton="True" />
        </Columns>
        <FooterStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
        <RowStyle BackColor="#FFFBD6" ForeColor="#333333" />
        <PagerStyle BackColor="#FFCC66" ForeColor="#333333" HorizontalAlign="Center" />
        <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="Navy" />
        <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" />
    </asp:GridView>
</td>
</tr>
</table>
<br />
</div>
</asp:Content>

