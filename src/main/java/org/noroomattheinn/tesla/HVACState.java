/*
 * HVACState.java - Copyright(c) 2013 Joe Pasqua
 * Provided under the MIT License. See the LICENSE file for details.
 * Created: Jul 5, 2013
 */

package org.noroomattheinn.tesla;

import org.noroomattheinn.utils.Utils;

import us.monoid.json.JSONObject;

/**
 * HVACState: Stores the state of the HVAC system.
 *
 * @author Joe Pasqua <joe at NoRoomAtTheInn dot org>
 */

public class HVACState extends BaseState {
/*------------------------------------------------------------------------------
 *
 * Public State
 * 
 *----------------------------------------------------------------------------*/
    public final double  insideTemp;
    public final double  outsideTemp;
    public final double  driverTemp;
    public final double  passengerTemp;
    public final boolean autoConditioning;
    public final int     isFrontDefrosterOn;
    public final boolean isRearDefrosterOn;
    public final int     fanStatus;
    
/*==============================================================================
 * -------                                                               -------
 * -------              Public Interface To This Class                   ------- 
 * -------                                                               -------
 *============================================================================*/
    
    public HVACState(JSONObject source) {
        super(source);
        insideTemp = source.optDouble("inside_temp"); 
        outsideTemp = source.optDouble("outside_temp"); 
        driverTemp = source.optDouble("driver_temp_setting"); 
        passengerTemp = source.optDouble("passenger_temp_setting"); 
        autoConditioning = source.optBoolean("is_auto_conditioning_on"); 
        isFrontDefrosterOn = source.optInt("is_front_defroster_on"); 
        isRearDefrosterOn = source.optBoolean("is_rear_defroster_on"); 
        fanStatus = source.optInt("fan_status"); 
    }
    
    @Override public String toString() {
        return String.format(
            ", Inside Temp: %3.0f" +
            ", Outside Temp: %3.0f" +
            ", Driver Setpoint: %3.0f" +
            ", Passenger Setpoint: %3.0f" +
            ", HVAC On: %s" +
            ", Front Defroster On: %d" +
            ", Rear Defroster On: %s" +
            ", Fan Setting: %d", 
            Utils.cToF(insideTemp),
            Utils.cToF(outsideTemp),
            Utils.cToF(driverTemp),
            Utils.cToF(passengerTemp),
            Utils.yesNo(autoConditioning),
            isFrontDefrosterOn,
            Utils.yesNo(isRearDefrosterOn),
            fanStatus
            );
    }
    
}
