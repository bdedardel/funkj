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
package com.bidjisoft.funkj.monads;

import java.io.File;
import java.util.Objects;
import java.util.function.Consumer;

import com.bidjisoft.funkj.Funk;

// Xhtml monad
public class Xhtml<T> extends Xml<T> {

	/**
     * Returns an {@code Xhtml} with the specified value.
     *
     * @param <T> the class of the value
     * @param value the value to be present, which must be non-null
     * @return an {@code Xhtml} with the value present
     * @throws NullPointerException if value is null
     */
    public static <T> Xhtml<T> of(T value) {
        return new Xhtml<>(value);
    }
    
    private Xhtml() {
    	super();
    }
    
    private Xhtml(T value) {
    	super(value);
    }
    
//    @SuppressWarnings("unchecked")
//	public Pdf<T> toPdf() {
//    	if (value instanceof String) {
//    		return (Pdf<T>) Funk.xhtml2pdf((String)this.get());
//    	} else if (value instanceof File) {
//    		return (Pdf<T>) Funk.xhtml2pdf((File)this.get());
//    	}
//        return Pdf.ofNullable(this.get());  
//    }
//	
}
