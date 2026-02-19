package form;

import java.io.Serializable;

public class ShainPdfForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String gender;
    private String note;
    private String sort;
    private String order;

    // --- getter / setter ---
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }

    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }
}
