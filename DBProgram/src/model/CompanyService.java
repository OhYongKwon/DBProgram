package model;

import java.util.List;

public interface CompanyService {
	public void insertCompany(Company company); //1.사원등록
	
	public List<Company> getCompany(String name); //2.사원이름 조회
	
	public List<Company> getCompanyDepartment(String department);//3.부서별 조회

	public void updateCompany(Company company); //4.부서변경
	
	public void deleteCompany(Company company); // 5. 퇴사처리
}
