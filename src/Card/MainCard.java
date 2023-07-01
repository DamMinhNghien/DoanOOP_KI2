/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Card;

import Controller.CardController;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MainCard {

    public int IDCard;
    public String title;
    public Description description;
    private Date dueDate;

    private LabelCard labels;
    private List<Attachment> attachments;
    private List<Comment> comments;
    private boolean archived;

    public MainCard() {

        this.description = new Description(1, "", 2, "", false);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public LabelCard getLabels() {
        return labels;
    }

    public void setLabels(LabelCard labels) {
        this.labels = labels;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void addAttachment(Attachment attachment) {
        this.attachments.add(attachment);
    }

    public void removeAttachment(Attachment attachment) {
        this.attachments.remove(attachment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }

    public boolean isArchived() {
        return archived;
    }

    public void archive() {
        archived = true;
    }

    public void unarchive() {
        archived = false;
    }
    private Connection conn = null;
    private PreparedStatement pat = null;

    public void IDTitleDB(int id, String title) throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();

            String sql1 = "INSERT INTO The(IDCard,title) VALUES (?,?);";
            pat = conn.prepareStatement(sql1);
            pat.setInt(1, id);
            pat.setString(2, title);
            pat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public int MaxID() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT MAX(IDCard) FROM The;";
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

    public void TitleDB(String title, int id) throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();

            String sql1 = "UPDATE The SET title = ? WHERE IDCard = ?;";
            pat = conn.prepareStatement(sql1);
            pat.setString(1, title);
            pat.setInt(2, id);
            pat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public boolean checkTitle() {
        boolean hasTitle = false;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT Title FROM The WHERE IDCard = ?";
            pat = conn.prepareStatement(sql);
            pat.setInt(1, IDCard);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                this.title = rs.getString("Title");

                if (this.title != null) {
                    hasTitle = true;
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
        return hasTitle;
    }

    public void DesDB() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"
            String theQuery = "UPDATE The SET description = ? WHERE IDCard = ?";
            pat = conn.prepareStatement(theQuery);
            pat.setString(1, description.getContent());
            pat.setInt(2, IDCard);
            pat.executeUpdate();

            // Chèn dữ liệu vào bảng "Mota_ChiTiet"
            String motaQuery = "INSERT INTO Mota_ChiTiet ( SizeChu, FontChu,TheID,IsBold,ID) VALUES (?,?,?, ?, ?)";
            pat = conn.prepareStatement(motaQuery);
            pat.setInt(5, description.getId());
            pat.setInt(3, IDCard);
            pat.setDouble(1, description.getSize());
            pat.setString(2, description.getFont());
            pat.setBoolean(4, description.isInDam());
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

    public int getNewID() throws SQLException {
        int newID = 0;
        try (Connection conn = Conection.ConnectionDB.dbConn(); PreparedStatement stmt = conn.prepareStatement("SELECT MAX(ID) FROM Mota_ChiTiet")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                newID = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return newID;
    }

    public void DesDB1() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"
            String theQuery = "UPDATE The SET description = ? WHERE IDCard = ?";
            pat = conn.prepareStatement(theQuery);
            pat.setString(1, description.getContent());
            pat.setInt(2, IDCard);

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

    public void UpdateDes() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"
            String theQuery = "UPDATE Mota_ChiTiet SET SizeChu=?, FontChu=?, IsBold=? WHERE TheID=?";
            pat = conn.prepareStatement(theQuery);
            pat.setDouble(1, description.getSize());
            pat.setString(2, description.getFont());
            pat.setBoolean(3, description.isInDam());
            pat.setInt(4, IDCard);

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

    public void Deletedes() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"
            String theQuery = "DELETE FROM Mota_ChiTiet WHERE TheID=?";
            pat = conn.prepareStatement(theQuery);
            pat.setInt(1, IDCard);
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

    public boolean CheckDes() {

        boolean hasTitle = false;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT description FROM The WHERE IDCard = ?";
            pat = conn.prepareStatement(sql);
            pat.setInt(1, IDCard);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                String description = rs.getString("description");
                if (description != null && !description.isEmpty()) {
                    this.description.setContent(description);
                    hasTitle = true;

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
        return hasTitle;

    }

    public boolean CheckLabelDem() {
        boolean hasLabel = false;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT Dem FROM The WHERE IDCard = ?";
            pat = conn.prepareStatement(sql);
            pat.setInt(1, IDCard);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                Integer Dem = rs.getInt("Dem");
                if (rs.wasNull()) {

                    hasLabel = true;

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

    public int getNewDem() throws SQLException {
        int count = 0;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String query = "SELECT COUNT(LabelID) FROM Label WHERE Label_The_ID=?";
            pat = conn.prepareStatement(query);
            pat.setInt(1, IDCard);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public int getMaxDem() throws SQLException {
        int MaxDem = 0;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"
            String theQuery = "SELECT MAX(LabelID) FROM Label WHERE Label_The_ID=? ";
            pat = conn.prepareStatement(theQuery);
            pat.setInt(1, IDCard);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                MaxDem = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return MaxDem;
    }

    public int getMinDem() throws SQLException {
        int MinDem = 0;
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"
            String theQuery = "SELECT MIN(LabelID) FROM Label WHERE Label_The_ID=?";
            pat = conn.prepareStatement(theQuery);
            pat.setInt(1, IDCard);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                MinDem = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return MinDem;
    }

    public void UpdateDem() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            // Chèn dữ liệu vào bảng "The"
            String theQuery = "UPDATE The SET Dem = ? WHERE IDCard = ?";
            pat = conn.prepareStatement(theQuery);
            pat.setInt(1, 1);
            pat.setInt(2, IDCard);

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

    public void InsertLabel() throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();

            String sql1 = "INSERT INTO Label(labelID,Label_The_ID,color,LabelName,CheckBox) VALUES (?,?,?,?,?);";
            pat = conn.prepareStatement(sql1);
            pat.setInt(1, labels.getIDDem());
            pat.setInt(2, IDCard);
            pat.setString(3, labels.getColor());
            pat.setString(4, labels.getName());
            pat.setString(5, "khong");
            pat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public void getLabel(int number) throws SQLException {
        try {
            conn = Conection.ConnectionDB.dbConn();
            String sql1 = ("SELECT color, LabelName FROM Label WHERE LabelID = ? AND Label_The_ID = ?");
            pat = conn.prepareStatement(sql1);
            pat.setInt(1, number);
            pat.setInt(2, IDCard);
            ResultSet rs = pat.executeQuery();
            while (rs.next()) {
                labels.setColor(rs.getString("color"));
                labels.setName(rs.getString("LabelName"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    public void InsertCheckBox(String color, int number) throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql1 = "UPDATE Label SET CheckBox=? WHERE LabelID=? AND Label_The_ID=? ";
            pat = conn.prepareStatement(sql1);
            pat.setString(1, color);
            pat.setInt(2, number);
            pat.setInt(3, IDCard);
            pat.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public String getLabelColor() {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql = "SELECT CheckBox FROM Label WHERE Label_The_ID=?  AND CheckBox <> ?";
            pat = conn.prepareStatement(sql);
            pat.setInt(1, IDCard);
            pat.setString(2, "khong");
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                String checkbox = rs.getString("CheckBox");
                return checkbox;

            } else {
                return "khong";
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
        return null;

    }

    public void UnCheckBox(String color, int number) throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql1 = "UPDATE Label SET CheckBox=? WHERE LabelID=? AND Label_The_ID=?";
            pat = conn.prepareStatement(sql1);
            pat.setString(1, "khong");
            pat.setInt(2, number);
            pat.setInt(3, IDCard);
            pat.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public void UpdateLabel(String color, String name, int number) throws SQLException {
        try {
            conn = (Connection) Conection.ConnectionDB.dbConn();
            String sql1 = "UPDATE Label SET color=?, LabelName=? WHERE LabelID=? AND Label_The_ID=? ";
            pat = conn.prepareStatement(sql1);
            pat.setString(1, color);
            pat.setString(2, name);
            pat.setInt(3, number);
            pat.setInt(4, IDCard);
            pat.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CardController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conn.close();
        }
    }

    public void initialize(URL url, ResourceBundle rb) {

    }
}
