package com.qi;

import java.io.File;
import java.io.FilenameFilter;

public class Demo implements FilenameFilter {
	private String nn;
	public Demo(String nn){
		this.nn=nn;
	}

	public boolean accept(File dir, String name) {
		return name.endsWith(nn);
	}

}
