package com.stadheim.webloc.converter;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class URLFile {
	
    private File file;
    private String url;
    protected Logger log = LoggerFactory.getLogger(URLFile.class);
    
    public URLFile(File file, String url) {
    		this.file = file;
    		this.url = url;
    }
    
    public void move(File newParentPath) {
    		this.file = new File(newParentPath, file.getName());
    }
    
    public void move(String subfolder) {
    		File f = new File(file.getParentFile(), subfolder);
    		f.mkdir();
    		move(f);
    }

    public File getFile() {
    		return file;
    }
    
    public String getUrl() {
    		return url;
    }
    
    public void setUrl(String url) {
    		this.url = url;
    }
    
    public String toString() {
    		return url != null ? url : file.getName();
    }
    
}
