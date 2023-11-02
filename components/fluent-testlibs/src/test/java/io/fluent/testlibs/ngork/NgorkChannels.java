package io.fluent.testlibs.ngork;

import com.github.alexdlaird.ngrok.NgrokClient;
import com.github.alexdlaird.ngrok.protocol.CreateTunnel;
import com.github.alexdlaird.ngrok.protocol.Proto;
import com.github.alexdlaird.ngrok.protocol.Tunnel;

public class NgorkChannels {
  //https://github.com/anderspitman/awesome-tunneling
  // https://github.com/alexdlaird/java-ngrok.git

  public static void main(String[] args) {
    final NgrokClient ngrokClient = new NgrokClient.Builder().build();

// Open a HTTP tunnel on the default port 80
// <Tunnel: "http://<public_sub>.ngrok.io" -> "http://localhost:80">
    final Tunnel httpTunnel = ngrokClient.connect();

// Open a SSH tunnel
// <Tunnel: "tcp://0.tcp.ngrok.io:12345" -> "localhost:22">
    final CreateTunnel sshCreateTunnel = new CreateTunnel.Builder()
      .withProto(Proto.TCP)
      .withAddr(22)
      .build();
    final Tunnel sshTunnel = ngrokClient.connect(sshCreateTunnel);
    System.out.println(sshTunnel.getPublicUrl());
  }
}
