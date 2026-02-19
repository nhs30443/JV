package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import form.ShainTourokuForm;
import model.Shain;
import model.ShainDAO;

public class ShainTourokuAction extends ActionSupport implements ModelDriven<ShainTourokuForm> {
    private static final long serialVersionUID = 1L;

    private ShainTourokuForm form = new ShainTourokuForm();

    @Override
    public ShainTourokuForm getModel() {
        return form;
    }

    @Override
    public String execute() {
        if (form.getName() == null || form.getName().trim().isEmpty()) {
            form.setErrorMessage("氏名を入力してください。");
            return INPUT;
        }

        if (form.getGender() == null || !(form.getGender().equals("M") || form.getGender().equals("F"))) {
            form.setErrorMessage("性別を選択してください。");
            return INPUT;
        }

        if (form.getNote() == null) {
            form.setNote("");
        }

        Shain shain = new Shain();
        shain.setName(form.getName());
        shain.setGender(form.getGender());
        shain.setNote(form.getNote());

        ShainDAO dao = new ShainDAO();
        dao.save(shain);

        return SUCCESS;
    }
}
