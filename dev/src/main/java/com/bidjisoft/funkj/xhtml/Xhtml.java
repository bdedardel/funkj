package com.bidjisoft.funkj.xhtml;

import java.io.File;
import java.util.Objects;
import java.util.function.Consumer;

import com.bidjisoft.funkj.Funk;
import com.bidjisoft.funkj.pdf.Pdf;
import com.bidjisoft.funkj.xml.Xml;

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
