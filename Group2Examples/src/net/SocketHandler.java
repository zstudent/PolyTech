package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketHandler implements Runnable {

	private static final int N_THREADS = Math.max(1, Runtime.getRuntime()
			.availableProcessors() / 2);

	static ExecutorService sender = Executors.newFixedThreadPool(N_THREADS);

	private Socket socket;
	private PrintWriter pw;
	private Chat chat;
	private boolean slow;

	public SocketHandler(Socket socket, Chat chat, boolean slow)
			throws IOException {
		this.socket = socket;
		this.chat = chat;
		this.slow = slow;
		pw = new PrintWriter(socket.getOutputStream(), true);
		chat.addClient(this);
	}

	public void send(String message) {

		sender.execute(new Runnable() {
			@Override
			public void run() {
				if (slow) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				pw.println(message);
				// message = ""; // ERROR!
			}
		});

	}

	@Override
	public void run() {

		try {

			System.out.println(socket);

			try (Scanner scanner = new Scanner(socket.getInputStream())) {
				while (scanner.hasNextLine()) {
					String message = scanner.nextLine();
					chat.broadcast(message);
				}
			}

			socket.close();

			System.out.println("finished " + socket);

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			chat.removeClient(this);
		}
	}

}
