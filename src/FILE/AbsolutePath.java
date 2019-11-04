package FILE;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AbsolutePath {
	private static URL img_url;

	public static void main(String[] args) {
		URL img_url = null;
		try {
			img_url = new File("sqhvsvdjvj").toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println(img_url.toString());
	}
}
