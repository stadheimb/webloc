package com.stadheim.webloc.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Webloc extends URLFile {

	public Webloc(File file) {
		super(file, "");
    }
    
    public void load() throws IOException {
    		FileReader reader = new FileReader(getFile());
    		BufferedReader buf = new BufferedReader(reader);
    		String str;
    		
//    		<key>URL</key>
//    		<string>http://itgeekrage.blogspot.no/2013/01/how-to-open-webloc-files-in-windows.html</string>
    		try {
	    		boolean next =  false;
	    		while( (str = buf.readLine()) != null) {
	    			if(str.indexOf("<key>") != -1) {
	    				next = str.indexOf("<key>URL</key>") != -1;
	    			} else if (next && str.indexOf("<string>") != -1) {
	    				setUrl(str.trim().replace("<string>", "").replaceAll("</string>", ""));
	    			}
	    		}
    		} finally {
    			if(buf != null) {
    				buf.close();
    			}
    		}
    }
    
}