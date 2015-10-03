
package utilities;

/**
 * @author Admin
 *
 */

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	
	/**
	 * @author Admin
	 *
	 */
	public class BankingDao {


		public boolean validateAccount(Transaction transaction )
		{
			boolean flag=false;
			Connection connection = null;
			try {
				connection = DBConnection.getInstance().getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String query = "select balance from vsivadas.accounts where account_id=? AND routing_number=? AND holder_id=?";
			java.sql.PreparedStatement ps = null;
			ResultSet rs=null;
			try {
				ps=connection.prepareStatement(query);
				ps.setInt(1, transaction.getAccount_id());
				ps.setInt(2, transaction.getRouting_number());
				ps.setInt(3,transaction.getHolder_id());
				rs=ps.executeQuery();
				
				
				if (rs.next())
				{
					
					if(rs.getDouble("balance")>=transaction.getBalance())
						{
							updateBalance(transaction.getBalance(),transaction.getAccount_id());
						flag=true;
						}
					
					
				}
				else
					flag=false;
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					connection.close();
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		
			return flag;
			
		
		}
		public Integer getBalance()
		{
			
			
			
			
			return null;
		}
		public boolean updateBalance(double amount,int id)
		{
			double finalamount=0;
			boolean flag=false;
			Connection connection = null;
			try {
				connection = DBConnection.getInstance().getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String query = "select balance from vsivadas.accounts where account_id=?";
			java.sql.PreparedStatement ps = null;
			ResultSet rs=null;
			try {
				ps=connection.prepareStatement(query);
				ps.setInt(1, id);
				
				rs=ps.executeQuery();
				while(rs.next())
				{
					finalamount=rs.getDouble("balance") - amount;
				}
			
				String query2="update vsivadas.accounts SET balance=? where account_id=?";
				ps=connection.prepareStatement(query2);
				ps.setDouble(1, finalamount);
				ps.setInt(2, id);
				int result=ps.executeUpdate();
				
				if(result==1)
				{
					flag=true;
				}
			}
			
			
			
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally{
				
				try {
					connection.close();
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			return flag;
		}

	}

