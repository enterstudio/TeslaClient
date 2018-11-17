/*
 * DriveState.java - Copyright(c) 2013 Joe Pasqua
 * Provided under the MIT License. See the LICENSE file for details.
 * Created: Jul 5, 2013
 */

package org.noroomattheinn.tesla;

import java.util.Date;

import us.monoid.json.JSONObject;

/**
 * DrivingState: Stores the driving state of the vehicle. This includes
 * the location and heading.
 *
 * @author Joe Pasqua <joe at NoRoomAtTheInn dot org>
 */

public class DriveState extends BaseState {
/*------------------------------------------------------------------------------
 *
 * Public State
 * 
 *----------------------------------------------------------------------------*/
    public final double   latitude;
    public final double   longitude;
    public final int      heading;
    public final int      gpsAsOf;
    public final String   shiftState;   // Not clear what this represents or its type
    public final String   speed;        // Not clear what this represents or its type
    
/*==============================================================================
 * -------                                                               -------
 * -------              Public Interface To This Class                   ------- 
 * -------                                                               -------
 *============================================================================*/
    
    public DriveState(JSONObject source) {
        super(source);
        latitude = source.optDouble("latitude"); 
        longitude = source.optDouble("longitude"); 
        heading = source.optInt("heading"); 
        gpsAsOf = source.optInt("gps_as_of"); 
        shiftState = source.optString("shift_state"); 
        speed = source.optString("speed"); 
    }
    
    @Override public String toString() {
        return String.format(
            ", Location: (%3.5f, %3.5f)" +
            ", Heading: %d" +
            ", Shift State: %s" +
            ", GPS as of time: %s",
            latitude, longitude, heading, shiftState, new Date(gpsAsOf*1000));
    }
}
