package cn.basejava.reflection;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo04 {
	public static void main(String[] args) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "c:/myjava/HelloWorld.java");
		System.out.println(result==0?"编译成功":"编译失败");
	}
}
