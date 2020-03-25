/*
 * funkj - functional java kit.
 * Copyright 2020
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.bidjisoft.funkj;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.bidjisoft.funkj.fn.docbook.Docbook2PdfOperator;
import com.bidjisoft.funkj.fn.docbook.Docbook2XhtmlOperator;
import com.bidjisoft.funkj.monads.Pdf;
import com.bidjisoft.funkj.monads.Xhtml;
import com.bidjisoft.funkj.monads.Xml;

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
	
	public static Pdf<File> docbook2pdf(final File dbkXml) {	
		Docbook2PdfOperator docbook2Pdf = new Docbook2PdfOperator();
		File res = docbook2Pdf.apply(dbkXml);
		return Pdf.of(res);
	}
}
