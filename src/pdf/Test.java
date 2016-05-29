package pdf;

import java.io.FileOutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.pdf.BaseFont;

public class Test
{
	
	public static void main(String[] args)
	{
		StringBuffer html = new StringBuffer();
		// 组装成符合W3C标准的html文件，否则不能正确解析
		html.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">");
		html.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">")
				.append("<head>")
				.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />")
				.append("<style type=\"text/css\" mce_bogus=\"1\">body {font-family: SimSun;}</style>")
				.append("<style type=\"text/css\">img {width: 700px;}</style>")
				.append("</head>").append("<body>");
		
		html.append("<center><h1>统计报表</h1></center>");
		html.append("<center>");
		html.append("<img src=\"images/chart.jpg\"/>");
		html.append("</center>");
		
		html.append("</body></html>");
		
		// parse our markup into an xml Document
		try
		{
			ITextRenderer renderer = new ITextRenderer();
			// 设置字体
			ITextFontResolver fontResolver = renderer.getFontResolver();
			fontResolver.addFont("C:/Windows/fonts/simsun.ttc",
					BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
			renderer.setDocumentFromString(html.toString());
			// 解决图片的相对路径问题
			// renderer.getSharedContext().setBaseURL("file:/C:/Documents and Settings/dashan.yin/workspace/createpdf/WebRoot/images");
			// renderer.getSharedContext().setBaseURL("file:/D:/apache-tomcat-6.0.26/webapps/createpdf/images");
			// renderer.getSharedContext().setBaseURL("file:/" + path +
			// "/images");
			
			renderer.layout();
			
			renderer.createPDF(new FileOutputStream("d:/abccc.pdf"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
