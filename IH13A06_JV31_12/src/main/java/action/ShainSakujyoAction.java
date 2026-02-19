package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import form.ShainSakujyoForm;
import model.ShainDAO;

public class ShainSakujyoAction extends ActionSupport implements ModelDriven<ShainSakujyoForm> {

    private static final long serialVersionUID = 1L;

    private ShainSakujyoForm form = new ShainSakujyoForm();
    private ShainDAO dao = new ShainDAO();

    @Override
    public ShainSakujyoForm getModel() {
        return form;
    }

    @Override
    public String execute() throws Exception {
        // id が有効なら削除
        if (form.getId() > 0) {
            dao.delete(form.getId());
            addActionMessage("削除が完了しました。");
        }

        return SUCCESS;  // struts.xml で一覧画面へリダイレクト設定しておく
    }
}
