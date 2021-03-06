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

import static org.junit.Assert.assertTrue;

import java.io.File;


import org.apache.commons.io.FileUtils;

import com.bidjisoft.funkj.monads.Pdf;

public class Main {

	public static void main(String[] args) {
		final File docbookXml = FileUtils.getFile("src","test", "resources", "docbook", "example1.xml");
		Pdf<File> pdf = Funk.docbook2pdf(docbookXml);
		assertTrue(pdf.isPresent());		
		System.out.println("docbook2pdf => " + pdf.get().getAbsolutePath());
	}
}
