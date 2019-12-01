package basic;


import java.util.Optional;

/**
 * @author shanyb@uxsino.com
 * @title: LamdaOptional
 * @ticketNO: #
 * @description: lamda optional 使用
 * @create: 2019-11-11 18:00
 */
public class LamdaOptional {
	
	
	private static Staff staff = new Staff();
	
	public static void main(String[] args) {
		staff.getDepartment();
		
		Optional<Staff> optCompany = Optional.ofNullable(staff);
		
		System.out.println(optCompany.filter(staff -> "apple".equals(staff.getName())).get().name);
	}
	
	
	static class Staff {
		private Department department;
		private String name = "apple";
		
		public Optional<Department> getDepartment() {
			return Optional.ofNullable(department);
		}
		
		public String getName() {
			return name;
		}
		
		//这种写法返回的是Optional<String>,跟"apple" 无法equal
		public Optional<String> getName1() {
			return Optional.ofNullable(name);
		}
	}
	
	static class Department {
		
		private Company company;
		
		public Optional<Company> getCompany() {
			return Optional.ofNullable(company);
		}
	}
	
	static class Company {
		private String name;
		
		public String getName() {
			return name;
		}
	}
}
