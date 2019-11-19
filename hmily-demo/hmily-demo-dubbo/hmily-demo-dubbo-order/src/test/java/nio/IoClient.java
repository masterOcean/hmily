package nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class IoClient {
	public static  void main(String[] args) {
	    String host = "127.0.0.1";
	    int port = 18080;	    
	    InputStream inputStream;
		try {
		    // 与服务端建立连接
		    Socket socket = new Socket(host, port);
		    // 建立连接后获得输出流
		    
		    OutputStream outputStream = socket.getOutputStream();
		    for(int i=0;i<5000;i++) {
			    String message = "hello,"+ new Integer(i);
			    socket.getOutputStream().write(message.getBytes("UTF-8"));
			    //只发送
			    socket.getOutputStream().flush();
			    try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    
		    //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
		    //socket.shutdownOutput();
			/*inputStream = socket.getInputStream();
		    byte[] bytes = new byte[1024];
		    int len;
		    StringBuilder sb = new StringBuilder();
		    while ((len = inputStream.read(bytes)) != -1) {
		      //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
		      sb.append(new String(bytes, 0, len,"UTF-8"));
		    }
		    System.out.println("get message from server: " + sb);
		    
		    inputStream.close();
		    outputStream.close();
		    socket.close();*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
}
