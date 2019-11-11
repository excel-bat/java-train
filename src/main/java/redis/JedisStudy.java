package redis;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import redis.clients.jedis.Jedis;

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
@Threads(20)
@State(Scope.Thread)
@Measurement(iterations = 2, time = 600, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JedisStudy {
    private static final int LOOP = 1;
    private Jedis jedis;

    @Setup
    public void setup() {
        jedis = new Jedis("192.168.85.3", 6385);
    }
    @Benchmark
    public void get() {
        for (int i = 0; i < JedisStudy.LOOP; ++i) {
            jedis.get("a");
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(JedisStudy.class.getSimpleName())
                .output("jedis-Throughput.log").forks(1).build();
        new Runner(options).run();
    }

}