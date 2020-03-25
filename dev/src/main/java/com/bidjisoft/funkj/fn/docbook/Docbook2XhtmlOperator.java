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
package com.bidjisoft.funkj.fn.docbook;

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
