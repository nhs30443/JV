package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "社員マスタ")
public class Shain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ユーザーID")
    private int id;

    @Column(name = "氏名")
    private String name;

    @Column(name = "性別")
    private String gender;

    @Column(name = "備考")
    private String note;

    public Shain() {}

    public Shain(int id, String name, String gender, String note) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.note = note;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender != null ? gender.trim() : null;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

    // 性別
    @Transient
    public String getGenderLabel() {
        if (gender == null) return "未設定";
        switch (gender.trim()) {
            case "M": return "男性";
            case "F": return "女性";
            case "O": return "その他";
            default:  return "未設定";
        }
    }
}
