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
					"1.사원 등록 2.사원이름 조회 3.부서별 조회(부서입력하면 부서만 조회, 부서입력안하면 전체 조회(부서입력부분 전체 인원표시) 4.부서변경 5.퇴사처리 9.종료");
			menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {
				System.out.println("1번선택");
				companyJoin();
			} else if (menu == 2) {
				System.out.println("2번선택");
				getCompanyName();
			} else if (menu == 3) {
				System.out.println("3번선택");
				getBoardList();
				
			} else if (menu == 4) {
				System.out.println("4번선택");
				updateCompany();
			} else if (menu == 5) {
				System.out.println("5번선택");
				deleteCompany();
			} else if (menu == 9) {
				break;
			}
		}
	}
	//삭제
	public void deleteCompany() {
		System.out.println("삭제 id:");
		int id = sc.nextInt();
		
		Company cmp = new Company();
		cmp.setId(id);

		service.deleteCompany(cmp);
	}
	// 업데이트
		public void updateCompany() {
			System.out.println("부서변경 id:");
			int id = sc.nextInt();
			sc.nextLine();

			System.out.println("부서 변경: ");
			String department = sc.nextLine();

			Company cmp = new Company();
			cmp.setId(id);
			cmp.setDepartment(department);

			service.updateCompany(cmp);
		}
		
	
	// 부서별 사원 조회
	public void getBoardList() {
		System.out.println("부서별 조회: ");
		String department = sc.nextLine();
		
		List<Company> resultAry = new ArrayList<>();
		resultAry =service.getCompanyDepartment(department);
	
		for (Company cmp : resultAry) {
			if (cmp != null)
				System.out.println(cmp);
		}
	}
	
	// 사원등록
	public void companyJoin() {
		System.out.println("사원 등록.");

		System.out.println("이름을 입력하세요.: ");
		String name = sc.nextLine();

		System.out.println("부서를 입력하세요: ");
		String department = sc.nextLine();
		
		System.out.println("급여를 입력하세요: ");
		int salary = sc.nextInt();  sc.nextLine();
		
		System.out.println("입사일을 입력하세요: ");
		String hireDate = sc.nextLine();

		Company company = new Company(0, name, department,salary, hireDate);
		service.insertCompany(company);
	}
	
	//사원이름조회
	public void getCompanyName() {
		System.out.println("사원이름 조회: ");
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
		System.out.println("댓글작성.");

		System.out.println("내용을 입력하세요: ");
		String contents = sc.nextLine();

		BoardDB boardDB = new BoardDB(0, board.getTitle(), contents, loginId, "", board.getBoardNo());
		service.insertReply(boardDB);
	}

	

	// 보드 글 삭제
	public void deleteBoard() {
		System.out.println("삭제할 글 번호:");
		int boardNo = sc.nextInt();
		sc.nextLine();

		BoardDB board = new BoardDB();
		board.setBoardNo(boardNo);
		board.setWriter(loginId);

		service.deleteBoard(board);

	}*/
}
