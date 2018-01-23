package com.herman.protocol;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.google.gson.Gson;
import com.herman.msg.Message;
import com.herman.util.SocketUtil;

public class ClientInit {
	public static void main(String[] args) {
		// �����ͻ���������
		NioSocketConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		// ���ñ��������
//		connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8")))); 
		connector.getFilterChain().addLast("codec",new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
		connector.setConnectTimeoutMillis(30000L);
		// �����¼�������
		connector.setHandler(new MessageClientHandler());
		// ��������
		ConnectFuture cf = connector.connect(new InetSocketAddress(SocketUtil.LOCAL_IP,SocketUtil.PORT));
		// �ȴ����Ӵ������
		cf.awaitUninterruptibly();
		// ������Ϣ
		Gson gson=new Gson();
		Message msg=new Message();
		msg.setMsg_body("hello");
		msg.setMsg_length("msgLength");
		msg.setMsg_type("msgType");
		msg.setSign("sign");
		msg.setSign_type("signType");
		cf.getSession().write(gson.toJson(msg));
		// ������Ϣ
		msg.setMsg_body("quit");
		cf.getSession().write(gson.toJson(msg));
		// �ȴ����ӶϿ�
		cf.getSession().getCloseFuture().awaitUninterruptibly();
		connector.dispose();
	}
}
