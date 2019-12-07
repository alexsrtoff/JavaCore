package Lesson_6.Chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MainServ {
    private Vector<ClientHandler> clients;

    public MainServ() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;
        try {
            AuthService.connect();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился!");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void subscribe(ClientHandler cllient){
        clients.add(cllient);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        System.out.println("Клиент отключился");
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o: clients) {
            o.sendMsg(msg);
        }
    }

    public boolean checkNick(String newNick) {
        boolean check = false;
        for(ClientHandler e: clients){
            if(e.nick.equals(newNick)) check = true;
        }
        return check;
    }

    public boolean checkPrivateMsg(String msg) {
        boolean check = false;

        for (ClientHandler c: clients){
            if(msg.startsWith("/" + c.nick)){
                check = true;
                break;
            }
        }
        return  check;
    }

    public void sendPrivateMsg(String nick, String msg) {
        String[] tockens = msg.split(" ");
        for (ClientHandler o: clients){
            if (msg.startsWith("/" + o.nick)) {
                o.sendMsg(nick + " :" + tockens[1]);
                break;
            }
        }
        for (ClientHandler o: clients){
            if(o.nick.equals(nick)){
                o.sendMsg(nick + " :" + tockens[1]);
                break;
            }
        }
    }
}
