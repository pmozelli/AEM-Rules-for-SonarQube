package com.example;

import org.apache.sling.api.resource.ResourceResolver;

import com.cognifide.slice.api.model.InitializableModel;
import com.cognifide.slice.mapper.annotation.JcrProperty;
import com.cognifide.slice.mapper.annotation.SliceResource;
import com.sun.org.apache.xml.internal.security.utils.resolver.ResourceResolver;

/**
 * @author Krzysztof Watral
 */
@SliceResource
public class SampleModel implements InitializableModel {

	private final ResourceResolver resolver;

	@JcrProperty
	private String prop;

	public SampleModel(ResourceResolver resolver) {
		this.resolver = resolver;
	}

	public String getProp() {
		return prop;
	}

	public String getLowerCaseProp() {
		return prop.toLowerCase();
	}

	public String getPropRR() {
		return (String) resolver.getAttribute("TEST");
	}

	public ResourceResolver getResolver() {
		return resolver;
	}

	@Override
	public void afterCreated() {
		resolver.getAttribute("TEST");
	}
}