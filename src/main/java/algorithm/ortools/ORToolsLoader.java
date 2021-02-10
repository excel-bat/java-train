package algorithm.ortools;

/**
 * 加载系统工具
 */
public class ORToolsLoader {
    
    public static void load() {
        final String osType = System.getProperty("os.name");
        
        if (osType.contains("OS X")) {
            System.load("/Users/yingbo/Downloads/or-tools_MacOsX-10.14.6_v7.4.7247/lib/libjniortools.jnilib");
        }
    }
}
