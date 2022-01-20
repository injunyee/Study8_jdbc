package com.hij.department;
import java.sql.SQLException;
import java.util.*;

public class DepartmentControler
{
	private DepartmentDAO departmentDao;
	private DepartmentView departmentView;
	private Scanner sc;
	
	public DepartmentControler()
	{
		departmentDao = new DepartmentDAO();
		departmentView = new DepartmentView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws ClassNotFoundException, SQLException
	{
		boolean flag = true;
		while(flag)
		{
			System.out.println("1.부서리스트 출력");
			System.out.println("2.부서번호	출력");
			System.out.println("3.나가기");
			int select = sc.nextInt();
			
			if(select == 1)
			{
				List<DepartmentDTO> ar = departmentDao.getList();
				departmentView.view(ar);
			}
			else if(select == 2)
			{
				System.out.print("검색할 부서번호를 입력하세요 ");
				DepartmentDTO dto = new DepartmentDTO();
				dto.setDepartment_id(sc.nextInt());
				dto = departmentDao.getOne(dto);
				if(dto == null)
				{
					System.out.println("부서검색에 실패하였습니다ㅇ.");
				}
			}
		}//while end
	}//public void start end
}//public class DepartmentControler end
