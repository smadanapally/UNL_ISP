/**
 * 
 */
package beans;

/**
 * @author Admin
 *
 */
public class Transaction {

	private int account_id;
	private int holder_id;
	private int routing_number;
	private double balance;
	/**
	 * @param account_id
	 * @param holder_id
	 * @param routing_number
	 * @param balance
	 */
	public Transaction(int account_id, int holder_id, int routing_number,
			double balance) {
		super();
		this.account_id = account_id;
		this.holder_id = holder_id;
		this.routing_number = routing_number;
		this.balance = balance;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getHolder_id() {
		return holder_id;
	}
	public void setHolder_id(int holder_id) {
		this.holder_id = holder_id;
	}
	public int getRouting_number() {
		return routing_number;
	}
	public void setRouting_number(int routing_number) {
		this.routing_number = routing_number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}
