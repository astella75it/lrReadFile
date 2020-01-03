package logRewriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;


public class lrReadFile {

		public static void main(String[] args) {
			String _inputFileName = args[0];
			String _inputlog4jConfigFileName = args[1];
			
			if (_inputFileName.length()==0 || _inputFileName == null) {
			  throw new NullPointerException("insert input file name with absolute path");
			}
				
			if (_inputlog4jConfigFileName.length()==0 || _inputFileName == null) {
				_inputlog4jConfigFileName = "./log4j2.xml";
			}
			
			BufferedReader reader;
			LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
			File file = new File(_inputlog4jConfigFileName);
			context.setConfigLocation(file.toURI());
			Logger logger = LogManager.getLogger(lrReadFile.class.getName());
			try {
				reader = new BufferedReader(new FileReader(_inputFileName));
				String line = reader.readLine();
				while (line != null) {
					logger.info(line);
					// read next line
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
