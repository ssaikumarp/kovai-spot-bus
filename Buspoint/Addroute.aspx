<%@ Page Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="Addroute.aspx.cs" Inherits="Addroute" Title="Untitled Page" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div align=center>
<br />

    <asp:Label ID="Label1" runat="server" Text="Add Route Here"></asp:Label>
<br />

<table width="300">
<tr>
<td>
    <asp:Label ID="Label2" runat="server" Text="Route" Font-Bold="True"></asp:Label>
</td>
<td>
    <asp:TextBox ID="TextBox1" runat="server" Width="200px"></asp:TextBox>
</td>
</tr>
</table>
    <asp:Button ID="Button1" runat="server" Text="Save" onclick="Button1_Click" />
    
    <br />
    
       <asp:GridView ID="GridView3" runat="server" CellPadding="4" ForeColor="#333333" 
          GridLines="None" onrowdeleting="GridView3_RowDeleting" Width="600px">
          <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
          <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
          <Columns>
              <asp:CommandField ShowDeleteButton="True" />
          </Columns>
          <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
          <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
          <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
          <EditRowStyle BackColor="#999999" />
          <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
      </asp:GridView>
      <br />
</div>
</asp:Content>

