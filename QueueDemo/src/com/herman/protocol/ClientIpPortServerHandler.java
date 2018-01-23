package com.herman.protocol;

import java.util.Date;

import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import com.google.gson.Gson;
import com.herman.msg.Message;

public class ClientIpPortServerHandler extends IoHandlerAdapter {
	public void exceptionCaught(IoSession session, Throwable cause)
			throws Exception {
		//super.exceptionCaught(session, cause);
		//�رջỰ����ǿ��ˢ��û��д����ڴ�
		CloseFuture future = session.close(true);
		//��¼���ӹر�
		future.awaitUninterruptibly();
	}
	public void sessionCreated(IoSession session) {
		//��ʾ�ͻ��˵�ip�Ͷ˿�
		System.out.println("�ͻ��˵�ip�Ͷ˿�:"+session.getRemoteAddress().toString());
	}
	public void messageReceived( IoSession session, Object message ) throws Exception{
		test1(session,message);
	} 
	void test1(IoSession session, Object message){
		Gson gson=new Gson();
		Message msg=gson.fromJson(message.toString(), Message.class);
		System.out.println(msg.toString());
		if(msg.getMsg_body().trim().equalsIgnoreCase("quit")&&!session.isClosing()) {
			//�رջỰ����ǿ��ˢ��û��д����ڴ�
			CloseFuture future = session.close(true);
			//��¼���ӹر�
			future.awaitUninterruptibly();
			return;
		}
		Date date = new Date();
		msg.setMsg_body(date.toString());
		session.write(gson.toJson(msg));//���ص�ǰʱ����ַ���
	}
	void test0(IoSession session, Object message){
		String str = message.toString();
		System.out.println(str);
		System.out.println(str.trim().equalsIgnoreCase("quit"));
		System.out.println(!session.isClosing());
		if(str.trim().equalsIgnoreCase("quit")&&!session.isClosing()) {
			//�رջỰ����ǿ��ˢ��û��д����ڴ�
			CloseFuture future = session.close(true);
			//��¼���ӹر�
			future.awaitUninterruptibly();
			return;
		}
		Date date = new Date();
		session.write( "���ص�ǰʱ����ַ���"+date.toString() );//���ص�ǰʱ����ַ���
		System.out.println("Message written...");
	}
}
