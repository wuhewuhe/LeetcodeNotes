package FILE;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class copyFile {

	public static void main(String[] args) throws IOException {
		File a = new File("C:/Users/he.wu/Desktop/DirectoryListener/todo.txt");
		File b = new File("C:/Users/he.wu/Desktop/");
		System.out.println(a.toString());
		String s = a.toString();
		System.out.println(s.substring(s.lastIndexOf('\\')));
		StringBuilder sb = new StringBuilder();
		sb.append("a" + '/');
		System.out.println(sb.toString());
		final FilenameFilter filter = (File dir, String name) -> {
		    return name.startsWith("a");
		};
	}
}
