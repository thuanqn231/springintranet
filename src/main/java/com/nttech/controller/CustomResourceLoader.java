package com.nttech.controller;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class CustomResourceLoader implements ResourceLoaderAware {
	private ResourceLoader resourceLoader;
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	
	public Resource getResource(String path) {
		return resourceLoader.getResource(path);
	}

}
