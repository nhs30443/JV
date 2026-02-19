package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import form.ShainSearchForm;
import model.Shain;
import model.ShainDAO;

public class ShainItirannAction extends ActionSupport implements ModelDriven<ShainSearchForm> {
    private static final long serialVersionUID = 1L;

    // Struts2が直接ここへ値を注入する
    private ShainSearchForm form = new ShainSearchForm();
    
    private List<Shain> shainList;

    @Override
    public ShainSearchForm getModel() {
        return form;
    }

    // JSP表示用
    public List<Shain> getShainList() {
        return shainList;
    }

    @Override
    public String execute() {

        ShainDAO dao = new ShainDAO();

        shainList = dao.search(
                form.getName(),
                form.getGender(),
                form.getNote(),
                form.getSort(),
                form.getOrder()
        );

        // ここで gender を文字列に変換しておく
        for (Shain s : shainList) {
            String gender = s.getGender(); // M or F
            if ("M".equals(gender)) {
                s.setGender("男性");
            } else if ("F".equals(gender)) {
                s.setGender("女性");
            }
        }

        return SUCCESS;
    }
}
