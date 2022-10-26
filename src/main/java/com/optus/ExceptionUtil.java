package com.optus;

public class ExceptionUtil {

	public static String handleRestException(Exception e) {
		if (e instanceof org.jbpm.bpmn2.handler.WorkItemHandlerRuntimeException
				&& e.getCause() != null && e.getCause().getCause() != null) {
			java.lang.Throwable cause = e.getCause().getCause();
			if (e.getCause().getCause() instanceof org.jbpm.process.workitem.rest.RESTServiceException) {
				org.jbpm.process.workitem.rest.RESTServiceException x = (org.jbpm.process.workitem.rest.RESTServiceException) e
						.getCause().getCause();
				return "http status = " + x.getStatus() + " message ="
						+ x.getResponse() + " endpoint: " + x.getEndoint();
			} else {
				return cause.toString();
			}
		} else {
			return getStackTrace(e);
		}
	}

	/**
	 * Outputs an exception's stack-trace as a String for easier logging
	 */
	public static String getStackTrace(Exception e) {
		java.io.StringWriter sw = new java.io.StringWriter();
		java.io.PrintWriter pw = new java.io.PrintWriter(sw);
		e.printStackTrace(pw);
		return sw.toString();
	}

	public ExceptionUtil() {
	}

}