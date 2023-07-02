/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package List;

import Controller.CardController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class List1 {

    private Connection conn = null;
    private PreparedStatement pat = null;

    public void setListID(int ListID) {
        this.ListID = ListID;
    }

    public void setListName(String ListName) {
        this.ListName = ListName;
    }

    public int getListID() {
        return ListID;
    }

    public String getListName() {
        return ListName;
    }

    public int getLayoutX() {
        return LayoutX;
    }

    public void setLayoutX(int LayoutX) {
        this.LayoutX = LayoutX;
    }
    private int LayoutX;
    private int ListID;
    private String ListName;

    public void setViewContainer(String viewContainer) {
        this.viewContainer = viewContainer;
    }

    public String getViewContainer() {
        return viewContainer;
    }
    private String viewContainer;

    public String getListTable(int id) {
        String z = "container" + id;
        setViewContainer(z);
        return z;

    }

    public int CountList() {
        int count = 0;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String query = "SELECT COUNT(ListID) FROM MyTable";
            pat = conn.prepareStatement(query);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

    }

    public void InsertList(int id, String title) throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();

            String sql1 = "INSERT INTO MyTable(ListID,ListName,LayoutX,CheckList) VALUES (?,?,?,?);";
            pat = conn.prepareStatement(sql1);
            pat.setInt(1, id);
            pat.setString(2, title);
            pat.setInt(3, LayoutX);
            pat.setInt(4, 1);
            pat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public boolean CheckList() {
        boolean hasLabel = false;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT COUNT(*) as count FROM MyTable WHERE CheckList = 1";
            pat = conn.prepareStatement(sql);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    hasLabel = true;
                    System.out.println("Có ít nhất một giá trị trong cột CheckList bằng 1.");
                }
            }
            System.out.println(hasLabel);
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pat != null) {
                    pat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return hasLabel;

    }

    public int MaxList() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT MAX(ListID) FROM MyTable;";
            pat = conn.prepareStatement(sql);
            ResultSet rs = pat.executeQuery();
            int maxId = 0;
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
            return maxId;
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        return 0;
    }

    public int MaxLayoutX() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT MAX(LayoutX) FROM MyTable;";
            pat = conn.prepareStatement(sql);
            ResultSet rs = pat.executeQuery();
            int maxId = 0;
            if (rs.next()) {
                maxId = rs.getInt(1) + 215;
            }
            return maxId;
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        return 0;
    }

    public int SeLectLayoutX() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT MAX(LayoutX) FROM MyTable WHERE ListID=?;";
            pat = conn.prepareStatement(sql);
            pat.setInt(1, ListID);
            ResultSet rs = pat.executeQuery();
            int maxId = 0;
            if (rs.next()) {
                maxId = rs.getInt(1);
            }
            return maxId;
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        return 0;
    }

    public String SelectName() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT ListName FROM MyTable WHERE ListID=?;";
            pat = conn.prepareStatement(sql);
            pat.setInt(1, ListID);
            ResultSet rs = pat.executeQuery();
            String maxId = "";
            if (rs.next()) {
                maxId = rs.getString(1);
            }
            return maxId;
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
        return null;

    }

    public void DeleteList() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"

            String theQuery4 = "DELETE FROM Label WHERE IDList=? ";
            pat = conn.prepareStatement(theQuery4);
            pat.setInt(1, ListID);
            pat.executeUpdate();
            String theQuery2 = "DELETE FROM Mota_ChiTiet WHERE IDList=? ";
            pat = conn.prepareStatement(theQuery2);
            pat.setInt(1, ListID);
            pat.executeUpdate();
            String theQuery3 = "DELETE FROM The WHERE IDList=? ";
            pat = conn.prepareStatement(theQuery3);
            pat.setInt(1, ListID);
            pat.executeUpdate();
            String theQuery = "DELETE FROM MyTable WHERE ListID=? ";
            pat = conn.prepareStatement(theQuery);
            pat.setInt(1, ListID);
            pat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean CheckListSQL(int id) {
        boolean hasLabel = false;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT COUNT(*) as count FROM MyTable WHERE ListID = ?";
            pat = conn.prepareStatement(sql);
            pat.setInt(1, id);
            ResultSet rs = pat.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    hasLabel = true;
                    System.out.println("Có tồn tại giá trị với ID = " + id + " trong cột 'ListID'.");
                } else {
                    System.out.println("Không tồn tại giá trị với ID = " + id + " trong cột 'ListID'.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pat != null) {
                    pat.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return hasLabel;

    }

    public void DeleteCard() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"

            String theQuery4 = "DELETE FROM Label WHERE IDList=? ";
            pat = conn.prepareStatement(theQuery4);
            pat.setInt(1, ListID);
            pat.executeUpdate();
            String theQuery2 = "DELETE FROM Mota_ChiTiet WHERE IDList=? ";
            pat = conn.prepareStatement(theQuery2);
            pat.setInt(1, ListID);
            pat.executeUpdate();
            String theQuery3 = "DELETE FROM The WHERE IDList=? ";
            pat = conn.prepareStatement(theQuery3);
            pat.setInt(1, ListID);
            pat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
