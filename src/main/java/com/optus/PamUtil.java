package com.optus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class PamUtil {

	static String ANSIBLE_TOWER = "ANSIBLE_TOWER";
	static String ANSIBLE_USER = "ANSIBLE_USER";
	static String ANSIBLE_PWD = "ANSIBLE_PWD";
	static String ANSIBLE_DEVICE_UPDATE_TEMPLATE = "ANSIBLE_DEVICE_UPDATE_TEMPLATE";
	static String ASIMOV_DEVICE_UPDATE_TEMPLATE = "ASIMOV_DEVICE_UPDATE_TEMPLATE";
	static String NBN_API_TEMPLATE = "NBN_API_TEMPLATE";

	public static final String getAnsibleTower() {
		return System.getenv(ANSIBLE_TOWER);
	}

	public static final String getAnsibleUser() {
		return System.getenv(ANSIBLE_USER);
	}

	public static final String getAnsiblePwd() {
		return System.getenv(ANSIBLE_PWD);
	}

	public static final String getDeviceUpdateTemplate() {
		return System.getenv(ANSIBLE_DEVICE_UPDATE_TEMPLATE);
	}

	public static final String getAsimovUpdateTemplate() {
		return System.getenv(ASIMOV_DEVICE_UPDATE_TEMPLATE);
	}

	public static final String getNbnApiTemplate() {
		String id = System.getenv(NBN_API_TEMPLATE);
		return id == null ? "151" : id;
	}

	/**
	 * Re-organized cvcChangeList into multiple group list,
	 * 
	 * Each group won't contain the item which having the same neName
	 * 
	 * @param cvcChangeListObject
	 * @return
	 */
	public static final Map<Integer, List<CvcChange>> reGroupCvcChangeList(
			Object cvcChangeListObject) {

		List<CvcChange> cvcChangeList = (List<CvcChange>) cvcChangeListObject;

		Map<Integer, List<CvcChange>> cvcChangeListGroups = new HashMap<Integer, List<CvcChange>>();

		for (CvcChange cvcChange : cvcChangeList) {

			if (cvcChange.getNetConfig() != null
					&& cvcChange.getNetConfig().getNeName() != null) {
				String neName = cvcChange.getNetConfig().getNeName();
				String[] neNameArray = neName.split(",");

				if (neNameArray != null && neNameArray.length > 0) {
					boolean neNameExisted = false;
					Integer key = -1;

					String neNamePrefix = neNameArray[0];

					for (Map.Entry<Integer, List<CvcChange>> set : cvcChangeListGroups
							.entrySet()) {
						neNameExisted = false;
						key = set.getKey();
						List<CvcChange> existedCvcChangeListGroup = set
								.getValue();
						for (CvcChange cvcChangeInSideGroup : existedCvcChangeListGroup) {
							if (cvcChangeInSideGroup.getNetConfig() != null
									&& cvcChangeInSideGroup.getNetConfig()
											.getNeName() != null) {
								String neNameInSideGroup = cvcChangeInSideGroup
										.getNetConfig().getNeName();
								String[] neNameInSideGroupArray = neNameInSideGroup
										.split(",");
								if (neNameInSideGroupArray != null
										&& neNameInSideGroupArray.length > 0) {
									String neNameInSideGroupPrefix = neNameInSideGroupArray[0];
									if (neNameInSideGroupPrefix
											.equalsIgnoreCase(neNamePrefix)) {
										neNameExisted = true;
									}
								}
							}
						}

						/**
						 * if neName doesn't exist in this group, adding this
						 * cvcChange into this group
						 */
						if (!neNameExisted) {
							existedCvcChangeListGroup.add(cvcChange);
							break;
						}
					}

					/**
					 * if all existed group having the item which having same
					 * neName or if cvcChangeListGroups is empty
					 * 
					 * creating new group, put cvcChange into the new group,
					 * then add the new group into HashMap
					 */
					if (neNameExisted || cvcChangeListGroups.size() == 0) {

						List<CvcChange> newCvcChangeListGroup = new ArrayList<CvcChange>();
						newCvcChangeListGroup.add(cvcChange);
						cvcChangeListGroups.put(Integer.valueOf(key + 1),
								newCvcChangeListGroup);
					}
				}
			}
		}
		return cvcChangeListGroups;
	}

	public PamUtil() {
	}

}
