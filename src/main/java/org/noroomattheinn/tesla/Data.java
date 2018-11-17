/*
 * ChargeState.java - Copyright(c) 2013 Joe Pasqua
 * Provided under the MIT License. See the LICENSE file for details.
 * Created: Jul 5, 2013
 */

package org.noroomattheinn.tesla;

import us.monoid.json.JSONObject;

/**
 * ChargeState: Retrieve the charging state of the vehicle.
 * NOTE: A call to refresh MUST be made before accessing the content of the
 * state. Future calls to refresh may be made to get updated versions of the
 * state.
 *
 * @author Joe Pasqua <joe at NoRoomAtTheInn dot org>
 */

public class Data extends BaseState {
    
/*==============================================================================
 * -------                                                               -------
 * -------              Public Interface To This Class                   ------- 
 * -------                                                               -------
 *============================================================================*/
    
    public Data() { this(emptyJSONObj); }
    
    public Data(JSONObject source) {
        super(source);
        System.out.println(source);
    }

//    @Override public String toString() {
//        return String.format(
//            "    Estimated, Ideal, Rated: (%3.1f, %3.1f, %3.1f)\n" +
//            "    SOC: %d%%", 
//            estimatedRange, idealRange, range, batteryPercent);
//    }
}
