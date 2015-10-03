/**
 * 
 */
package beans;

import java.util.Date;

/**
 * @author Vishnu
 *
 */
public class Booking {
	private int booking_id;
	private Date date_of_booking;
	private int flight_ids;
	private int number_of_seats;
	private int account_id;
	private int user_id;
	private double total_cost;
	private Flight wings;
	/**
	 * @param booking_id
	 * @param date_of_booking
	 * @param flight_ids
	 * @param number_of_seats
	 * @param account_id
	 * @param user_id
	 * @param total_cost
	 */
	public Booking()
	{
		
	}
	public Booking(int booking_id, Date date_of_booking, int flight_ids,
			int number_of_seats, int account_id, int user_id, double total_cost) {
		super();
		this.booking_id = booking_id;
		this.date_of_booking = date_of_booking;
		this.flight_ids = flight_ids;
		this.number_of_seats = number_of_seats;
		this.account_id = account_id;
		this.user_id = user_id;
		this.total_cost = total_cost;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public Date getDate_of_booking() {
		return date_of_booking;
	}
	public void setDate_of_booking(Date date_of_booking) {
		this.date_of_booking = date_of_booking;
	}
	public int getFlight_ids() {
		return flight_ids;
	}
	public void setFlight_ids(int flight_ids) {
		this.flight_ids = flight_ids;
	}
	public int getNumber_of_seats() {
		return number_of_seats;
	}
	public void setNumber_of_seats(int number_of_seats) {
		this.number_of_seats = number_of_seats;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	public Flight getWings() {
		return wings;
	}
	public void setWings(Flight wings) {
		this.wings = wings;
	}

}
