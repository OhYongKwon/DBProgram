package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import impl.CompanyServiceImpl;
import model.Company;
import model.CompanyService;

public class Companyproc {
	Scanner sc = new Scanner(System.in);

	CompanyService service = new CompanyServiceImpl();
	String loginId = null;

	public void execute() {
		while (true) {
			int menu = 0;
			System.out.println(
					"1.��� ��� 2.����̸� ��ȸ 3.�μ��� ��ȸ(�μ��Է��ϸ� �μ��� ��ȸ, �μ��Է¾��ϸ� ��ü ��ȸ(�μ��Էºκ� ��ü �ο�ǥ��) 4.�μ����� 5.���ó�� 9.����");
			menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {
				System.out.println("1������");
				companyJoin();
			} else if (menu == 2) {
				System.out.println("2������");
				getCompanyName();
			} else if (menu == 3) {
				System.out.println("3������");
				getBoardList();
				
			} else if (menu == 4) {
				System.out.println("4������");
				updateCompany();
			} else if (menu == 5) {
				System.out.println("5������");
				deleteCompany();
			} else if (menu == 9) {
				break;
			}
		}
	}
	//����
	public void deleteCompany() {
		System.out.println("���� id:");
		int id = sc.nextInt();
		
		Company cmp = new Company();
		cmp.setId(id);

		service.deleteCompany(cmp);
	}
	// ������Ʈ
		public void updateCompany() {
			System.out.println("�μ����� id:");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("�μ� ����: ");
			String department = sc.nextLine();

			Company cmp = new Company();
			cmp.setId(id);
			cmp.setDepartment(department);

			service.updateCompany(cmp);
		}
		
	
	// �μ��� ��� ��ȸ
	public void getBoardList() {
		System.out.println("�μ��� ��ȸ: ");
		String department = sc.nextLine();
		
		List<Company> resultAry = new ArrayList<>();
		resultAry =service.getCompanyDepartment(department);
	
		for (Company cmp : resultAry) {
			if (cmp != null)
				System.out.println(cmp);
		}
	}
	
	// ������
	public void companyJoin() {
		System.out.println("��� ���.");

		System.out.println("�̸��� �Է��ϼ���.: ");
		String name = sc.nextLine();

		System.out.println("�μ��� �Է��ϼ���: ");
		String department = sc.nextLine();
		
		System.out.println("�޿��� �Է��ϼ���: ");
		int salary = sc.nextInt();  sc.nextLine();
		
		System.out.println("�Ի����� �Է��ϼ���: ");
		String hireDate = sc.nextLine();

		Company company = new Company(0, name, department,salary, hireDate);
		service.insertCompany(company);
	}
	
	//����̸���ȸ
	public void getCompanyName() {
		System.out.println("����̸� ��ȸ: ");
		String name = sc.nextLine();
		
		List<Company> resultAry = new ArrayList<>();
		resultAry =service.getCompany(name);
	
		for (Company cmp : resultAry) {
			if (cmp != null)
				System.out.println(cmp);
		}
	}
	
/*


	

	private void insertReply(BoardDB board) {
		System.out.println("����ۼ�.");

		System.out.println("������ �Է��ϼ���: ");
		String contents = sc.nextLine();

		BoardDB boardDB = new BoardDB(0, board.getTitle(), contents, loginId, "", board.getBoardNo());
		service.insertReply(boardDB);
	}

	

	// ���� �� ����
	public void deleteBoard() {
		System.out.println("������ �� ��ȣ:");
		int boardNo = sc.nextInt();
		sc.nextLine();

		BoardDB board = new BoardDB();
		board.setBoardNo(boardNo);
		board.setWriter(loginId);

		service.deleteBoard(board);

	}*/
}
