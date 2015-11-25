package net;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Chat implements Runnable {
	
	List<SocketHandler> clients = new CopyOnWriteArrayList<SocketHandler>();
	BlockingQueue<String> messages = new LinkedBlockingQueue<String>(); 
	
	public void addClient(SocketHandler handler) {
		clients.add(handler);
	}
	
	public void removeClient(SocketHandler handler) {
		clients.remove(handler);
	}
	
	public void broadcast(String message) {
		messages.offer(message);
	}

	private void realBroadcast(String message) {
		for (SocketHandler socketHandler : clients) {
				socketHandler.send(message);
		}
	}

	@Override
	public void run() {
		while(true) {
			try {
				String message = messages.take();
				realBroadcast(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
