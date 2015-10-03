/**
 * 
 */
package beans;

import java.util.Date;

/**
 * @author Admin
 *
 */
public class Flight {
	private int id;
	private int flightno;
	private String plane;
	private String source;
	private String destination;
	private int first_class_reserved;
	private int business_reserved;
	private int economy_reserved;
	private Date departure;
	private Date arrival;
	
	public Flight(int flightno,String source, String destination,int first_class_reserved,String operator){
		
		this.flightno=flightno;
		this.source = source;
		this.destination = destination;
		this.first_class_reserved = first_class_reserved;
		this.plane=operator;
	}
	
	public Flight(int id,int flightno,String plane, String source, String destination, int first_class_reserved, int business_reserved,
			int economy_reserved, Date departure, Date arrival) {
		super();
		this.id=id;
		this.flightno=flightno;
		this.plane = plane;
		this.source = source;
		this.destination = destination;
		this.first_class_reserved = first_class_reserved;
		this.business_reserved = business_reserved;
		this.economy_reserved = economy_reserved;
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFlightno()
	{
		return flightno;
	}
	public void setFLightno()
	{
		this.flightno=flightno;
	}
	public String getPlane() {
		return plane;
	}
	public void setPlane(String plane) {
		this.plane = plane;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getFirst_class_reserved() {
		return first_class_reserved;
	}
	public void setFirst_class_reserved(int first_class_reserved) {
		this.first_class_reserved = first_class_reserved;
	}
	public int getBusiness_reserved() {
		return business_reserved;
	}
	public void setBusiness_reserved(int business_reserved) {
		this.business_reserved = business_reserved;
	}
	public int getEconomy_reserved() {
		return economy_reserved;
	}
	public void setEconomy_reserved(int economy_reserved) {
		this.economy_reserved = economy_reserved;
	}
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Date departure) {
		this.departure = departure;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}
	/**
	 * @param plane
	 * @param source
	 * @param destination
	 * @param first_class_reserved
	 * @param business_reserved
	 * @param economy_reserved
	 * @param departure
	 * @param arrival
	 */


}
