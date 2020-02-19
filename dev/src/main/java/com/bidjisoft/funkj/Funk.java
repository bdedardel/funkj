package com.bidjisoft.funkj;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.bidjisoft.funkj.docbook.fn.Docbook2XhtmlOperator;
import com.bidjisoft.funkj.media.Metadata;
import com.bidjisoft.funkj.media.fn.Media2MetadataFunction;
import com.bidjisoft.funkj.pdf.Pdf;
import com.bidjisoft.funkj.xhtml.Xhtml;
import com.bidjisoft.funkj.xhtml.fn.Docbook2XhtmlFunction;
import com.bidjisoft.funkj.xhtml.fn.Url2XhtmlFunction;
import com.bidjisoft.funkj.xhtml.fn.Xhtml2PdfFunction;
import com.bidjisoft.funkj.xml.Xml;

public class Funk {

	public static Xhtml<File> docbook2xhtml(final File dbkXml) {	
		Docbook2XhtmlOperator docbook2Xhtml = new Docbook2XhtmlOperator();
		File res = docbook2Xhtml.apply(dbkXml);
		return Xhtml.of(res);
	}
	
	public static Xhtml<String> docbook2xhtml(final String dbkXmlUriOrPath) {	
		Docbook2XhtmlOperator docbook2Xhtml = new Docbook2XhtmlOperator();
		File res = docbook2Xhtml.apply(new File(dbkXmlUriOrPath.replace("file://", "")));
		String content = null;
		try {
			content = FileUtils.readFileToString(new File(res.getAbsolutePath(), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Xhtml.of(content);
	}
	
}
