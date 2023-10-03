package com.bis.myjavaxmlapitest.data.model.xmlModel.author;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name = "book")
public class Book {

    @Element(name = "title",required = false)
    public String title;
}
