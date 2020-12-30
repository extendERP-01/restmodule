package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * @author Nirmalya Labs
 *
 */
public class RestSuperAdminDashboardModel {
	private Integer spaInvoice;
	private Integer gymInvoice;
	private Integer beautyInvoice;
	private Integer laundryInvoice;
	private Integer nightClubInvoice;
	private Integer restaurantInvoice;
	private Integer kitchenInvoice;
	
	public RestSuperAdminDashboardModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestSuperAdminDashboardModel(Object spaInvoice, Object gymInvoice, Object beautyInvoice,
			Object laundryInvoice, Object nightClubInvoice,Object restaurantInvoice,Object kitchenInvoice  ) {
		super();
		
		
		try {
			this.spaInvoice = (Integer) spaInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.gymInvoice = (Integer) gymInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.beautyInvoice = (Integer) beautyInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.laundryInvoice = (Integer) laundryInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.nightClubInvoice = (Integer) nightClubInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.restaurantInvoice = (Integer) restaurantInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.kitchenInvoice = (Integer) kitchenInvoice;
		} catch (Exception e) {
			e.printStackTrace();
		}
}

	public Integer getSpaInvoice() {
		return spaInvoice;
	}

	public void setSpaInvoice(Integer spaInvoice) {
		this.spaInvoice = spaInvoice;
	}

	public Integer getGymInvoice() {
		return gymInvoice;
	}

	public void setGymInvoice(Integer gymInvoice) {
		this.gymInvoice = gymInvoice;
	}

	public Integer getBeautyInvoice() {
		return beautyInvoice;
	}

	public void setBeautyInvoice(Integer beautyInvoice) {
		this.beautyInvoice = beautyInvoice;
	}

	public Integer getLaundryInvoice() {
		return laundryInvoice;
	}

	public void setLaundryInvoice(Integer laundryInvoice) {
		this.laundryInvoice = laundryInvoice;
	}

	public Integer getNightClubInvoice() {
		return nightClubInvoice;
	}

	public void setNightClubInvoice(Integer nightClubInvoice) {
		this.nightClubInvoice = nightClubInvoice;
	}

	public Integer getRestaurantInvoice() {
		return restaurantInvoice;
	}

	public void setRestaurantInvoice(Integer restaurantInvoice) {
		this.restaurantInvoice = restaurantInvoice;
	}

	public Integer getKitchenInvoice() {
		return kitchenInvoice;
	}

	public void setKitchenInvoice(Integer kitchenInvoice) {
		this.kitchenInvoice = kitchenInvoice;
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
