package com.bidjisoft.funkj.docbook.fn;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

import net.sf.saxon.s9api.SaxonApiException;

// see: http://tutorials.jenkov.com/java-functional-programming/functional-interfaces.html
public class DocbookOperator implements BinaryOperator<File> {

	private String extension = ".html";
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Override
	public File apply(File docbookXml, File docbookXsl) {	
		// java -jar docbook-xslt2-2.4.3.jar [options] dbdoc.xml [param=value [param=value] ...]
		File res = null;
		try {
			res = File.createTempFile("funkj_", extension);
			List<String> argsList = new ArrayList<String>();
			argsList.add("-o");
			argsList.add(res.getAbsolutePath());
			argsList.add(docbookXml.getAbsolutePath());
			String[] args = new String[argsList.size()];
			args = argsList.toArray(args);
			org.docbook.Main.main(args);
		} catch (IOException | SaxonApiException e) {
			e.printStackTrace();
		} 
		return res;
		
		// see also xmlcalabash
//		try {
//			File res = File.createTempFile("funkj_", ".res.dbk");
//			res.deleteOnExit();
//			List<String> args = new ArrayList<String>();
//			args.add("-isource=" + docbookXml.getAbsolutePath());
//			args.add("-oresult=" + res.getAbsolutePath());
//			//args.add(".../xslt20-stylesheets-master/build/distributions/docbook-xslt2-2.4.3/xslt/base/pipelines/db2pdf.xpl");
//			args.add(docbookXsl.getAbsolutePath());
//			com.xmlcalabash.drivers.Main.main(args.toArray(new String[args.size()]));
//			return res; // FileUtils.readFileToString(new File("/tmp/docbook2.html"), "UTF-8");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
	}



}
