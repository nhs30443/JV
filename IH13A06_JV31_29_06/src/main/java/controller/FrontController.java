package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    // URL → Controllerオブジェクト のマッピング
    private Map<String, Controller> routes = new HashMap<>();

    @Override
    public void init() throws ServletException {
        // リクエストURLごとの処理を登録
        routes.put("/app/shain_touroku", new ShainTourokuController());
        routes.put("/app/shain_itirann", new ShainItirannController());
        routes.put("/app/shain_hensyuu", new ShainHensyuuController());
        routes.put("/app/shain_sakujyo", new ShainSakujyoController());
        routes.put("/app/complete", new CompleteController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String uri = request.getRequestURI();
    	String context = request.getContextPath();
    	String path = uri.substring(context.length());

        Controller controller = routes.get(path);

        if (controller != null) {
            controller.execute(request, response);
        } else {
            // 対応するControllerがなければ404
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "ページが見つかりません");
        }
    }
}
