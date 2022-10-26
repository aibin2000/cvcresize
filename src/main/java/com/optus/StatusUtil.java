package com.optus;

import java.util.Date;

public class StatusUtil {

	public static final String ROLLBACK_SUCCESS = "ROLLBACK_SUCCESS";
	public static final String ROLLBACK_FAILED = "ROLLBACK_FAILED";
	public static final String WARNING = "WARNING";

	public static CvcBwChangeResponse updateCvcStatus(
			CvcBwChangeResponse cvcResponse, String status) {
		cvcResponse.setStatus(status);
		cvcResponse.setLastUpdatedTime(new Date());
		return cvcResponse;
	}

	public static CvcBwChangeResponse updateRollbackStatus(
			CvcBwChangeResponse cvcResponse, boolean success) {
		String status = cvcResponse.getStatus();
		if (success) {
			if (status != null && status.equals(ROLLBACK_FAILED)) {
				// already rollback is marked for failure. so don't change it
				return cvcResponse;
			} else if (status != null && status.equals(WARNING)){
			    // already rollback is marked for failure. so don't change it
			    cvcResponse.setStatus("FAILED");
			} else {
				cvcResponse.setStatus(ROLLBACK_SUCCESS);
			}

		} else {
			cvcResponse.setStatus(ROLLBACK_FAILED);
		}
		cvcResponse.setLastUpdatedTime(new Date());
		return cvcResponse;
	}

	public static CvcBwChangeReport updateStatusReport(
			CvcBwChangeReport report, CvcBwChangeResponse cvcResponse,
			String status) {
		cvcResponse.setStatus(status);
		cvcResponse.setLastUpdatedTime(new Date());
		report.getCvcs().put(cvcResponse.getCvcId(), cvcResponse);
		return report;
	}

	// public static CvcBwChangeReport updateFinalStatus(CvcBwChangeReport
	// report) {
	// boolean isError = false;
	// java.util.Map cvcMap = report.getCvcs();
	// java.util.Collection<CvcBwChangeResponse> values = cvcMap.values();
	// for (CvcBwChangeResponse v : values) {

	// java.util.List<JobCompletion> jobList = v.getJobHistory();
	// for (JobCompletion job : jobList) {
	// if (!job.getStatus().equals("SUCCESS")) {
	// isError = true;
	// }
	// }
	// }
	// report.setStatus(isError ? "ERROR" : "COMPLETE");

	// return report;
	// }
	/*
	 * public static CvcBwChangeResponse addException( CvcBwChangeResponse
	 * cvcResponse, BwChangeException ex) {
	 * cvcResponse.setStatus("RECEIVED_EXCEPTION");
	 * cvcResponse.setLastUpdatedTime( new Date() );
	 * cvcResponse.getExceptions().add(ex); return cvcResponse; }
	 */

	public static CvcBwChangeResponse addJob(CvcBwChangeResponse cvcResponse,
			JobCompletion job) {
		cvcResponse.setLastUpdatedTime(new Date());
		cvcResponse.getJobHistory().add(job);
		return cvcResponse;
	}

	public StatusUtil() {
	}

}
