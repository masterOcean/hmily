package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
	public static Integer Port = 18080;
	private Selector selector= null;
	public static void main(String[] args) {
		NioServer s = new NioServer();
		s.init();
		s.run();
	}
	
	public void init() {
		try {
			//开启selector
			this.selector = Selector.open();
			//开启异步channel
			ServerSocketChannel sSchannel = ServerSocketChannel.open();
			//绑定端口
			sSchannel.bind(new InetSocketAddress(NioServer.Port));
			sSchannel.configureBlocking(false);
			sSchannel.register(this.selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("init error");
		}
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("==== select");
				selector.select();
				Set keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				while(it.hasNext()) {
					SelectionKey key = it.next();
					if(key.isAcceptable()) {//处理链接
						this.accept(key);
						it.remove();
					}else if(key.isReadable()) {
					//处理read
						System.out.println("doRead");
						doRead(key);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void accept(SelectionKey key) {
		//监听的channel是serversocketchannel
		 ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
		 System.out.println("ServerSocketChannel正在循环监听");
		 try {
			SocketChannel sc = serverChannel.accept();
			sc.configureBlocking(false);
			sc.register(this.selector, SelectionKey.OP_READ);//监听只读
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StringBuilder doRead(SelectionKey key) {//处理只读
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer bb = ByteBuffer.allocate(128);
		StringBuilder sb = new StringBuilder();
		Integer len;
		try {
			len = sc.read(bb);
			while(len>0) {
				bb.flip();
				byte[] data = bb.array();
				sb.append(data);
				System.out.println(new String(data));
				bb.clear();
				len = sc.read(bb);
			}
			//设置为可读
			sc.register(this.selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;		
	}
	
}
