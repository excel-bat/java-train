package redis;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.concurrent.TimeUnit;

/**
 * @author shanyb@uxsino.com
 * @title: JedisStudy
 * @ticketNO: #
 * @description: TODO
 * @date 2019-10-0911:10
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Threads(100)
@State(Scope.Thread)
@Measurement(iterations = 2, time = 600, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JedisClusterStudy {
    private static final int LOOP = 1;
    private JedisCluster jc,jc1,jc2;

    @Setup
    public void setup() {
        jc = new JedisCluster(new HostAndPort("192.168.85.3", 6379));
        jc1 = new JedisCluster(new HostAndPort("192.168.85.3", 6380));
        jc2 = new JedisCluster(new HostAndPort("192.168.85.3", 6381));

    }

    @Benchmark
    public void get() {
        for (int i = 0; i < JedisClusterStudy.LOOP; ++i) {
            jc.get("a");
            jc1.get("a");
            jc2.get("a");

        }
    }
//
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(JedisClusterStudy.class.getSimpleName())
                .output("jc-Throughput.log").forks(1).build();
        new Runner(options).run();
    }
}