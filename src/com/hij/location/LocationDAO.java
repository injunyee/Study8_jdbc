package com.hij.location;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hij.util.DBConnector;

public class LocationDAO
{
	private DBConnector dbConnector;
	
	public LocationDAO()
	{
		dbConnector = new DBConnector();
	}
	
	public void getList() throws ClassNotFoundException, SQLException
	{
		Connection con = dbConnector.getConnect();
		String sql = "SELECT * FROM LOCATIONS";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getString("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
		}
		
		rs.close();
		pst.close();
		con.close();
	}
}
