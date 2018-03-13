package com.airtel.problem.entity;

public class EventDetails  {
private String appVersion;
private String gender;
private String appPlatform;
private String evSource;
private String ipAddress;
private String eventType;
private String ua;
private String deviceId;
private String userId;
private String deviceNetwork;
private String osVersion;
private String scrResolution;
private String siteId;
private String eventName;
private String cid;
private String ts;


public EventDetails() {
	super();
}
public EventDetails(String appVersion, String gender, String appPlatform, String evSource, String ipAddress, String eventType,
		String ua, String deviceId, String userId, String deviceNetwork, String osVersion, String scrResolution,
		String siteId, String eventName, String cid, String ts) {
	super();
	this.appVersion = appVersion;
	this.gender = gender;
	this.appPlatform = appPlatform;
	this.evSource = evSource;
	this.ipAddress = ipAddress;
	this.eventType = eventType;
	this.ua = ua;
	this.deviceId = deviceId;
	this.userId = userId;
	this.deviceNetwork = deviceNetwork;
	this.osVersion = osVersion;
	this.scrResolution = scrResolution;
	this.siteId = siteId;
	this.eventName = eventName;
	this.cid = cid;
	this.ts = ts;
}
public String getAppVersion() {
	return appVersion;
}
public String getGender() {
	return gender;
}
public String getAppPlatform() {
	return appPlatform;
}
public String getEvSource() {
	return evSource;
}
public String getIpAddress() {
	return ipAddress;
}
public String getEventType() {
	return eventType;
}
public String getUa() {
	return ua;
}
public String getDeviceId() {
	return deviceId;
}
public String getUserId() {
	return userId;
}
public String getDeviceNetwork() {
	return deviceNetwork;
}
public String getOsVersion() {
	return osVersion;
}
public String getScrResolution() {
	return scrResolution;
}
public String getSiteId() {
	return siteId;
}
public String getEventName() {
	return eventName;
}
public String getCid() {
	return cid;
}
public String getTs() {
	return ts;
}


}
