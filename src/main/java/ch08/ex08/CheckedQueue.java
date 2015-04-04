package ch08.ex08;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class CheckedQueue {

    static void getMoreWork(Queue q) {
        q.offer(Paths.get("/"));
        q.offer("/");
        while (!q.isEmpty()) {
            Path path = (Path) q.poll();
            path.toFile();
        }
    }

    public static void main(String[] args) {
        Queue<Path> queue = Collections.checkedQueue(new LinkedList<Path>(), Path.class);
        getMoreWork(queue);
    }

}
