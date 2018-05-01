package com.stadheim.webloc.converter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Winurl extends URLFile {
	
	public Winurl(URLFile urlFile) {
		this(urlFile.getFile(), urlFile.getUrl());
	}

	public Winurl(File file, String url) {
    		super(file, url);
    }
	
	private File makeWinFile() {
		String f = getFile().getName();
		if(f.endsWith(".url")) {
			return getFile();
		} if (f.indexOf(".") != -1) {
			return new File(
					getFile().getParentFile().getAbsolutePath(),
					f.substring(0, f.lastIndexOf(".")) + ".url");
		} else {
			return new File(
					getFile().getParentFile().getAbsolutePath(),
					f + ".url");
		}
	}
	
	public void save() throws IOException {
		FileWriter out = new FileWriter(makeWinFile());
		try {
			out.write("[InternetShortcut]\r\n");
			out.write("URL=" + getUrl() + "\r\n");
		} finally {
			out.close();
		}
	}
    
}