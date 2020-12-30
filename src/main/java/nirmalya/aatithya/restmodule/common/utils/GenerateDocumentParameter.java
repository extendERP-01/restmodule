/**
 * 
 */
package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.document.model.RestDocumentModel;

/**
 * @author NirmalyaLabs
 *
 */
public class GenerateDocumentParameter {
	/**
	 * returns parameter set for inventory MasterCountryModel class
	 **/

	public static String addDocumentParam(RestDocumentModel restDocumentModel) {

		String s = "";
		if (restDocumentModel.getDocument() != null || restDocumentModel.getDocument() != "") {
			s = s + "@p_document='" + restDocumentModel.getDocument() + "',";
		}

		if (restDocumentModel.getCategory() != null || restDocumentModel.getCategory() != "") {
			s = s + "@p_category='" + restDocumentModel.getCategory() + "',";
		}

		if (restDocumentModel.getReferenceNo() != null || restDocumentModel.getReferenceNo() != "") {
			s = s + "@p_refNo='" + restDocumentModel.getReferenceNo() + "',";
		}
		if (restDocumentModel.getSubject() != null || restDocumentModel.getSubject() != "") {
			s = s + "@p_subject='" + restDocumentModel.getSubject() + "',";
		}
		if (restDocumentModel.getCompanyName() != null || restDocumentModel.getCompanyName() != "") {
			s = s + "@p_companyName='" + restDocumentModel.getCompanyName() + "',";
		}
		if (restDocumentModel.getDocumentImage() != null || restDocumentModel.getDocumentImage() != "") {
			s = s + "@p_image='" + restDocumentModel.getDocumentImage() + "',";
		}
		if (restDocumentModel.getKeyword() != null) {
			s = s + "@p_keyword='" + restDocumentModel.getKeyword() + "',";
		}
		if (restDocumentModel.getDescription() != null || restDocumentModel.getDescription() != "") {
			s = s + "@p_description='" + restDocumentModel.getDescription() + "',";
		}

		if (restDocumentModel.getApprovalStatus() != null) {
			s = s + "@p_approvalStatus='" + restDocumentModel.getApprovalStatus() + "',";
		}
		if(restDocumentModel.getCreatedBy()!= null) {
			s = s + "@p_createdBy= '"+restDocumentModel.getCreatedBy() + "',";
		}
		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		System.out.println(s);
		return s;

	}
}
