package nirmalya.aatithya.restmodule.common.utils;

import nirmalya.aatithya.restmodule.employee.model.HrmsCertificationMasterModel;

public class GenerateCertificationMasterParameter {
	public static String getAddCertificationParam(HrmsCertificationMasterModel Certification) {

		String s = "";
		
		if(Certification.getCertificationId()!=null)
		{
			s = s + "@P_certId='" + Certification.getCertificationId() + "',";
		}
		if(Certification.getCertificationName()!=null && Certification.getCertificationName()!="")
		{
			s = s + "@p_certName='" + Certification.getCertificationName() + "',";
		}
		 
		if(Certification.getCertificationDesc()!=null && Certification.getCertificationDesc()!="")
		{
			s = s + "@p_certDesc='" + Certification.getCertificationDesc() + "',";
		}
		if(Certification.getCreatedBy()!=null && Certification.getCreatedBy()!=" ")
		{
			s = s + "@p_createdBy='" + Certification.getCreatedBy() + "',";
		}
		if(Certification.getCompanyId()!=null && Certification.getCompanyId()!="")
		{
			s = s + "@p_companyId='" + Certification.getCompanyId() + "',";
		}
		if(Certification.getCertificationStatus()==true || Certification.getCertificationStatus()==false)
		{
			s = s + "@p_active=" + Certification.getCertificationStatus() + ",";
		}
		if(s != "") {
			s = s.substring(0, s.length()-1);
			
			s = "SET " + s + ";" ;
		}
		return s;
	}
}

