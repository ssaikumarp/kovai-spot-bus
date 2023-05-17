<%@ Page Language="C#" MasterPageFile="~/Admin.master" AutoEventWireup="true" CodeFile="citybus.aspx.cs" Inherits="citybus" Title="Untitled Page" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <br />
  <div align=center>
 
<br />
<table>
<tr>
<td>
    <asp:Label ID="Label3" runat="server" Text="Route Details" Font-Bold="True"></asp:Label>
</td>
   
</tr>
</table>

<br />

<table cellpadding="5" cellspacing="5" width="300">
<tr>
<td>
    <asp:Label ID="Label1" runat="server" Text="Busno" Font-Bold="True"></asp:Label>
</td>
<td>
    <asp:TextBox ID="TextBox1" runat="server" Width="200px"></asp:TextBox>
</td>

</tr>
<tr>
<td>
    <asp:Label ID="Label10" runat="server" Text="From" Font-Bold="True"></asp:Label>
</td>
<td>
    <asp:DropDownList ID="DropDownList1" runat="server" Width="200px">
    </asp:DropDownList>
</td>

</tr>
<tr>
<td>
    <asp:Label ID="Label11" runat="server" Text="To" Font-Bold="True"></asp:Label>
</td>
<td>
    <asp:DropDownList ID="DropDownList2" runat="server" Width="200px">
    </asp:DropDownList>
</td>

</tr>
<tr>
<td>
    <asp:Label ID="Label6" runat="server" Text="Time" Font-Bold="True"></asp:Label>
</td>
<td>
    <asp:TextBox ID="TextBox4" runat="server"  Width="200px"></asp:TextBox>
</td>

</tr>


</table>
<table>
<tr>
<td>
    <asp:Button ID="Button3" runat="server" Text="Submit" onclick="Button2_Click" />
</td>
</tr>
</table>
<br />
      <asp:GridView ID="GridView3" runat="server" CellPadding="4" ForeColor="#333333" 
          GridLines="None" onrowdeleting="GridView3_RowDeleting" Width="600px" 
          onselectedindexchanging="GridView3_SelectedIndexChanging">
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

