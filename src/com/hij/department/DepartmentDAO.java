package com.hij.department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hij.util.*;

public class DepartmentDAO //DAO : Data Access Object
{
	private DBConnector dbConnector;
	
	public DepartmentDAO()
	{
		dbConnector = new DBConnector();
	}//constructor DepartmentDAO end
	
	public DepartmentDTO getOne(Integer department_id) throws ClassNotFoundException, SQLException
	{
		Connection con = dbConnector.getConnect();
		String sql = "SELECT * FROM DEPARTMENTS WHERE (DEPARTMENT_ID = ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, department_id);
		ResultSet rs = st.executeQuery();
		DepartmentDTO departmentdto = null;
		
		if(rs.next() == true)
		{
			departmentdto = new DepartmentDTO();
			departmentdto.setDepartment_id(rs.getInt("department_id"));
			departmentdto.setDepartment_name(rs.getString("department_name"));
			departmentdto.setManager_id(rs.getInt("manager_id"));
			departmentdto.setLocation_id(rs.getInt("location_id"));
		}
		else
		{
			System.out.println("없는 부서번호 입니다.");
		}
		
		rs.close();
		st.close();
		con.close();
		
		return departmentdto;
	}//public void getOne end
	
	public List<DepartmentDTO> getList() throws ClassNotFoundException, SQLException
	{
		ArrayList<DepartmentDTO> ar = new ArrayList<>();
		//select * from departments;
		//1. DB login
		Connection con = dbConnector.getConnect();
		
		//2. make SQL Query sentance
		String sql = "SELECT * FROM DEPARTMENTS";
		
		//3. 작성한 SQL Query 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값을 세팅, 없으면 통과
		
		//5. 최종 전송 후 결과물 처리과정
		ResultSet rs = st.executeQuery();
		
		//cursor가 한줄을 읽으라는 method, return은 데이터가 있으면 true 없으면 false
		while(rs.next())
		{
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			ar.add(departmentDTO);
		}
		
		//6. 외부 연결 해제
		//연결해제는 연결된 순서의 역순으로 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}//public void getList end
}








