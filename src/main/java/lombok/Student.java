/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package lombok;

import lombok.Data;

/**
 * 学生基础类
 *
 * @Data注解的作用相当于 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode的合集
 * @author shanyingbo
 * @version $Id Student.java, v 0.1 2019-04-04 09:41 shanyingbo Exp $$
 */
@Data
public class Student {

  private String name;
  private int age;
  private String male;
  private String studentNo;
}