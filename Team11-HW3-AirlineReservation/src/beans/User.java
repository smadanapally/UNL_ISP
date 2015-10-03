package beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;


public class User {
	private int userId;
	private String emailaddress;
	private String username;
	private Date date_of_birth;
	private String password;
	private String path;
	/* METHOD FOR HASHING THE PASSWORD*/
	public String sha1(String input) throws NoSuchAlgorithmException   {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getEmailaddress() {
		return emailaddress;
	}


	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}


	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public User() {

	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			this.password = sha1(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public User(int userid, String password, String emailaddress,Date dob,String username) {
		super();
		this.userId = userid;
		this.password = password;
		this.emailaddress=emailaddress;
		this.date_of_birth=dob;
		this.username=username;
	}
	/*METHOD FOR ADDING A NEW USER*/
//	public boolean addUser() throws NoSuchAlgorithmException {

//		boolean flag = false;
//		Properties props = new Properties();
//		File file = new File(path);
//
//		try {
//			FileInputStream fileIn = new FileInputStream(file);
//			props.load(fileIn);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		/*CHECKING WHETHER THE USERNAME ALREADY EXISTS OR NOT*/
//		if (props.containsKey(username)) {
//
//		}
//
//		else {
//			flag = true;
//			
//			props.setProperty(username, sha1(password));
//			FileOutputStream fileOut;
//			try {
//				fileOut = new FileOutputStream(file);
//				props.store(fileOut, "");
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		return flag;

//	}
	/*METHOD FOR VALIDATING THE LOGIN AYTHENTICATION*/
//	public boolean loginValidate() throws NoSuchAlgorithmException {
//		boolean valflag = false;
//		Properties props = new Properties();
//		File file = new File(path);
//
//		try {
//			FileInputStream fileIn = new FileInputStream(file);
//			props.load(fileIn);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(props.containsKey(username)&& props.get(username).equals(sha1(password)))
//		{
//			valflag=true;
//		}
//		else
//		{
//			valflag=false;
//		}
//		return valflag;
//	}
}
