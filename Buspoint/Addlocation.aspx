<%@ Page Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="Addlocation.aspx.cs" Inherits="Addlocation" Title="Untitled Page" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div align=center>
<br />
    <asp:Label ID="Label1" runat="server" Text="Add Location"></asp:Label>
<br />
<table>
<tr>
<td>
    <asp:Label ID="Label2" runat="server" Text="Busno"></asp:Label>
</td>
<td>
    <asp:DropDownList ID="DropDownList1" runat="server" Width="200px">
    </asp:DropDownList>
</td>
</tr>
<tr>
<td>
    <asp:Label ID="Label3" runat="server" Text="Latitude"></asp:Label>
</td>
<td>
    <asp:TextBox ID="TextBox1" runat="server" Width="200px"></asp:TextBox>
</td>
</tr>
<tr>
<td>
    <asp:Label ID="Label4" runat="server" Text="Longitude"></asp:Label>
</td>
<td>
    <asp:TextBox ID="TextBox2" runat="server" Width="200px"></asp:TextBox>
</td>
</tr>
</table>
    <asp:Button ID="Button1" runat="server" Text="Add" onclick="Button1_Click" />
    <br />
    
    <asp:GridView ID="GridView1" runat="server" CellPadding="4" ForeColor="#333333" 
        GridLines="None" Width="550px" onrowdeleting="GridView1_RowDeleting" 
            onselectedindexchanging="GridView1_SelectedIndexChanging">
        <RowStyle BackColor="#FFFBD6" ForeColor="#333333" />
        <Columns>
            <asp:CommandField ShowSelectButton="True" />
            <asp:CommandField ShowDeleteButton="True" />
        </Columns>
        <FooterStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
        <PagerStyle BackColor="#FFCC66" ForeColor="#333333" HorizontalAlign="Center" />
        <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="Navy" />
        <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" />
    </asp:GridView>
    <br />
    
</div>
</asp:Content>

