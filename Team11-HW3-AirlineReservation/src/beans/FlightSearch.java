/**
 * 
 */
package beans;

import java.util.Date;

/**
 * @author Admin
 *
 */
public class FlightSearch {
	String source;
	String destination;
	String comfort;
	Date doj;
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

	public String getComfort() {
		return comfort;
	}

	public void setComfort(String comfort) {
		this.comfort = comfort;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	
	
	public FlightSearch(String source,String destination,String comfort,Date doj){
		this.source=source;
		this.comfort=comfort;
		this.destination=destination;
		this.doj=doj;
	}

}
