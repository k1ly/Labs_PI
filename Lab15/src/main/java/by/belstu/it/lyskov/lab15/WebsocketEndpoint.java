package by.belstu.it.lyskov.lab15;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint("/websocket")
public class WebsocketEndpoint extends Endpoint {

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
        RemoteEndpoint.Basic remoteEndpointBasic = session.getBasicRemote();
        try {
            while (true) {
                Thread.sleep(2000);
                remoteEndpointBasic.sendText(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}