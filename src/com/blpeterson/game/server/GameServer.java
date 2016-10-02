package com.blpeterson.game.server;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.Resource;


public class GameServer {

	private Server server;

	public static void main(String[] args) {
		GameServer server = new GameServer();
		server.start();

	}

	private void start() {
		System.out.println("Starting Game Server");

		try {
			// start web server
			server = new Server(9090);
			
			// setup resource handler
			ResourceHandler resHandler = new ResourceHandler();
			// todo only for debug environment
			resHandler.setDirectoriesListed(true);
			//resHandler.setResourceBase("web");
			 ContextHandler context1 = new ContextHandler();
			 context1.setBaseResource(Resource.newResource("web"));
		        context1.setContextPath("/test");
		        context1.setHandler(resHandler);

	       
			
			ServletContextHandler ctx = new ServletContextHandler();
			ctx.setContextPath("/");
			ctx.addServlet(GameWebSocketServlet.class, "/gamews");

			HandlerList handlers = new HandlerList();
			handlers.setHandlers(new Handler[]{  context1, ctx} );

			
			server.setHandler(handlers);
			
			server.start();
			server.join();
			// System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Finished Starting Game Server");
	}

}
