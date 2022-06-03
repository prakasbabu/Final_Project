package com.example.final_project;


public class Data {
	protected int id;
	protected int area;
	protected String object;
	protected int temperature;
	protected int longitude;
	protected int latitude;
	protected String weather;

	public Data() {

	}

	public Data(int id, int area, String object, int temperature, int longitude, int latitude, String weather) {
		this.id = id;
		this.area = area;
		this.object = object;
		this.temperature = temperature;
		this.longitude = longitude;
		this.latitude = latitude;
		this.weather = weather;
	}

	public Data(int area ,String object, int temperature, int longitude, int latitude, String weather) {

		this.area = area;
		this.object = object;
		this.temperature = temperature;
		this.longitude = longitude;
		this.latitude = latitude;
		this.weather = weather;
	}

	public int getId() {
		return id;
	}


	public int getArea() {
		return area;
	}


	public String getObject() {
		return object;
	}


	public int getTemperature() {
		return temperature;
	}

	public int getLongitude() {
		return longitude;
	}


	public int getLatitude() {
		return latitude;
	}


	public String getWeather() {
		return weather;
	}


}