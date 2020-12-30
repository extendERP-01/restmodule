package nirmalya.aatithya.restmodule.employee.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HrmsEmployeeDocumentsModel {
	private String employeeId;
	private String documentType;
	private List<String> documentFile = new ArrayList<String>();
	private String fileName;
	private  String documentTypeName;

	public HrmsEmployeeDocumentsModel() {
		super();
	}

	public HrmsEmployeeDocumentsModel(Object employeeId, Object documentType, Object fileName ,Object documentTypeName) {
		super();
		this.employeeId = (String) employeeId;
		this.documentType = (String) documentType;
		this.fileName = (String) fileName;
		this.documentTypeName = (String) documentTypeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public List<String> getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(List<String> documentFile) {
		this.documentFile = documentFile;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDocumentTypeName() {
		return documentTypeName;
	}

	public void setDocumentTypeName(String documentTypeName) {
		this.documentTypeName = documentTypeName;
	}

	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}
}
