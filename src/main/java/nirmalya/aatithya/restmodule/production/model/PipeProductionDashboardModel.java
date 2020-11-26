package nirmalya.aatithya.restmodule.production.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PipeProductionDashboardModel {
		private BigInteger totalCount;
		private BigInteger motherSlitStageCount;
		private BigInteger totalProduction;
		private BigInteger totalPolishing;
		private BigInteger totalPackaging;
		public PipeProductionDashboardModel() {
			super();
			// TODO Auto-generated constructor stub
		}
		public PipeProductionDashboardModel(Object totalCount,Object motherSlitStageCount, Object totalProduction, Object totalPolishing,Object totalPackaging) {
			super();
			this.totalCount = (BigInteger) totalCount;
			this.motherSlitStageCount = (BigInteger) motherSlitStageCount;
			this.totalProduction = (BigInteger) totalProduction;
			this.totalPolishing = (BigInteger) totalPolishing;
			this.totalPackaging = (BigInteger) totalPackaging;
			
			
		}
		public BigInteger getTotalCount() {
			return totalCount;
		}
		public void setTotalCount(BigInteger totalCount) {
			this.totalCount = totalCount;
		}
		
		public BigInteger getMotherSlitStageCount() {
			return motherSlitStageCount;
		}
		public void setMotherSlitStageCount(BigInteger motherSlitStageCount) {
			this.motherSlitStageCount = motherSlitStageCount;
		}
		public BigInteger getTotalProduction() {
			return totalProduction;
		}
		public void setTotalProduction(BigInteger totalProduction) {
			this.totalProduction = totalProduction;
		}
		public BigInteger getTotalPolishing() {
			return totalPolishing;
		}
		public void setTotalPolishing(BigInteger totalPolishing) {
			this.totalPolishing = totalPolishing;
		}
		public BigInteger getTotalPackaging() {
			return totalPackaging;
		}
		public void setTotalPackaging(BigInteger totalPackaging) {
			this.totalPackaging = totalPackaging;
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
