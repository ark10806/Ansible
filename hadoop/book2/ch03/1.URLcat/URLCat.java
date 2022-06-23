import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

public class URLCat {
	static {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}

	public static void main(String[] args) throws Exception {
		InputStream in = null;

		try {
			in = new URL(args[0]).openStream();
			IOUtils.copyBytes(in, System.out, 4096, false);
			// InputStream in, OutputStream out, int buffsize, boolean close
		} finally {
			IOUtils.closeStream(in);
		}
	}
}
