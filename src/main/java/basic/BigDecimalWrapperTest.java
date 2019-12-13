package basic;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author shanyb
 * @title: BigDecimalWrapper
 * @description: BigDecimal 处理类,测试精度对BigDecimal的影响
 * @create: 2019-12-13 23:40
 */
public class BigDecimalWrapperTest {
	
	@Test
	public void testBigDecimalScale() {
		BigDecimal bigDecimal1 = new BigDecimal(1).setScale(1, RoundingMode.HALF_UP);
		BigDecimal bigDecimal2 = new BigDecimal(2).setScale(2, RoundingMode.HALF_UP);
		
		System.out.println(bigDecimal1.equals(bigDecimal2));
		
	}
	
}
