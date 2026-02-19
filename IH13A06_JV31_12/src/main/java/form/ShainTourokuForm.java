package form;

import java.io.Serializable;

public class ShainTourokuForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;     // 氏名
    private String gender;   // 性別
    private String note;     // 備考
    private String errorMessage;

    // getter / setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
}
