package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Company;

public class CompanyDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	String name = null;

	public void deleteCompany(Company company) {
		conn = DAO.getConnect();
		String sql = "delete from company where id=?";

		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(++n, company.getId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void updateCompany(Company company) {
		conn = DAO.getConnect();
		String sql = "update company set id=id,name=name,department=?,salary=salary,creation_date=creation_date where id=?";

		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++n, company.getDepartment());
			pstmt.setInt(++n, company.getId());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 부서별 조회
	public List<Company> getCompanyDepartment(String department) {
		conn = DAO.getConnect();
		
		if (department.equals("")) {
			String sql = "select id,name,department,salary,creation_date,"
					+ "(select count(*) from company where department=department) as dep_cnt "
					+ " from company where department=department";
			Company cmp = new Company();
			List<Company> list = new ArrayList<>();

			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					cmp = new Company();
					cmp.setId(rs.getInt("id"));
					cmp.setName(rs.getString("name"));
					cmp.setDepartment(rs.getString("department") + " (" + rs.getString("dep_cnt") + ")");
					cmp.setSalary(rs.getInt("salary"));
					cmp.setCeatrion_date(rs.getString("creation_date"));
					list.add(cmp);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		
		} 
		
		
		else {
			String sql = "select id,name,department,salary,creation_date,"
					+ "(select count(*) from company where department=?) as dep_cnt "
					+ " from company where department=?";
			
			Company cmp = new Company();
			List<Company> list = new ArrayList<>();
			int n = 0;

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(++n, department);
				pstmt.setString(++n, department);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					cmp = new Company();
					cmp.setId(rs.getInt("id"));
					cmp.setName(rs.getString("name"));
					cmp.setDepartment(rs.getString("department") + " (" + rs.getString("dep_cnt") + ")");
					cmp.setSalary(rs.getInt("salary"));
					cmp.setCeatrion_date(rs.getString("creation_date"));
					list.add(cmp);

				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}
		

	}

	public List<Company> getCompany(String name) {
		conn = DAO.getConnect();
		String sql = "select * from company where name=?";
		Company cmp = new Company();
		List<Company> list = new ArrayList<>();
		int n = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++n, name);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cmp = new Company();
				cmp.setId(rs.getInt("id"));
				cmp.setName(rs.getString("name"));
				cmp.setDepartment(rs.getString("department"));
				cmp.setSalary(rs.getInt("salary"));
				cmp.setCeatrion_date(rs.getString("creation_date"));
				list.add(cmp);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	// 사원등록
	public void intsertBoard(Company company) {
		conn = DAO.getConnect();
		String sql = "insert into company values((select nvl(max(id)+1,0) from company)," + "?, ?, ?, ?)";

		System.out.println(sql);
		int n = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++n, company.getName());
			pstmt.setString(++n, company.getDepartment());
			pstmt.setInt(++n, company.getSalary());
			pstmt.setString(++n, company.getCeatrion_date());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
