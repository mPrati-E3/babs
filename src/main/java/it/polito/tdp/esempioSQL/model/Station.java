package it.polito.tdp.esempioSQL.model;

public class Station {
	
	private int id;
	private String Name;
	private int DockCount;
	private String Landmark;
	
	public Station(int id, String name, int dockCount, String landmark) {
		super();
		this.id = id;
		Name = name;
		DockCount = dockCount;
		Landmark = landmark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getDockCount() {
		return DockCount;
	}

	public void setDockCount(int dockCount) {
		DockCount = dockCount;
	}

	public String getLandmark() {
		return Landmark;
	}

	public void setLandmark(String landmark) {
		Landmark = landmark;
	}
	
	

}
