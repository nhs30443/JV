import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class HelloPDF {
	public static void main(String[] args) throws Exception {
		PdfWriter writer = new PdfWriter("sample.pdf");
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);
		
		document.add(new Paragraph("Hello iText"));
		document.close();
	}
}
