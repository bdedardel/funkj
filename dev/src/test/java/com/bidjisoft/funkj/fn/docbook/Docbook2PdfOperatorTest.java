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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.BuildException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bidjisoft.funkj.Funk;
import com.bidjisoft.funkj.monads.Pdf;

import de.redsix.pdfcompare.CompareResult;
import de.redsix.pdfcompare.PdfComparator;

public class Docbook2PdfOperatorTest {

	@BeforeAll
    static void initAll() {

    }
	
	@BeforeEach
    void init() {
    }
	
	@Test
	public void testDocbook2pdf() {
		final File docbookXml = FileUtils.getFile("src","test", "resources", "docbook", "example1.xml");
		Pdf<File> pdf = Funk.docbook2pdf(docbookXml);
		assertTrue(pdf.isPresent());
		final File expectedPdf = FileUtils.getFile("src","test", "resources", "docbook", "example1.pdf");		
		
		try {
			PdfComparator<?> pdfComparator = new PdfComparator(expectedPdf, pdf.get());
			CompareResult result = pdfComparator.compare();
			assertTrue(result.isEqual());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@AfterEach
	protected
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }
	
}
