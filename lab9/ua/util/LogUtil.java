package util;


import java.time.LocalDateTime;


public class LogUtil {
public static synchronized void log(String msg) {
System.out.println("[" + LocalDateTime.now() + "] " + msg);
}
}
