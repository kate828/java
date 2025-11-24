package concurrency;


import util.LogUtil;
import java.util.List;
import java.util.concurrent.Callable;


public class DataProcessingTasks {


public static Runnable countTask(List<?> list) {
return () -> {
LogUtil.log("Counting elements...");
LogUtil.log("Count = " + list.size());
};
}


public static <T> Callable<Long> filteringTask(List<T> list, java.util.function.Predicate<T> predicate) {
return () -> list.stream().filter(predicate).count();
}
}
