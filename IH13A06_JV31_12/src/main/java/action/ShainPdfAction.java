package action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import form.ShainPdfForm;
import model.Shain;
import model.ShainDAO;

public class ShainPdfAction extends ActionSupport implements ModelDriven<ShainPdfForm> {

    private static final long serialVersionUID = 1L;
    private ShainPdfForm form = new ShainPdfForm();
    private ShainDAO dao = new ShainDAO();

    @Override
    public ShainPdfForm getModel() {
        return form;
    }

    @Override
    public String execute() throws Exception {
        // --- DAOで社員検索 ---
        List<Shain> shainList = dao.search(form.getName(), form.getGender(), form.getNote(), form.getSort(), form.getOrder());

        // --- PDF出力 ---
        HttpServletResponse resp = ServletActionContext.getResponse();
        resp.setContentType("application/pdf");

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = "shain_list_" + timeStamp + ".pdf";
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        PdfWriter writer = new PdfWriter(resp.getOutputStream());
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        String fontPath = "C:/Windows/Fonts/meiryo.ttc,0";
        document.setFont(PdfFontFactory.createFont(fontPath));
        document.add(new Paragraph("社員一覧")
                .setFontSize(16)
                .setBold()
                .setTextAlignment(TextAlignment.CENTER)
                .setMarginBottom(20f));

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

        return null; // PDFを直接返す場合は result は不要
    }
}
