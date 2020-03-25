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
	
//	XML Calabash version 2.4.3, an XProc processor.
//	Running on Saxon version 9.9.1.5, HE edition.
//	Copyright (c) 2007-2013 Norman Walsh
//	See docs/notices/NOTICES in the distribution for licensing
//	See also http://xmlcalabash.com/ for more information
//
//	Usage: com.xmlcalabash.drivers.Main [switches/options] [pipeline.xpl] [options]
//	   or: com.xmlcalabash.drivers.Main [switches/options] { [inputs/parameters] step [options] }+
//
//	Where switches are:
//	  -a, --schema-aware                         Turn on schema-aware processing,
//	                                             this also sets saxon-processor to 'ee' implicitly
//	  -b, --binding prefix=uri                   Specify namespace binding
//	  -c, --config configfile                    Specify a particular configuration file
//	  -d, --data-input [contentType@][port=]uri  Bind the specified input port to data, if no port is specified,
//	                                             the first unbound input port is used
//	  -D, --debug                                Turn on debugging
//	  -E, --entity-resolver className            Specify a resolver class for entity resolution
//	  -G, --log-style logstyle                   Specify the default style for p:log output;
//	                                             Must be 'off', 'plain', 'wrapped' (default), or 'directory'
//	  -i, --input [port=]uri                     Bind the specified input port, if no port is specified,
//	                                             the first unbound input port is used
//	  -l, --library library.xpl                  Load the specified library
//	  -o, --output [port=]uri                    Bind the specified output port, if no port is specified,
//	                                             the first unbound output port is used
//	  -p, --with-param [port@]param=value        Specify a parameter
//	      --profile file                         Specify a file, or '-' for console output,
//	                                             where to write profiling information of the
//	                                             pipeline that was run
//	  -P, --saxon-processor edition              Request a specific edition of Saxon;
//	                                             Must be 'he' (default), 'pe' or 'ee'
//	  -s, --step stepname                        Run the step named 'stepname' instead of a pipeline
//	  -S, --safe-mode                            Request 'safe' execution
//	  -U, --uri-resolver className               Specify a resolver class for URI resolution
//	  -v, --version                              Show XML Calabash version
//	  -X, --extension extname                    Enable the 'extname' extension;
//	                                             valid extname values are 'general-values', 'xpointer-on-text',
//	                                             'transparent-json', 'json-flavor=<flavor>' and 'use-xslt-10'
//	      --saxon-configuration file             Load the specified Saxon configuration
//
//	For more information, consult http://xmlcalabash.com/docs/reference/ or
//	the documentation that came with the distribution.
	
	// see also:
	// - [Chapter 7. Options, Variables, and Parameters](https://xprocbook.com/book/chapter-7.html)
	@Override
	public File apply(File docbookXml, File docbookXsl) {	
		// xmlcalabash
		try {
			File res = File.createTempFile("funkj_", extension);
			// res.deleteOnExit();
			List<String> args = new ArrayList<String>();
			args.add("-isource=" + docbookXml.getAbsolutePath());			
			args.add(docbookXsl.getAbsolutePath());			
			args.add("pdf=" + res.getAbsolutePath());
			com.xmlcalabash.drivers.Main.main(args.toArray(new String[args.size()]));
			return res; 
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
