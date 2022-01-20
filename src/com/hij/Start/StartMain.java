package com.hij.Start;
import java.sql.SQLException;
import java.util.List;

import com.hij.department.DepartmentDAO;
import com.hij.department.DepartmentDTO;
import com.hij.department.DepartmentView;
import com.hij.util.*;

public class StartMain
{
	public static void main(String args[]) throws ClassNotFoundException, SQLException
	{
		System.out.printf("program start.\n");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
//		DepartmentView departmentView = new DepartmentView();
//		
//		List<DepartmentDTO> dtoList = departmentDAO.getList();
//		
//		departmentView.view(dtoList);
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(20);
		departmentDTO = departmentDAO.getOne(departmentDTO);
		System.out.println(departmentDTO.getDepartment_name());
	}
}
