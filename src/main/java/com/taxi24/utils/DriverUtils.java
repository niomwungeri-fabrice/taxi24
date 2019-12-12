/**
 * 
 */
package com.taxi24.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author niyomwungeri
 *
 */
public class DriverUtils {
	public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if(unit == null) {
				unit = "K";
			}
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			}
			return (dist);
		}
	}
}
