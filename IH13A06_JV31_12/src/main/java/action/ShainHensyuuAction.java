package action;

import org.apache.struts2.dispatcher.HttpParameters;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import form.ShainHensyuuForm;
import model.Shain;
import model.ShainDAO;

public class ShainHensyuuAction extends ActionSupport implements ModelDriven<ShainHensyuuForm> {

    private static final long serialVersionUID = 1L;
    private ShainHensyuuForm form = new ShainHensyuuForm();
    private ShainDAO dao = new ShainDAO();

    @Override
    public ShainHensyuuForm getModel() {
        return form;
    }

    @Override
    public String execute() {
        if (form.getId() == 0) {
            HttpParameters params = ActionContext.getContext().getParameters();
            if (params.get("id") != null) {
                String idStr = params.get("id").getValue();
                if (idStr != null && !idStr.isEmpty()) {
                    try {
                        form.setId(Integer.parseInt(idStr));
                    } catch (NumberFormatException e) {
                        System.out.println("無効なIDが渡されました: " + idStr);
                    }
                }
            }
        }

        // 初期表示：name が未設定なら DB から読み込み
        if (form.getId() > 0 && (form.getName() == null || form.getName().isEmpty())) {
            Shain shain = dao.findById(form.getId());
            if (shain != null) {
                form.setName(shain.getName());
                form.setGender(shain.getGender());
                form.setNote(shain.getNote());
            }

            return INPUT; // JSP 表示
        }

        // 更新処理（POST）
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

        Shain shain = dao.findById(form.getId());
        if (shain != null) {
            shain.setName(form.getName());
            shain.setGender(form.getGender());
            shain.setNote(form.getNote());
            dao.update(shain);
        }

        addActionMessage("更新が完了しました。");
        return SUCCESS;
    }
}
