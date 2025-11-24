package concurrency;


import util.LogUtil;


import java.util.List;
import java.util.concurrent.*;


public class PerformanceComparator {


public static long testParallelStream(List<?> list) {
long start = System.currentTimeMillis();
list.parallelStream().filter(x -> x != null).count();
long end = System.currentTimeMillis();
LogUtil.log("parallelStream time = " + (end - start));
return end - start;
}


public static long testExecutorService(List<?> list) throws Exception {
ExecutorService exec = Executors.newFixedThreadPool(4);
long start = System.currentTimeMillis();


Future<Long> f = exec.submit(() -> list.stream().filter(x -> x != null).count());
f.get();


long end = System.currentTimeMillis();
exec.shutdown();
LogUtil.log("ExecutorService time = " + (end - start));
return end - start;
}
}
