package com.mly.employee.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@EnableConfigurationProperties

/**
 * Configuration properties holder.
 * 
 * @author hafeeztsd
 *
 */
public class Properties {

	private String filedir;
	private String filename;

	public String getFiledir() {
		return filedir;
	}

	public void setFiledir(String filedir) {
		this.filedir = filedir;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "Properties [filedir=" + filedir + ", filename=" + filename + "]";
	}
	
	

}
