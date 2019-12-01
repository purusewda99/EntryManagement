import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitorClass {
	private int id;
	private String name;
	private String phoneNo;
	private String email;
	private String checkInTime;
	private String checkOutTime;
	private String timeStampOfEntry;
	public VisitorClass(String name, String phoneNo, String email, String checkInTime, String checkOutTime,
			String timeStampOfEntry) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.timeStampOfEntry = timeStampOfEntry;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	public String getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public String getTimeStampOfEntry() {
		return timeStampOfEntry;
	}
	public void setTimeStampOfEntry(String timeStampOfEntry) {
		this.timeStampOfEntry = timeStampOfEntry;
	}
	@Override
	public String toString() {
		return "VisitorClass [name=" + name + ", phoneNo=" + phoneNo + ", email=" + email + ", checkInTime="
				+ checkInTime + ", checkOut=" + checkOutTime + ", timeStampOfEntry=" + timeStampOfEntry + "]";
	}
	public void addVisitor()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DbManager db = new DbManager();
			conn = db.getConnection();
			pstmt = conn.prepareStatement("Insert Into Visitor(name, email, phoneno, checkintime, checkout, timestamp) values ('"+name+"','"+email+"','"+phoneNo+"','"+ checkInTime +"','"+checkOutTime+"','"+timeStampOfEntry+"')");
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
