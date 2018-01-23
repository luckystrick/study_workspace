package com.herman.protocol;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.herman.util.SocketUtil;

public class ServerInit {
	
	private IoAcceptor acceptor = new NioSocketAcceptor();
	
	public void inti() {
		getAcceptor().getFilterChain().addLast("logger", new LoggingFilter());
		// ָ�����������
		//acceptor.getFilterChain().addLast("codec",new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
		getAcceptor().getFilterChain().addLast("codec",new ProtocolCodecFilter(new PrefixedStringCodecFactory(Charset.forName("UTF-8"))));
		// ָ��ҵ���߼�������
		getAcceptor().setHandler(new ClientIpPortServerHandler());
		// ���ö˿ں�
		getAcceptor().setDefaultLocalAddress(new InetSocketAddress(SocketUtil.PORT));
		// ��������
		try {
			getAcceptor().bind();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*IoServiceMBean acceptorBean=new IoServiceMBean(acceptor);
		try {
			ObjectName acceptorName=new ObjectName(acceptor.getClass().getPackage().getName()+":type=acceptor,name="+acceptor.getClass().getSimpleName());
			try {
				mBeanServer.registerMBean(acceptorBean, acceptorName);
			} catch (InstanceAlreadyExistsException e) {
				e.printStackTrace();
			} catch (MBeanRegistrationException e) {
				e.printStackTrace();
			} catch (NotCompliantMBeanException e) {
				e.printStackTrace();
			}
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}*/
	}

	public IoAcceptor getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(IoAcceptor acceptor) {
		this.acceptor = acceptor;
	}
	
}
