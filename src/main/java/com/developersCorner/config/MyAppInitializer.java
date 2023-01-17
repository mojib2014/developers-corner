package com.developersCorner.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {
	

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}


}
