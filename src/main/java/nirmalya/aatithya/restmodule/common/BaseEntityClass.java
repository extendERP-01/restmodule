/**
 *  Defines the dummy entity  for Stored Procedure. 
 */
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
		// procedures for mobile api
		/*
		 * * for login routines
		 */
		@NamedStoredProcedureQuery(name = "loginRestApi", procedureName = "user_login_rest_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for kitchen manager routines
		 */
		@NamedStoredProcedureQuery(name = "kitchenApiRoutines", procedureName = "user_kitchen_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for kitchen staff routines
		 */
		@NamedStoredProcedureQuery(name = "kitchenApiStaffRoutines", procedureName = "user_kitchen_staff_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for menu item routines
		 */
		@NamedStoredProcedureQuery(name = "menuItem", procedureName = "user_menu_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for restaurant manager api routines
		 */
		@NamedStoredProcedureQuery(name = "restaurantManager", procedureName = "restaurant_manager_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for restaurant staff api routines
		 */
		@NamedStoredProcedureQuery(name = "restaurantStaff", procedureName = "restaurant_staff_api_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "userRoutines", procedureName = "user_userRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user Type Procedure definition for user type
		 */
		@NamedStoredProcedureQuery(name = "UserType", procedureName = "user_typeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_prefixManagementRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "userPrefixManagementRoutines", procedureName = "user_prefixManagementRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * sacCodeRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "sacCodeRoutines", procedureName = "user_sacCodeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_ManageRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "userManageRoutines", procedureName = "user_ManageRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * user_processRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "processRoutines", procedureName = "user_processRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_guestDetailRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "guestRoutines", procedureName = "master_guestDetailRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * PropertyDashboardRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "PropertyDashboardRoutines", procedureName = "property_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * property_assignmentOfpropertyToStaff Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "assignPropertyToStaffRoutines", procedureName = "property_assignmentOfpropertyToStaff", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * property reservation Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyReservation", procedureName = "property_reservationRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * comparePropertyRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "comparePropertyRoutines", procedureName = "user_comparePropertyRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * user_stateRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "stateRoutines", procedureName = "user_stateRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * userroleRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "userroleRoutines", procedureName = "user_userroleRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user rating Stored Procedure definition for user set authority
		 */
		@NamedStoredProcedureQuery(name = "UserSetAuthority", procedureName = "user_setauthorityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user Authority dropdownRoutines Stored Procedure definition for user set
		 * authority drop down
		 */
		@NamedStoredProcedureQuery(name = "userAuthoritydropdown", procedureName = "user_authoritydropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * user ApprovalAction Stored Procedure definition for user set authority drop
		 * down
		 */
		@NamedStoredProcedureQuery(name = "ApprovalAction", procedureName = "user_ApprovalAction", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user_districtRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "districtRoutines", procedureName = "user_districtRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * property category Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyCategory", procedureName = "property_categoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// property_assignAssetToStaffRoutines
		@NamedStoredProcedureQuery(name = "assignAssetToStaffRoutines", procedureName = "property_assignAssetToStaffRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * assignedConsumeItemsRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "assignedConsumeItemsRoutines", procedureName = "property_assignedConsumeItemsRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Property transaction routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "propertyTransactionRoutines", procedureName = "property_transactionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * property master Stored Procedure definition for dropdown
		 */
		@NamedStoredProcedureQuery(name = "propertyMasterDropDown", procedureName = "property_masterDropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * user rating Stored Procedure definition for payment mode
		 */
		@NamedStoredProcedureQuery(name = "paymentModeRoutines", procedureName = "master_paymentModeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * user rating Stored Procedure definition for Account Group Master
		 */
		@NamedStoredProcedureQuery(name = "accountGroupRoutines", procedureName = "master_accGroupRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * propBookTypeRoutines Stored Procedure definition for dropdown
		 */
		@NamedStoredProcedureQuery(name = "propBookTypeRoutines", procedureName = "property_propBookTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * property master Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyMaster", procedureName = "property_masterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * property asset code Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "assetCode", procedureName = "property_assetcodeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * asset code drop down property Stored Procedure definition for drop down
		 */
		@NamedStoredProcedureQuery(name = "getItemName", procedureName = "property_assetcodedropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// mano
		@NamedStoredProcedureQuery(name = "addPropertyType", procedureName = "property_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "getPropertyName", procedureName = "property_amenityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * @NamedStoredProcedureQuery( name = "add_Amenity", procedureName =
		 * "propert_Amenity_Routines", parameters = {
		 * 
		 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type
		 * = String.class),
		 * 
		 * @StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type
		 * = String.class) }
		 * 
		 * ),
		 */

		@NamedStoredProcedureQuery(name = "add_Amenity", procedureName = "property_amenityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * For Amenity Item
		 */
		@NamedStoredProcedureQuery(name = "AmenityItem", procedureName = "property_amenityItemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// mano

		/**
		 * property Theme Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "propertyTheme", procedureName = "property_themeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * property_assignAssetRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "AssignAsset", procedureName = "property_assignAssetRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * sitting plan Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "SittingPlan", procedureName = "property_seatingPlanRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * For Assignment of Seating Plan
		 */
		@NamedStoredProcedureQuery(name = "AssignmentOfSeatingPlan", procedureName = "property_assignmentOfSeatingPlan", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * property floor Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyFloorRoutines", procedureName = "property_floorRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * property booking Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "propertyBooking", procedureName = "property_bookingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * property booking Stored Procedure definition for dropdown
		 */
		@NamedStoredProcedureQuery(name = "propertyBookingDropDown", procedureName = "property_bookingDropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * property hotel Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "hotelRoutines", procedureName = "property_hotelRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * hotel drop down property Stored Procedure definition for drop down
		 */
		@NamedStoredProcedureQuery(name = "hoteldropdownRoutines", procedureName = "property_hoteldropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Maintenance Work order Dashboard routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "MaintenanceDashboardRoutines", procedureName = "maintenance_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * Maintenance Work order routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "maintenanceWorkOrderRoutines", procedureName = "maintenance_workOrderRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * maintenance_taskRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "maintenancetaskRoutines", procedureName = "maintenance_taskRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Maintenance_propertyTaskAssignRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "propertyTaskAssignRoutines", procedureName = "Maintenance_propertyTaskAssignRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * maintenance_AssignTaskToStaffRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "maintenanceAssignTaskToStaffRoutines", procedureName = "maintenance_AssignTaskToStaffRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * maintenance_MaidPropertyTaskAssignRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "maintenanceMaidPropertyTaskAssign", procedureName = "maintenance_MaidPropertyTaskAssign", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Request Quotation Routines for Select Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "reqSelectRFQRoutines", procedureName = "inventory_reqSelectRFQRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Request Quotation Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "requestQuotRoutines", procedureName = "inventory_requestQuotRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * RFQ Dlts Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "invRFQDtlsRoutines", procedureName = "inventory_rfqDtlstRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * RFQ PO Dlts Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "invPORFQDtlsRoutines", procedureName = "inventory_rfqPODtlstRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * inventoryItemCategoryRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "InventoryDashboardRoutines", procedureName = "inventory_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * inventory_inventoryStoreRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryStoreRoutines", procedureName = "inventory_inventoryStoreRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * inventoryItemCategoryRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryItemCategoryRoutines", procedureName = "inventory_inventoryItemCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventoryItemSubCategoryRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "itemSubCatRoutines", procedureName = "inventory_itemSubCatRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * inventoryItemRoutines Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "inventoryItemRoutines", procedureName = "inventory_inventoryItemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * inventoryItemServeTypeRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "itemServeTypeRoutines", procedureName = "inventory_itemServeTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventoryCostCenterRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "manageCostcenter", procedureName = "manage_costcenter", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventoryItemRequisitionRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryItemRequisitionRoutines", procedureName = "inventory_inventoryItemRequisitionRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * inventoryVendorRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryVendorRoutines", procedureName = "inventory_inventoryVendorRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * inventoryPurchaseOrderRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryPurchaseOrderRoutines", procedureName = "inventory_inventoryPurchaseOrderRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventorygoodsReturnInvoiceRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "goodsReceiveInvoiceRoutines", procedureName = "inventory_goodsReceiveInvoiceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * Inventory goods return routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "inventoryGoodsReturnRoutines", procedureName = "inventory_goodsReturnRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * inventoryPurchaseOrderRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "inventoryIssueNoteRoutines", procedureName = "inventory_inventoryIssueNoteRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * Laundry Dashboard routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "laundryDashboardRoutines", procedureName = "laundry_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * Laundry ItemCategory routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "laundryItemCategoryRoutines", procedureName = "laundry_itemCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * laundryHotelServiceRoutines routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "laundryHotelServiceRoutines", procedureName = "laundry_hotelServiceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * laundryItemRoutines routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "laundryItemRoutines", procedureName = "laundry_itemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * laundryServiceRoutines routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "laundryServiceRoutines", procedureName = "laundry_laundryServiceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * laundry item service routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "laundryItemService", procedureName = "laundry_ItemServiceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * laundryServiceUserTypeRoutines routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "laundryServiceUserTypeRoutines", procedureName = "laundry_userTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * laundryItemPriceRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "laundryItemPriceRoutines", procedureName = "laundry_itemPriceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * laundryDropdownRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "laundryDropdownRoutines", procedureName = "laundry_dropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * Laundry ReturnIN routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "laundryReturnInRoutines", procedureName = "laundry_returnInRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Restaurant RestaurantDashboardRoutines routine Stored Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "RestaurantDashboardRoutines", procedureName = "restaurant_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * Restaurant mealTypeRoutines routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "mealTypeRoutines", procedureName = "restaurant_mealTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Restaurant restaurant_tableRoutines routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "tableRoutines", procedureName = "restaurant_tableRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * restaurant_menu itemRoutines Routines
		 */
		@NamedStoredProcedureQuery(name = "itemRoutines", procedureName = "restaurant_itemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * restaurant_tablebookRoutinesRoutines
		 */
		@NamedStoredProcedureQuery(name = "bookRoutines", procedureName = "restaurant_bookRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * restaurantDropdownRoutines
		 */
		@NamedStoredProcedureQuery(name = "restaurantDropdownRoutines", procedureName = "restaurant_counter_dropdownRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * restaurantFoodOrderRoutines
		 */
		@NamedStoredProcedureQuery(name = "restaurantFoodOrderRoutines", procedureName = "restaurant_counter_foodOrderRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * restaurantMenuItemPriceMasterRoutines
		 */
		@NamedStoredProcedureQuery(name = "restaurantMenuItemPriceMasterRoutines", procedureName = "restaurant_menuItemPriceMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * restaurant_assignTableStaffRoutines
		 */
		@NamedStoredProcedureQuery(name = "assignTableStaffRoutines", procedureName = "restaurant_assignTableStaffRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * restaurant_shiftRoutines
		 */
		@NamedStoredProcedureQuery(name = "shiftRoutines", procedureName = "restaurant_shiftRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * restaurant_menuItemCategoryRoutines
		 */
		@NamedStoredProcedureQuery(name = "menuItemCategoryRoutines", procedureName = "restaurant_menuItemCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// master_acvtivityMasterRoutines
		@NamedStoredProcedureQuery(name = "activityRoutines", procedureName = "master_acvtivityMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// master_functionMasterRoutines
		@NamedStoredProcedureQuery(name = "functionRoutines", procedureName = "master_functionMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// master_moduleMasterRoutines
		@NamedStoredProcedureQuery(name = "moduleRoutines", procedureName = "master_moduleMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * housekeeping dashboard
		 */
		@NamedStoredProcedureQuery(name = "HousekeepingDashboardRoutines", procedureName = "housekeeping_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * housekeeping_taskRoutines
		 */
		@NamedStoredProcedureQuery(name = "taskRoutinesMaster", procedureName = "housekeeping_taskRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * housekeeping_taskRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "taskRoutines", procedureName = "housekeeping_propertyTaskRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * housekeeping_AssignStaffRoutines
		 */
		@NamedStoredProcedureQuery(name = "AssignStaffRoutines", procedureName = "housekeeping_AssignStaffRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * housekeeping_MaidPropertyTask
		 */

		@NamedStoredProcedureQuery(name = "MaidPropertyTask", procedureName = "housekeeping_MaidPropertyTask", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * housekeeping_maidTaskAssignRoutines
		 */
		@NamedStoredProcedureQuery(name = "maidTaskAssignRoutines", procedureName = "housekeeping_maidTaskAssignRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * housekeeping_guestConsumeRoutines
		 */
		@NamedStoredProcedureQuery(name = "guestConsumeRoutines", procedureName = "roomservice_guestConsumeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * assignKitchenToRestaurantRoutines
		 */

		@NamedStoredProcedureQuery(name = "assignKitchenToRestaurantRoutines", procedureName = "kitchen_assignKitchenToRestaurantRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * kitchen_foodOrderListRoutines
		 */
		@NamedStoredProcedureQuery(name = "foodOrderListRoutines", procedureName = "kitchen_foodOrderListRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * kitchen_kitchenManagerRoutines
		 */
		@NamedStoredProcedureQuery(name = "kitchenManagerRoutines", procedureName = "kitchen_kitchenManagerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * gym_lockermasterRoutines
		 */
		@NamedStoredProcedureQuery(name = "lockerRoutines", procedureName = "gym_lockermasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * gym_assign_lockerRoutines
		 */
		@NamedStoredProcedureQuery(name = "assignLocker", procedureName = "gym_assign_lockerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * gym_transaction_Routines
		 */
		@NamedStoredProcedureQuery(name = "gymTransaction", procedureName = "gym_transaction_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * roomservice_roomServiceTask
		 */
		@NamedStoredProcedureQuery(name = "roomServiceRoutines", procedureName = "roomservice_roomServiceTask", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * roomservice_RoomServiceTaskAssigned
		 */
		@NamedStoredProcedureQuery(name = "roomTaskAssignRoutines", procedureName = "roomservice_RoomServiceTaskAssigned", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * other_service_masterRoutines
		 */
		@NamedStoredProcedureQuery(name = "otherServiceRoutines", procedureName = "other_service_masterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * other_service_PriceRoutines
		 */
		@NamedStoredProcedureQuery(name = "otherServicePriceRoutines", procedureName = "other_service_PriceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure memberMstrRoutines
		 */
		@NamedStoredProcedureQuery(name = "memberMstrRoutines", procedureName = "user_memberMstrRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure member registration
		 */
		@NamedStoredProcedureQuery(name = "userMemRegRoutines", procedureName = "user_userMemRegRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure parking_resrveParkingRoutines
		 */
		@NamedStoredProcedureQuery(name = "resrveParkingRoutines", procedureName = "parking_resrveParkingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure parking_vehicleTypeRoutines
		 */
		@NamedStoredProcedureQuery(name = "vehicleTypeRoutines", procedureName = "parking_vehicleTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure parking_parkingCapacityRoutines
		 */
		@NamedStoredProcedureQuery(name = "parkingCapacityRoutines", procedureName = "parking_parkingCapacityRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure parking_entryVehicleRoutines
		 */
		@NamedStoredProcedureQuery(name = "entryVehicleRoutines", procedureName = "parking_entryVehicleRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure parking_dashboardRoutines
		 */
		@NamedStoredProcedureQuery(name = "dashboardRoutines", procedureName = "parking_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure sales_salesCustomerRoutines
		 */
		@NamedStoredProcedureQuery(name = "salesCustomerRoutines", procedureName = "sales_salesCustomerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure sales_quotationRotines
		 */
		@NamedStoredProcedureQuery(name = "quotationRotines", procedureName = "sales_quotationRotines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure sales_salesInvoiceRoutiness
		 */
		@NamedStoredProcedureQuery(name = "salesInvoiceRoutiness", procedureName = "sales_salesInvoiceRoutiness", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * master_masterCountryRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "masterCountryRoutines", procedureName = "master_masterCountryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure sales_saleDashboardone
		 */
		@NamedStoredProcedureQuery(name = "salesDashboardoneRoutiness", procedureName = "sale_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure account_bankRoutines
		 */
		@NamedStoredProcedureQuery(name = "AccountBankRoutines", procedureName = "account_bankRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure account_bankBranchRoutines
		 */
		@NamedStoredProcedureQuery(name = "AccountBankBranchRoutines", procedureName = "account_bankBranchRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure account_bankAccountRoutines
		 */
		@NamedStoredProcedureQuery(name = "AccountBankAccountRoutines", procedureName = "account_bankAccountRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure account_Account LedgerRoutines
		 */
		@NamedStoredProcedureQuery(name = "accountLedgerRoutines", procedureName = "account_accountLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * routine Stored Procedure logo
		 */
		@NamedStoredProcedureQuery(name = "logoImageRoutines", procedureName = "logo_logoImageRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for inventory purchase order
		@NamedStoredProcedureQuery(name = "purchasVoucher", procedureName = "inventory_purchase_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for inventory purchase order
		@NamedStoredProcedureQuery(name = "journalVoucher", procedureName = "account_journal_voucher_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for inventory account head type
		@NamedStoredProcedureQuery(name = "accountHead", procedureName = "account_head_type_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// for inventory purchase order
		@NamedStoredProcedureQuery(name = "paymentVoucher", procedureName = "inventory_payment_voucher_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "salesInvReturnRoutines", procedureName = "sales_salesInvReturnRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "creditNoteRoutines", procedureName = "sales_creditNoteRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventory_debitNoteRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "debitNoteRoutines", procedureName = "inventory_debitNoteRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "contraVoucherRoutines", procedureName = "account_contraVoucherRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * routine Stored Procedure account_Credit LedgerRoutines
		 */
		@NamedStoredProcedureQuery(name = "creditLedgerRoutines", procedureName = "account_creditLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure account_Debit LedgerRoutines
		 */
		@NamedStoredProcedureQuery(name = "debitLedgerRoutines", procedureName = "account_debitLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * for trial balance
		 */
		@NamedStoredProcedureQuery(name = "trialBalanceRoutines", procedureName = "account_trial_balance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for cash book
		 */
		@NamedStoredProcedureQuery(name = "cashBookRoutines", procedureName = "account_cash_book_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * routine Stored Procedure Purchase Ledger Routines
		 */
		@NamedStoredProcedureQuery(name = "purchaseRoutines", procedureName = "account_purchaseLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure Purchase Ledger Routines
		 */
		@NamedStoredProcedureQuery(name = "incomeTaxRoutines", procedureName = "account_incomeTaxPayableRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/*
		 * routine Stored Procedure Sales Ledger Routines
		 */
		@NamedStoredProcedureQuery(name = "salesRoutines", procedureName = "account_salesLedgerRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "tableStatus", procedureName = "restaurant_tableStatusRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * for employment master
		 */
		@NamedStoredProcedureQuery(name = "EmploymentMaster", procedureName = "hrm_employment_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for job title master
		 */
		@NamedStoredProcedureQuery(name = "JobTypeMaster", procedureName = "hrm_jobType_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for department master
		 */
		@NamedStoredProcedureQuery(name = "departmentMaster", procedureName = "hrm_department_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for skill master
		 */
		@NamedStoredProcedureQuery(name = "skillMaster", procedureName = "hrm_skill_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for qualification master
		 */
		@NamedStoredProcedureQuery(name = "qualificationMaster", procedureName = "hrm_qualification_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for certification master
		 */
		@NamedStoredProcedureQuery(name = "certificationMaster", procedureName = "hrm_certification_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for language master
		 */
		@NamedStoredProcedureQuery(name = "languageMaster", procedureName = "hrm_language_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee
		 */
		@NamedStoredProcedureQuery(name = "Employee", procedureName = "hrm_employee_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Skill assign
		 */
		@NamedStoredProcedureQuery(name = "EmployeeSkillAssign", procedureName = "hrm_employee_skill_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Education assign
		 */
		@NamedStoredProcedureQuery(name = "EmployeeEducationAssign", procedureName = "hrm_employee_education_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Education assign getAssignCertDetails
		 */
		@NamedStoredProcedureQuery(name = "EmployeecertificationAssign", procedureName = "hrm_employee_certification_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Education assign getAssignCertDetails
		 */
		@NamedStoredProcedureQuery(name = "EmployeeLanguageAssign", procedureName = "hrm_employee_language_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Supervisor master
		 */
		@NamedStoredProcedureQuery(name = "supervisorMaster", procedureName = "hrm_supervisor_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for employee dependent
		 */
		@NamedStoredProcedureQuery(name = "EmployeedependentAssign", procedureName = "hrm_employee_dependent_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for emergency
		 */
		@NamedStoredProcedureQuery(name = "emergencyMaster", procedureName = "hrm_emergency_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "attendenceRoutines", procedureName = "hrms_AttendenceDetailsRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "holidayMasterRoutines", procedureName = "hrms_holidayMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "workWeekMasterRoutines", procedureName = "hrms_workWeekMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * All Leave Applied by employee Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leaveApplyAdminRoutines", procedureName = "hrms_leaveApplyAdminRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Apply Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leaveApplyRoutines", procedureName = "hrms_leaveApplyRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Approved Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leaveApprovedRoutines", procedureName = "hrms_leaveApprovedRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Cancelled Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leaveCancelledRoutines", procedureName = "hrms_leaveCancelledRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Entitle Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leaveEntitleRoutines", procedureName = "hrms_leaveEntitleRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Pending Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leavePendingRoutines", procedureName = "hrms_leavePendingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Period Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leavePeriodRoutines", procedureName = "hrms_leavePeriodRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Rejected Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leaveRejectedRoutines", procedureName = "hrms_leaveRejectedRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Rule Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leaveRuleRoutines", procedureName = "hrms_leaveRuleRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Leave Rule Routines Stored Procedure definition hrm_Reimbursement_Routines
		 */
		@NamedStoredProcedureQuery(name = "reimbursementRoutines", procedureName = "hrm_Reimbursement_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Leave Type Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "leaveTypeRoutines", procedureName = "hrms_leaveTypeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Leave Type Routines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "reimbursementTypeMaster", procedureName = "hrm_reimbursement_type_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Department Job Title Assign
		 */
		@NamedStoredProcedureQuery(name = "JobTitleAssign", procedureName = "hrm_department_jobtitle_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for traveling requisition
		 */
		@NamedStoredProcedureQuery(name = "TravelingRequisitionMaster", procedureName = "hrm_traveling_requisition_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for reimbursement payment
		 */
		@NamedStoredProcedureQuery(name = "reimbursementPaymentRoutines", procedureName = "hrm_reimbursement_payment_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * * for reimbursement payment
		 */
		@NamedStoredProcedureQuery(name = "policyTypeMaster", procedureName = "hrm_policy_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/*
		 * * for BeautyDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "BeautyDashboardRoutines", procedureName = "beautyparlour_BeautyParlourDashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/*
		 * * for FrontdeskDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "FrontdeskDashboardRoutines", procedureName = "frontdesk_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for GymDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "GymDashboardRoutines", procedureName = "gym_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for KitchenDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "KitchenDashboardRoutines", procedureName = "kitchen_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for laundryDashboardRoutines sonam 0901
		 */

		/*
		 * * for NightClubDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "NightClubDashboardRoutines", procedureName = "nightclub_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * * for NightClubDashboardRoutines sonam 0901
		 */
		@NamedStoredProcedureQuery(name = "RestaurantStaffDashboardRoutines", procedureName = "restaurant_staffDashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for spa Dashboard Routines sonam 0901
		 * 
		 */
		@NamedStoredProcedureQuery(name = "SpaDashboardRoutines", procedureName = "spa_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for superadmin Dashboard Routines sonam 0901
		 * 
		 */
		@NamedStoredProcedureQuery(name = "userDashboardRoutines", procedureName = "user_dashboardRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for master_serviceRoutines Routines sagar 13012020
		 * 
		 */

		@NamedStoredProcedureQuery(name = "serviceRoutines", procedureName = "master_serviceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for restaurant_menuCourseRoutines Routines sagar 13012020
		 * 
		 */
		@NamedStoredProcedureQuery(name = "menuCourseRoutines", procedureName = "restaurant_menuCourseRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * sub group name Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "SubGroupName", procedureName = "SubGroupName_procedure", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Store master routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "storeMasterRoutines", procedureName = "master_storeMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * Godown master routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "godownMasterRoutines", procedureName = "master_godownMasterRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * employee routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "KRAMeasureRoutine", procedureName = "hrm_employee_KRAMeasureRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * for Employee Goal Master
		 */
		@NamedStoredProcedureQuery(name = "GoalMaster", procedureName = "hrm_goal_master_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * for Employee Appraisal Details
		 */
		@NamedStoredProcedureQuery(name = "EmployeeAppraisalDetails", procedureName = "hrm_employee_appraisal_review_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * Appraisal Form routine Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "AppraisalFormApproval", procedureName = "hrm_appraisalFormApproval_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "documentRoutines", procedureName = "document_DocumentRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "masterCategoryRoutines", procedureName = "master_masterCategoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * view ticket Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "invjournalvoucherPaymentRoutines", procedureName = "account_journal_voucher_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		@NamedStoredProcedureQuery(name = "inventoryStockTransferRoutines", procedureName = "inventory_inventoryStockTransferRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		@NamedStoredProcedureQuery(name = "saleDelChallanRoutines", procedureName = "sales_saleDel_Maharaja_ChallanRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * inventoryDamagedItemRoutines Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "damagedItemRoutines", procedureName = "inventory_inventoryDamagedItemRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "entryRoutines", procedureName = "gatepass_entryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "assignAssetVehicleRoutines", procedureName = "asset_assignAssetVehicleRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for delivery challan
		 */
		@NamedStoredProcedureQuery(name = "DeliverChallanRoutines", procedureName = "sales_delivery_challan_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "sandQualityControl", procedureName = "quality_control_sand_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * quality Production Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "QualityProduction", procedureName = "quality_control_production_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "assignVehicleDriverRoutines", procedureName = "asset_assignVehicleDriverRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "fuelConsumption", procedureName = "asset_fuel_consumption_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "assetPolicy", procedureName = "asset_policy_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "outRoutines", procedureName = "gatepass_outRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "productionPlanningRoutines", procedureName = "Production_Planning_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "productionPlanningTempRoutines", procedureName = "production_planningTempRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "productionGrade", procedureName = "production_GradeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/**
		 * Mother Coil Slit Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "motherCoilRoutines", procedureName = "production_motherCoil_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Mother Coil Slit Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "pipeProductionRoutines", procedureName = "production_pipeProduction_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * Mother Coil Slit Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "pipePolishingRoutines", procedureName = "production_pipePolishing_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * pipe packaging Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "pipePackagingRoutines", procedureName = "production_pipePackaging_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		/**
		 * pipe Scrap Procedure definition
		 */

		@NamedStoredProcedureQuery(name = "pipeScrapRoutines", procedureName = "production_pipeScrap_Routine", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "gatePassEntryRoutines", procedureName = "gatepass_gatePassEntryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "gatePassOutRoutines", procedureName = "gatepass_gatePassOutRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "batchCodeRoutines", procedureName = "inventory_batchCodeRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "assignSlitWidth", procedureName = "production_assignSlitWidth", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		@NamedStoredProcedureQuery(name = "menuItemStockRoutines", procedureName = "restaurant_menuItemStockRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// sale order add
		@NamedStoredProcedureQuery(name = "SaleOrderRotines", procedureName = "sales_sale_order_Rotines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// sale order add
		@NamedStoredProcedureQuery(name = "salesCounterInvoiceRoutines", procedureName = "sales_salesCounterInvoiceRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// for customer item assign
		@NamedStoredProcedureQuery(name = "Customer_Item_Rutines", procedureName = "inventory_Customer_Item_Rutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		// for assign stock price
		@NamedStoredProcedureQuery(name = "AssignStockPriceRutines", procedureName = "inventory_Assign_StockPrice_Rutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// for assign stock price
		@NamedStoredProcedureQuery(name = "vendor_Item_asgn_Rutines", procedureName = "inventory_vendor_Item_asgn_Rutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for multiple grn
		@NamedStoredProcedureQuery(name = "multipleGRNRoutines", procedureName = "inventory_multipleGRNRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for gocool production plan
		@NamedStoredProcedureQuery(name = "gocool-prod-planning", procedureName = "Production_Prod_Gocool_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		// for gocool production add mix
		@NamedStoredProcedureQuery(name = "gocool-prod-add-mix", procedureName = "Production_Gocool_Mix_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for gocool production add packaging
		@NamedStoredProcedureQuery(name = "gocool-prod-packaging", procedureName = "Production_Prod_Pack_Gocool_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for gocool production
		@NamedStoredProcedureQuery(name = "gocool_production", procedureName = "Production_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		// for batch details
		@NamedStoredProcedureQuery(name = "ProductItemRutines", procedureName = "inventory_Product_Item_Rutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }
		),
		/** SUB-INVENTORY **/
		@NamedStoredProcedureQuery(name = "subInventoryRoutines", procedureName = "inventory_subInventoryRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/** WAREHOUSE **/
		@NamedStoredProcedureQuery(name = "warehouseRoutines", procedureName = "inventory_warehouseRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/** WAREHOUSE **/
		@NamedStoredProcedureQuery(name = "rackShelvesRoutines", procedureName = "inventory_rackShelvesRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		// for batch details
		@NamedStoredProcedureQuery(name = "production_return", procedureName = "Production_Return_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }
		
				),
		
		/**
		 * view advance payment Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "advancePaymentMasterRoutines", procedureName = "hrm_employee_advance_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		@NamedStoredProcedureQuery(name = "foodTracking", procedureName = "hrms_foodTrackingRoutines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		/*
		 * for employee income tax
		 */
		@NamedStoredProcedureQuery(name = "emplyeeIncomeTaxRoutines", procedureName = "hrms_income_tax_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),

		/**
		 * trip bonous Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "tripBonousRoutines", procedureName = "hrm_employee_trip_bonous_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),

		/**
		 * trip bonous Stored Procedure definition
		 */
		@NamedStoredProcedureQuery(name = "dailyExcelUpload", procedureName = "hrm_daily_excel_Routines", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }

		),
		
		@NamedStoredProcedureQuery(name = "EmployeePayRoll", procedureName = "hrm_employeePayRoll_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		@NamedStoredProcedureQuery(name = "gradeSalaryRoutines", procedureName = "hrm_grade_salary_master_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		@NamedStoredProcedureQuery(name = "salaryComponentsMstrRoutines", procedureName = "hrm_salary_component_master_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		@NamedStoredProcedureQuery(name = "offerLetterRoutines", procedureName = "hrm_offerLetterDetails_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		
		/*	
		 * for salary details	
		 */	
		@NamedStoredProcedureQuery(name = "salary_routines", procedureName = "hrms_salary_details", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),
		
		/*	
		 * for leave details	
		 */	
		// hrms_leave_details	
		@NamedStoredProcedureQuery(name = "leave_routines", procedureName = "hrm_employee_advance_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		@NamedStoredProcedureQuery(name = "jobCardRoutines", procedureName = "asset_add_job_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		@NamedStoredProcedureQuery(name = "employeeLeaveRoutine", procedureName = "employee_leave_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		/**	
		 * for organization structure	
		 */	
		@NamedStoredProcedureQuery(name = "orgStructure", procedureName = "hrms_org_structure_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
		/** GRADE MASTER **/	
		@NamedStoredProcedureQuery(name = "masterGradeRoutines", procedureName = "master_masterGradeRoutines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		/**	
		 * for performance Goal	
		 */	
		@NamedStoredProcedureQuery(name = "OrganizationRoutine", procedureName = "hrm_organization_Routine", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
		/*	
		 * * for recruitment routines	
		 */	
		@NamedStoredProcedureQuery(name = "recruitment", procedureName = "hrms_jobtitle_routienes", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
		/*	
		 * * for requistionRoutines	
		 */	
		@NamedStoredProcedureQuery(name = "requistionRoutines", procedureName = "hrm_RequistionRoutines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
		/*	
		 * * for specficTypeRoutines	
		 */	
		@NamedStoredProcedureQuery(name = "specficTypeRoutines", procedureName = "hrms_specficTypeRoutines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		/*	
		 * * for questionTypeRoutines	
		 */	
		@NamedStoredProcedureQuery(name = "exitmanagement", procedureName = "exitManagement_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
		@NamedStoredProcedureQuery(name = "exitInitiate", procedureName = "exitInitiate_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
		@NamedStoredProcedureQuery(name = "exitFinance", procedureName = "exitFinance_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
			
		/*	
		 * Resource Routines	
		 */	
		@NamedStoredProcedureQuery(name = "resourceRoutines", procedureName = "recruitment_resource_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
		/** for shift management master **/	
		@NamedStoredProcedureQuery(name = "rshiftRoutines", procedureName = "hrm_ShiftRoutines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }),	
		/*	
		 * * for trainingCreation routines	
		 */	
		@NamedStoredProcedureQuery(name = "trainingCreation", procedureName = "hrms_Training_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		),	
		/*	
		 * * for trainingCreation routines	
		 */	
		@NamedStoredProcedureQuery(name = "gradeRevisionRoutines", procedureName = "grade_Revision_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
			
				),	
		/*	
		 * * for trainingCreation routines	
		 */	
		@NamedStoredProcedureQuery(name = "workSheetPlanningRoutines", procedureName = "work_sheet_planning_Routines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
			
				),	
		@NamedStoredProcedureQuery(name = "questionTypeRoutines", procedureName = "hrms_questionTypeRoutines", parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionType", type = String.class),	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "actionValue", type = String.class) }	
		) 

})
/**
 * @author NirmalyaLabs
 *
 */
public class BaseEntityClass {

	@Id
	private Integer pKey;

	public BaseEntityClass() {
		super();
	}

	public Integer getpKey() {
		return pKey;
	}

	public void setpKey(Integer pKey) {
		this.pKey = pKey;
	}

	/**
	 * Overrides toString method for converting class to string and back
	 **/
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
