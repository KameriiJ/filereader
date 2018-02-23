package filereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFileByBufferedReaderTask implements Runnable{
	/** uml of Alice-in-Wonderland 	*/
	private final static String ALICE = "http://se.cpe.ku.ac.th/doc/samples/Alice-in-Wonderland.txt";
	
	public String readFileByBufferedReader(String url) {
		InputStream in;
		String all = "";
		try {
			OpenUrl op = new OpenUrl();
			in = op.openUrl(url);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = reader.readLine();
			while(line != null) {
				all = all + line + "\n";
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return all.toString();
	}

	@Override
	public void run() {
		readFileByBufferedReader(ALICE);
	}
	
	public String toString() {
		int chars = readFileByBufferedReader(ALICE).length();
		String intro = "Alice-in-Wonderland.txt using BufferedReader, append lines to String.";
		return String.format("%s\nRead %d chars in ", intro, chars);
	}

}
