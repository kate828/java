package repository;


import util.LogUtil;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;


public class GenericRepository<T extends Comparable<T>> {


protected List<T> data = new CopyOnWriteArrayList<>();


public void add(T item) {
data.add(item);
LogUtil.log("Added: " + item);
}


public List<T> getAll() { return data; }


public void sortByIdentity(String order) {
if (order.equalsIgnoreCase("asc"))
data.sort(Comparator.naturalOrder());
else
data.sort(Comparator.reverseOrder());
LogUtil.log("Sorted by identity (" + order + ")");
}
}
