package filereader;

/**
 * Read text from URL by using InputStreamReader and append it to String.
 * 
 * @author Gunthee tawewatmongkol
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileToStringTask implements Runnable{
	/** URL of Alice-in-Wonderland 	*/
	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";
	
	/**
	 * Read text from URL by using InputStreamReader and append it to String.
	 * 
	 * @param url
	 * @return all text in url.
	 */
	public String readFileToString(String url)  {
		InputStream in;
		String all = "";
		try {
			OpenUrl op = new OpenUrl();
			in = op.openUrl(url);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while(true) {
				c = reader.read();
				if(c < 0) break;
				all = all + (char)c;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public void run() {
		readFileToString(ALICE);
	}
	
	@Override
	public String toString() {
		int chars = readFileToString(ALICE).length();
		String intro = "Alice-in-Wonderland.txt using InputStreamReader, append to String.";
		return String.format("%s\nRead %d chars in ", intro, chars);
	}
}
