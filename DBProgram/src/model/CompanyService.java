package model;

import java.util.List;

public interface CompanyService {
	public void insertCompany(Company company); //1.������
	
	public List<Company> getCompany(String name); //2.����̸� ��ȸ
	
	public List<Company> getCompanyDepartment(String department);//3.�μ��� ��ȸ

	public void updateCompany(Company company); //4.�μ�����
	
	public void deleteCompany(Company company); // 5. ���ó��
}
