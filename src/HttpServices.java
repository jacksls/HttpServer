import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * @author Liang
 * @date 2020/3/30 3:30
 */
public class HttpServices {

    private static int port = 8888;

    public static void main(String[] args) {


        serverStart();
    }

    public static void serverStart() {
        HttpServer server = null;
        MyHandler handler = new MyHandler();
        ExecutorService executorService;
        try {
            InetSocketAddress address = new InetSocketAddress(port);
            server = HttpServer.create(address, 0);
            server.createContext("/", handler);
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("服务器启动成功...   端口号为：" + port);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败...");
        }
    }
}
