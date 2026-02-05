package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import model.Shain;
import model.ShainDAO;

public class ShainPdfController implements Controller {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String method = req.getMethod();

        if ("GET".equalsIgnoreCase(method)) {

            // --- DAO で社員データ検索 ---
            ShainDAO dao = new ShainDAO();
            String name = req.getParameter("name");
            String gender = req.getParameter("gender");
            String note = req.getParameter("note");
            String sort = req.getParameter("sort");
            String order = req.getParameter("order");

            List<Shain> shainList = dao.search(name, gender, note, sort, order);

            // --- 保存先とファイル名作成 ---
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "shain_list_" + timeStamp + ".pdf";
            String saveDir = req.getServletContext().getRealPath("/pdf");
            File dir = new File(saveDir);
            if (!dir.exists()) dir.mkdirs();  // フォルダ作成
            String filePath = saveDir + File.separator + fileName;

            resp.setContentType("application/pdf");
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

            PdfWriter writer = new PdfWriter(resp.getOutputStream());
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);
            
            String fontPath = "C:/Windows/Fonts/meiryo.ttc,0";
            document.setFont(PdfFontFactory.createFont(fontPath));
            document.add(new Paragraph("社員一覧").setFontSize(16).setBold().setTextAlignment(TextAlignment.CENTER).setMarginBottom(20f));

            float[] columnWidths = {50f, 120f, 50f, 200f};
            Table table = new Table(columnWidths).setWidth(UnitValue.createPercentValue(100));

            table.addHeaderCell(new Cell().add(new Paragraph("社員ID").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            table.addHeaderCell(new Cell().add(new Paragraph("氏名").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            table.addHeaderCell(new Cell().add(new Paragraph("性別").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            table.addHeaderCell(new Cell().add(new Paragraph("備考").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY));

            for (Shain s : shainList) {
                table.addCell(String.valueOf(s.getId()));
                table.addCell(s.getName());
                table.addCell("M".equals(s.getGender()) ? "男性" : "女性");
                table.addCell(s.getNote() != null ? s.getNote() : "");
            }

            document.add(table);
            document.close();
        }
    }
}
