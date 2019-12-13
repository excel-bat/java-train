package basic;

import com.google.common.base.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @author shanyb
 * @title: SupplierWarpper
 * @description: Supplier包装类
 * @create: 2019-12-12 15:32
 */
public class SupplierWarpper {
	
	@Test
	public void testSupplier() {
		Supplier<Predicate<String>> supplier = new Supplier<Predicate<String>>() {
			@Override
			public Predicate<String> get() {
				Map<String, Girl> girlMap = new HashMap<String, Girl>() {
					{
						put("love the age", new Girl(18, "not so since"));
						
						put("love the face", new Girl(16, "so since"));
					}
				};
				
				Function<String, Girl> function = Functions.forMap(girlMap);
				
				Predicate<Girl> predicate = new Predicate<Girl>() {
					@Override
					public boolean apply(Girl input) {
						return input.getAge() >= 18;
					}
				};
				Predicate<String> result = Predicates.compose(predicate, function);
				return result;
				
			}
		};
		System.out.println(supplier.get().apply("love the age"));
		System.out.println(supplier.get().apply("love the face"));
	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	static class Girl {
		int age;
		String face;
	}
}
