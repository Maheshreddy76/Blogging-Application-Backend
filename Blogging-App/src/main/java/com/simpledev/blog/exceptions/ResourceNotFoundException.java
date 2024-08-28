package com.simpledev.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String field;
	private long userId;
	public ResourceNotFoundException(String resourceName,String field,long userId){
		super(String.format("%s Not Found %s: %l", resourceName,field,userId));
		this.resourceName=resourceName;
		this.field=field;
		this.userId=userId;
	}
}
