package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



@ServerEndpoint(value = "/websockets")
public class Websockets extends Endpoint {

  @OnOpen
  public void onOpen(Session session, EndpointConfig endpointConfig) {
    SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
    try{
      while(true){
        Thread.sleep(2000);
        System.out.println("ws");
        session.getBasicRemote().sendText(format.format(new Date()));
      }
    }
    catch( IOException | InterruptedException e){
      try {
        session.close(); //remove if something broke.
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
      e.printStackTrace();
    }
  }
}
