/**
 * Defines the ErrorHandling entity for  Stored procedures 
**/
package nirmalya.aatithya.restmodule.common;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = "errorHandling", 
				procedureName = "error_errorHandling", 
				resultClasses = ErrorHandling.class , 
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN,name = "actionType", type = String.class),
						@StoredProcedureParameter(mode = ParameterMode.IN,name = "actionValue", type = String.class) 
				}

		) 
})

/**
 * @author Nirmalya Labs
 *
 */
public class ErrorHandling {

	@Id
	private Integer errorId;

	private String nlErrorCode;
	
	private String nlErrorMessage;

	
	public ErrorHandling() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getErrorId() {
		return errorId;
	}

	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}

	public String getNlErrorCode() {
		return nlErrorCode;
	}

	public void setNlErrorCode(String nlErrorCode) {
		this.nlErrorCode = nlErrorCode;
	}

	public String getNlErrorMessage() {
		return nlErrorMessage;
	}

	public void setNlErrorMessage(String nlErrorMessage) {
		this.nlErrorMessage = nlErrorMessage;
	}

	
	/**
	 * Overrides toString method for converting class to string and vice-versa 
	**/
	@Override
	public String toString() {
		ObjectMapper  mapperObj=new ObjectMapper();
		String jsonStr;
		try{
			jsonStr=mapperObj.writeValueAsString(this);
		}catch(IOException ex){
			
			jsonStr=ex.toString();
		}
		return jsonStr;
	}
	
	
}
