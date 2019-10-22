package org.dromara.hmily.dubbo.myTest;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestC {
	public static void main(String[] args) {
		ServiceLoader<SpiInterface> r =ServiceLoader.load(SpiInterface.class);
		Iterator it = r.iterator();
		while(it.hasNext()) {
			Object a =it.next();
			System.out.println(a.toString());
		}
	}
}
