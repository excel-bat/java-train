package basic;


import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

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
        //staff.getDepartment();
        
        //Optional<Staff> optCompany = Optional.ofNullable(staff);
        
        //System.out.println(optCompany.filter(staff -> "apple".equals(staff.getName())).get().name);
        
        List<Staff> staffs = Lists.newArrayList();
        staffs.add(new Staff(2, new Date(), null, "zhangsan", Stream.of("1", "2", "4").collect(Collectors.toList())));
        staffs.add(new Staff(1, new Date(), null, "zhangsan", Stream.of("1", "1", "6").collect(Collectors.toList())));
        staffs.add(new Staff(5, new Date(), null, "zhangsan", Stream.of("1", "8", "4").collect(Collectors.toList())));
	/*	List<Staffs> staffs1s = staffs.stream().filter(staff1 -> staff1.name.equals("")).map(staff1 -> {
			Staffs staffs1 = new Staffs();
			staffs1.setName(staff1.getName());
			return staffs1;
		}).collect(Collectors.toList());*/
        staffs.sort(Comparator.comparing(Staff::getDate));
        System.out.println(staffs);
        Map<String, Staff> staffMap = staffs.stream().collect(toMap(Staff::getName, identity(), (existing, replace) -> existing.getId() < replace.getId() ? replace : existing));
        System.out.println(staffMap.toString());
    }
    
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Staff {
        private int id;
        private Date date;
        private Department department;
        private String name = "apple";
        private List<String> times;
        
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
    
    @Data
    static class Staffs {
        private Department department;
        private String name = "apple";
        
        
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
