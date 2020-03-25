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

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

// Pdf monad
// see: Pdf
public class Pdf<T> {
	// TODO: thread safe ???
	/**
     * Common instance for {@code empty()}.
     */
    private static final Pdf<?> EMPTY = new Pdf<>();
	
    /**
     * Returns an {@code Pdf} with the specified value.
     *
     * @param <T> the class of the value
     * @param value the value to be present, which must be non-null
     * @return an {@code Pdf} with the value present
     * @throws NullPointerException if value is null
     */
    public static <T> Pdf<T> of(T value) {
        return new Pdf<>(value);
    }
    
    /**
     * Returns an {@code Pdf} describing the specified value, if non-null,
     * otherwise returns an empty {@code Pdf}.
     *
     * @param <T> the class of the value
     * @param value the possibly-null value to describe
     * @return an {@code Pdf} with a present value if the specified value
     * is non-null, otherwise an empty {@code Pdf}
     */
    public static <T> Pdf<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }
	
    private final T value;
    
    protected Pdf() {
        this.value = null;
    }
    
    protected Pdf(T value) {
        this.value = Objects.requireNonNull(value);
    }

    /**
     * Returns an empty {@code Optional} instance.  No value is present for this
     * Optional.
     *
     * @apiNote Though it may be tempting to do so, avoid testing if an object
     * is empty by comparing with {@code ==} against instances returned by
     * {@code Option.empty()}. There is no guarantee that it is a singleton.
     * Instead, use {@link #isPresent()}.
     *
     * @param <T> Type of the non-existent value
     * @return an empty {@code Optional}
     */
    public static<T> Pdf<T> empty() {
        @SuppressWarnings("unchecked")
        Pdf<T> t = (Pdf<T>) EMPTY;
        return t;
    }
    
    /**
     * If a value is present in this {@code Pdf}, returns the value,
     * otherwise throws {@code NoSuchElementException}.
     *
     * @return the non-null value held by this {@code Pdf}
     * @throws NoSuchElementException if there is no value present
     *
     * @see Pdf#isPresent()
     */
    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }
        return value;
    }

    /**
     * Return {@code true} if there is a value present, otherwise {@code false}.
     *
     * @return {@code true} if there is a value present, otherwise {@code false}
     */
    public boolean isPresent() {
        return value != null;
    }

    /**
     * If a value is present, invoke the specified consumer with the value,
     * otherwise do nothing.
     *
     * @param consumer block to be executed if a value is present
     * @throws NullPointerException if value is present and {@code consumer} is
     * null
     */
    public void ifPresent(Consumer<? super T> consumer) {
        if (value != null)
            consumer.accept(value);
    }
	
}
