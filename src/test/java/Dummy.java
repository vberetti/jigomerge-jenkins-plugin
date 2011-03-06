import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Collections;

public class Dummy {

	public static void main(String[] args) throws Exception {

		String fileName = "jigomerge.groovy";
		GroovyClassLoader gcl = new GroovyClassLoader();
		Class clazz = gcl.parseClass(new File(fileName));
		Constructor[] cs = clazz.getConstructors();
		System.out.println(cs);
		Object o = cs[0].newInstance(true, Collections.EMPTY_LIST, false, false, true, "toto", "toto");
		System.out.println(o);
		
		Object[] argsM = {"http://toto", null};
		((GroovyObject)o).invokeMethod("launchSvnMerge", argsM);
		
		/*
		 * String[] roots = new String[] {
		 * GroovyScriptEngine gse = new GroovyScriptEngine(roots); Binding
		 * binding = new Binding(); binding.setVariable("args", new
		 * Object[]{"-S", "http://toto", "-u", "toto", "-p", "toto"}); Object
		 * output = gse.run("jigomerge.groovy", binding);
		 * System.out.println(output);
		 */
	}
}
