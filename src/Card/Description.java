/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Card;

public class Description {

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public double getSize() {
        return size;
    }

    public String getFont() {
        return font;
    }

    public boolean isInDam() {
        return InDam;
    }

    public void setInDam(boolean InDam) {
        this.InDam = InDam;
    }

    private boolean InDam;
    private int id;
    private String content;
    private double size;
    private String font;

    public Description(int id, String content, double size, String font, boolean InDam) {
        this.id = id;
        this.content = content;
        this.size = size;
        this.font = font;
        this.InDam = InDam;
    }

}
