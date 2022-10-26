package com.optus;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class JsonUtil {

	public static String updateDeviceInput(CvcChange cvc) {
		Gson gson = new Gson();
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("asimov_cvc_new_tc1_bw", cvc.getNewBandwidth().getTc1()
				.toString());
		input.put("asimov_cvc_new_tc2_bw", cvc.getNewBandwidth().getTc2()
				.toString());
		input.put("asimov_cvc_new_tc4_bw", cvc.getNewBandwidth().getTc4()
				.toString());
		input.put("net_vlan_id", cvc.getNetConfig().getNetVlanId());
		input.put("net_interface", cvc.getNetConfig().getNetInterface());
		input.put("neName", cvc.getNetConfig().getNeName());
		input.put("cvc_id", cvc.getCvcId());
		String inputJson = gson.toJson(input);
		String extraVars = "{ \"extra_vars\":" + inputJson + "}";
		System.out.println("input payload " + extraVars);
		return extraVars;
	}

	public static String rollbackDeviceInput(CvcChange cvc) {
		Gson gson = new Gson();
		NbnCvcRecord nbn = cvc.getNbnCvc();
		if (nbn == null) {
			return null;
		}
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("asimov_cvc_new_tc1_bw", nbn.getCurrentBandwidth().getTc1()
				.toString());
		input.put("asimov_cvc_new_tc2_bw", nbn.getCurrentBandwidth().getTc2()
				.toString());
		input.put("asimov_cvc_new_tc4_bw", nbn.getCurrentBandwidth().getTc4()
				.toString());
		input.put("net_vlan_id", cvc.getNetConfig().getNetVlanId());
		input.put("net_interface", cvc.getNetConfig().getNetInterface());
		input.put("neName", cvc.getNetConfig().getNeName());
		input.put("cvc_id", cvc.getCvcId());
		String inputJson = gson.toJson(input);
		String extraVars = "{ \"extra_vars\":" + inputJson + "}";
		System.out.println("input payload " + extraVars);
		return extraVars;
	}

	public static Bandwidth updateDeviceOutput(Map<String, Object> artifacts) {
		if (artifacts == null || artifacts.get("net_new_tc1_bw") == null
				|| artifacts.get("net_new_tc2_bw") == null
				|| artifacts.get("net_new_tc4_bw") == null) {
			return null;
		}
		Bandwidth bandwidth = new Bandwidth();
		bandwidth.setTc1(Integer.parseInt((String) artifacts
				.get("net_new_tc1_bw")));
		bandwidth.setTc2(Integer.parseInt((String) artifacts
				.get("net_new_tc2_bw")));
		bandwidth.setTc4(Integer.parseInt((String) artifacts
				.get("net_new_tc4_bw")));
		return bandwidth;
	}

	public static String updateAsimovInput(CvcChange cvc) {
		Gson gson = new Gson();
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("net_new_tc1_bw", cvc.getDeviceBandwidth().getTc1());
		input.put("net_new_tc2_bw", cvc.getDeviceBandwidth().getTc2());
		input.put("net_new_tc4_bw", cvc.getDeviceBandwidth().getTc4());
		input.put("cvc_id", cvc.getCvcId());
		String inputJson = gson.toJson(input);
		String extraVars = "{ \"extra_vars\":" + inputJson + "}";
		System.out.println("input payload " + extraVars);
		return extraVars;

	}

	public static String updateNbnInput(CvcChange cvc, boolean cvcUpdate) {
		Gson gson = new Gson();
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("asimov_cvc_new_tc1_bw", cvc.getNewBandwidth().getTc1());
		input.put("asimov_cvc_new_tc2_bw", cvc.getNewBandwidth().getTc2());
		input.put("asimov_cvc_new_tc4_bw", cvc.getNewBandwidth().getTc4());
		input.put("cvc_id", cvc.getCvcId());
		input.put("cvc_product_id", cvc.getProductId());
		input.put("cvc_update", cvcUpdate);
		input.put("externalId",
				cvc.getReferenceId() + " - " + cvc.getResizeAction());
		String inputJson = gson.toJson(input);
		String extraVars = "{ \"extra_vars\":" + inputJson + "}";
		System.out.println("input payload " + extraVars);
		return extraVars;

	}

	public static String rollbackNbnInput(CvcChange cvc) {
		Gson gson = new Gson();
		boolean cvcUpdate = true;
		NbnCvcRecord nbn = cvc.getNbnCvc();
		if (nbn == null || nbn.getCurrentBandwidth() == null) {
			return null;
		}
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("asimov_cvc_new_tc1_bw", nbn.getCurrentBandwidth().getTc1());
		input.put("asimov_cvc_new_tc2_bw", nbn.getCurrentBandwidth().getTc2());
		input.put("asimov_cvc_new_tc4_bw", nbn.getCurrentBandwidth().getTc4());
		input.put("cvc_id", cvc.getCvcId());
		input.put("cvc_product_id", cvc.getProductId());
		input.put("cvc_update", cvcUpdate);
		input.put("externalId",
				cvc.getReferenceId() + " - " + cvc.getResizeAction()
						+ " - Revert");
		String inputJson = gson.toJson(input);
		String extraVars = "{ \"extra_vars\":" + inputJson + "}";
		System.out.println("input payload " + extraVars);
		return extraVars;

	}

	public static Bandwidth updateNbnOutput(Map<String, Object> artifacts) {
		if (artifacts == null || artifacts.get("current_nbn_tc1ulbw") == null
				|| artifacts.get("current_nbn_tc2ulbw") == null
				|| artifacts.get("current_nbn_tc4ulbw") == null) {
			return null;
		}
		Bandwidth bandwidth = new Bandwidth();
		bandwidth.setTc1(Integer.parseInt((String) artifacts
				.get("current_nbn_tc1ulbw")));
		bandwidth.setTc2(Integer.parseInt((String) artifacts
				.get("current_nbn_tc2ulbw")));
		bandwidth.setTc4(Integer.parseInt((String) artifacts
				.get("current_nbn_tc4ulbw")));
		return bandwidth;
	}
	
	public static NbnPortalOrder getNbnPortalOrder(Map<String, Object> artifacts){
	    if (artifacts == null || artifacts.get("nbnPortalOrderState") == null){
            return null;	        
	    }
	    NbnPortalOrder order = new NbnPortalOrder();
	    order.setOrderId((String) artifacts.get("nbnPortalOrderId"));
	    order.setState((String) artifacts.get("nbnPortalOrderState"));
	    if (artifacts.get("nbnFailure") != null ){
	        Map<String, String> failure = (Map) artifacts.get("nbnFailure");
	        order.setFailureCode((String) failure.get("code"));
	        order.setFailureReason((String) failure.get("reason"));
	    }
	    return order;
	    
	}
	
	public static String cancelNbnInput(NbnPortalOrder order){
	    Gson gson = new Gson();
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("cvc_update", false);
		input.put("nbnPortalOrderId",order.getOrderId());
		input.put("cvc_nbn_cancel",true);
		String inputJson = gson.toJson(input);
		String extraVars = "{ \"extra_vars\":" + inputJson + "}";
		System.out.println("cancellation payload " + extraVars);
		return extraVars;
	}
	
	public static String parseAnsibleError(String job_events) {
		if ( job_events == null || job_events.length() == 0) {
			return "Error is empty";
		} else {
			if ( !JsonUtil.isJSONValid(job_events)) {
				return "Error is not valid json string";
			} else {
				try {
					java.util.Set<String> errorSet = new java.util.HashSet<>();
					java.util.List<String> msgList = com.jayway.jsonpath.JsonPath.read(
							job_events, "$.results[*].event_data.res..msg");
					for (String msg : msgList) {
						errorSet.add(msg);
					}
					return String.join(",", errorSet);
				} catch (Exception e) {
					return "Unable to determine error cause";
				}
			}
		}
	}

	public static boolean isJSONValid(String jsonInString) {
		Gson gson = new Gson();
		try {
			gson.fromJson(jsonInString, Object.class);
			return true;
		} catch(com.google.gson.JsonSyntaxException ex) {
			return false;
		}
	}

	public static String reportInJson(CvcBwChangeReport report) {
		Gson gson = new Gson();
		return gson.toJson(report);
	}

	public static String reportInJson(CvcBwChangeResponse response) {
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	public static Map processLaunchResponse(String response) {
		Gson gson = new Gson();
		Map<String, Object> responseMap = gson.fromJson(response, Map.class);
		return responseMap;
	}

	public JsonUtil() {
	}

}
