package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		System.out.println("start server");
		
		Chat chat = new Chat();
		new Thread(chat, "Chat").start();

		try {
			ServerSocket serverSocket = new ServerSocket(10000);

			System.out.println("Listening for incoming connection...");
			int count = 0;
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread(new SocketHandler(socket, chat, (count++) % 2 == 0 ), "SocketHandler").start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
