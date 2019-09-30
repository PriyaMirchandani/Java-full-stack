package com.zensar.exceptions;
import org.omg.PortableInterceptor.USER_EXCEPTION;

public class ServiceException extends Exception {
	
  private String errorMessage;
  
  public ServiceException()
  {
	  errorMessage="error:service exception";
	  
  }
  public ServiceException(String errorMessage)
  {
	  super();
	  this.errorMessage=errorMessage;
	  
  }
}
