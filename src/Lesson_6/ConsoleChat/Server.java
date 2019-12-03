package Lesson_6.ConsoleChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    final int PORT = 8189;
    ServerSocket server = null;
    Socket socket = null;
    DataInputStream in;
    DataOutputStream out;
    Scanner scanner = new Scanner(System.in);

    public Server() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");
            socket = server.accept();
            System.out.println("Клиент подключился");
        } catch (IOException e) {
            e.printStackTrace();
        }

            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (true){
                        try {
                            in = new DataInputStream(socket.getInputStream());

                            String msg = in.readUTF();
                            if(msg.equalsIgnoreCase("/end")){
                                System.out.println("Клиент разорвал соединение");
                                break;
                            }
                            System.out.println(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            out = new DataOutputStream(socket.getOutputStream());
                            String msg = scanner.nextLine();
                            if(msg.equalsIgnoreCase("/end")){
                                out.writeUTF(msg);
                                break;
                            }
                            out.writeUTF("Server: " + msg);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
    }
    public static void main(String[] args) {
        new Server();
    }
}
