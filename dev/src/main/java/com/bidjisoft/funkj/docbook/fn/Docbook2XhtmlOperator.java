package com.bidjisoft.funkj.docbook.fn;

import java.io.File;
import java.util.function.UnaryOperator;

public class Docbook2XhtmlOperator implements UnaryOperator<File> {

	@Override
	public File apply(File docbookXml) {
		DocbookOperator docbookTransformer = new DocbookOperator();
		String userPath = System.getProperty("user.home");
		return docbookTransformer.apply(docbookXml, new File(userPath + File.separator + ".ant4docbook" + File.separator + "docbook-xslt2-2.4.3/xslt/base/pipelines/db2html.xpl"));
	}

}
