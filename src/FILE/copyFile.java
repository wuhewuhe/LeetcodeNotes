package FILE;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;


public class copyFile {

	public static void main(String[] args) throws IOException {
		File a = new File("C:/Users/he.wu/Desktop/DirectoryListener/todo.txt");
		File b = new File("C:/Users/he.wu/Desktop/");
		Files.copy(a.toPath(), new FileOutputStream(b));
		Files.delete(a.toPath());
	}
}
