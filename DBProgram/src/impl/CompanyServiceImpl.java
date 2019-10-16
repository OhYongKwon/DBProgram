package impl;

import java.util.List;

import common.CompanyDAO;
import model.Company;
import model.CompanyService;

public class CompanyServiceImpl implements CompanyService {
	CompanyDAO codao= new CompanyDAO();
	@Override
	public void insertCompany(Company company) {
		codao.intsertBoard(company);
	}

	@Override
	public List<Company> getCompany(String name) {
		List<Company> cmp = codao.getCompany(name);
		return cmp;
	}

	@Override
	public List<Company> getCompanyDepartment(String department) {
		List<Company> cmp = codao.getCompanyDepartment(department);
		return cmp;
	}

	@Override
	public void updateCompany(Company company) {
		codao.updateCompany(company);
	}

	@Override
	public void deleteCompany(Company company) {
		codao.deleteCompany(company);
	}

}
