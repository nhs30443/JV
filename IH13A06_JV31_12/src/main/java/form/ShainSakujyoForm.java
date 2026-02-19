package form;

import java.io.Serializable;

public class ShainSakujyoForm implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;  // 削除対象の社員ID

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
