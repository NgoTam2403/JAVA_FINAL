package QLCB;

import java.sql.SQLException;

public interface ICanBo {
	
	public void getCon() throws SQLException;
	public int insertCB(CanBo a) throws SQLException;
		
	
}
