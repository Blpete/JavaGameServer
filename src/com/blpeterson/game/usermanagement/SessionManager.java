package com.blpeterson.game.usermanagement;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.websocket.api.Session;

public class SessionManager {

	private static SessionManager instance = null;
	private List<GameSession> sessions=new ArrayList<GameSession>();

	public static SessionManager getInstance() {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}

	public void registerSession(Session session) {
		GameSession gs = new GameSession();
		gs.setStartDTG(DTGUtil.getCurrentDTG());
		gs.setClientIpAddress(session.getLocalAddress().toString());
		System.out.println("SessionOpened"+session.getLocalAddress());

		sessions.add(gs);
	}

	public void registerSessionClose(Session session, int statusCode, String reason) {
		// TODO Auto-generated method stub
		System.out.println("SessionClosed"+session.getLocalAddress()+" status:"+statusCode+ "   reason"+reason);
	}

}
