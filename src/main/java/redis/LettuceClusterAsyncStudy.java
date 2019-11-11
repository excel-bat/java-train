package redis;

import io.lettuce.core.RedisFuture;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author shanyb@uxsino.com
 * @title: LettuceAsyncStudy
 * @ticketNO: #
 * @description: TODO
 * @date 2019-10-0911:24
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1)
@Threads(100)
@State(Scope.Benchmark)
@Measurement(iterations = 2, time = 600, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class LettuceClusterAsyncStudy {
    private static final int LOOP = 1;
    private StatefulRedisClusterConnection<String, String> connection;

    @Setup
    public void setup() {
        RedisClusterClient client = RedisClusterClient.create("redis://192.168.85.3:6379");
        connection = client.connect();
    }

    @Benchmark
    public void get() throws ExecutionException, InterruptedException {
        RedisAdvancedClusterAsyncCommands<String, String> commands = connection.async();
        List<RedisFuture<String>> redisFutureList = new ArrayList<>();
        for (int i = 0; i < LettuceClusterAsyncStudy.LOOP; ++i) {
            RedisFuture<String> future = commands.get("a");
            redisFutureList.add(future);
            future.get();
        }
        redisFutureList.forEach(f -> {
            try {
                f.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(LettuceClusterAsyncStudy.class.getSimpleName())
                .output("lc-Throughput.log").forks(1).build();
        new Runner(options).run();
    }
}
