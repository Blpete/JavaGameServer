package com.blpeterson.game.server;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;

import com.blpeterson.game.data.GameBoard;
import com.blpeterson.game.data.GameSerializer;
import com.blpeterson.game.data.TestDataFactory;

public class GameWebSocket extends WebSocketAdapter {

	@Override
	public void onWebSocketText(String message) {
		if (isNotConnected()) {
			return;
		}
		try {
			if (message.equalsIgnoreCase("INIT")) {
				GameBoard gb = TestDataFactory.createGameBoard();
				String msg = GameSerializer.toString(gb);
				System.out.println("Echoing back message:" + msg);
				getRemote().sendString(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onWebSocketConnect(Session sess) {
		System.out.println("GAMESERVER: ws connected");
		super.onWebSocketConnect(sess);
	}

}
