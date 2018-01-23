package com.herman.protocol;

import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.google.gson.Gson;
import com.herman.msg.Message;

public class MessageClientHandler extends IoHandlerAdapter {
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		//�رջỰ����ǿ��ˢ��û��д����ڴ�
		CloseFuture future = session.close(true);
		//��¼���ӹر�
		future.awaitUninterruptibly();
		Gson gson=new Gson();
		Message msg=new Message();
		msg.setMsg_body("quit");
		msg.setMsg_length("msgLength");
		msg.setMsg_type("msgType");
		msg.setSign("sign");
		msg.setSign_type("signType");
		session.write(gson.toJson(msg));
	}
	public MessageClientHandler() {
		
	}

	public void messageReceived(IoSession session, Object message)
			throws Exception {
		Gson gson=new Gson();
		Message msg=gson.fromJson(message.toString(), Message.class);
		System.out.println(msg.toString());// ��ʾ���յ�����Ϣ
	}
}
