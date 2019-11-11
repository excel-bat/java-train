/**
 * Copyright (C) 2008-2019 All Rights Reserved.
 */


package lombok;

/**
 * 学生基础类
 *
 * @author shanyingbo
 * @version $Id Student.java, v 0.1 2019-04-04 09:41 shanyingbo Exp $$
 * @Data注解的作用相当于 @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode的合集
 */
@Data
class Student {

    private String name;
    private int age;
    private String male;
    private String studentNo;
}