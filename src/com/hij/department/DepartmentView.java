package com.hij.department;
import java.util.*;

public class DepartmentView
{
	public void view(List<DepartmentDTO> ar)
	{
		//모두 출력하고 싶다.
		int i = 0;
		for(i=0; i<ar.size(); i++)
		{
			System.out.print(ar.get(i).getDepartment_name() + "\t\t");
			System.out.print(ar.get(i).getDepartment_id() + "\t\t");
			System.out.print(ar.get(i).getManager_id() + "\t\t");
			System.out.println(ar.get(i).getLocation_id());
			System.out.println("----------------------------------------------------------------");
		}
	}
}
