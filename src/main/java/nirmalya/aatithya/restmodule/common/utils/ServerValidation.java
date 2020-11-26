package nirmalya.aatithya.restmodule.common.utils;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;

@Repository
public class ServerValidation {

	
	public static String[] geterror(Throwable e) {
		
		String[] res = {"",""};
		
		try {
			
			Throwable xx = e;
			
			while(xx.getCause() != null) {
				xx = xx.getCause();
			}

			
			if(xx instanceof SQLException) {
				Integer code = ((SQLException)xx).getErrorCode();
				String message = ((SQLException)xx).getMessage();
				String state = ((SQLException)xx).getSQLState();
				
				String values = GenerateParameter.getSqlErrorParam(code,state,message,"");

				ServerDao serverDao = new ServerDao();
				
				Object handle = serverDao.callProcedure(values);
				
				if(handle != null) {
					
					String h = (String)handle;
					h = h.replace("_UNIQUE", "");
					h = h.replace("key", "");
					String[] z = h.split("@@");
					
					res = z;
					
				}else {
					message = message.replace("_UNIQUE", "");
					message = message.replace("key", "");
					res[1] = message;
					res[0] = code.toString();
				}
			
			}else {
				
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return res;
	}
	
	
}
