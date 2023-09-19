package roguelike.utils.logger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 * 
 * It is a logger that can export simple logs.
 * 
 * @author unlucky0314
 *
 */
public class SimpleLogger {
	private static String logFilePath = null;
	private static SimpleDateFormat dateFormat = null;

	PrintWriter writer = null;

	/**
	 * 
	 * constructor.
	 * 
	 * @param logFileDirectory Set the directory where log files are generated.<br>
	 *                          example "aaa/bbb/"
	 * @throws IOException
	 */
	public SimpleLogger(String logFileDirectory) {
		try {
			Date date = new Date();
			if (dateFormat == null) {
				dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			}
			_directoryExistCheck(logFileDirectory);

			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
			logFilePath = logFileDirectory + "Log" + format.format(date) + ".log";

			writer = new PrintWriter(logFilePath, "UTF-8");
		} catch (IOException e) {
			writer.close();
			e.printStackTrace();
		}
	}

	/**
	 * Aligns the string centered within the size range.
	 * 
	 * @param s string.
	 * @param size range.
	 * @return result
	 */
	private static String center(String s, int size) {
		return center(s, size, ' ');
	}

	/**
	 * Aligns the string centered within the size range.
	 * 
	 * @param s string.
	 * @param size range.
	 * @return result
	 */
	private static String center(String s, int size, char pad) {
		if (s == null || size <= s.length()) {
			return s;
		}

		StringBuilder builder = new StringBuilder(size);
		for (int i = 0; i < (size - s.length()) / 2; i++) {
			builder.append(pad);
		}
		builder.append(s);
		while (builder.length() < size) {
			builder.append(pad);
		}
		return builder.toString();
	}

	/**
	 * 
	 * @param directoryPath
	 */
	private void _directoryExistCheck(String directoryPath) throws IOException {
		File file = new File(directoryPath);
		if (!file.exists()) {
			Path path = Paths.get(directoryPath);
			Files.createDirectories(path);
		}
	}

	public void close() {
		if (writer != null) {
			writer.close();
			writer = null;
		}
	}

	/**
	 * Log a message, with no arguments.
	 * 
	 * @param level Log level.
	 * @param message Log message.
	 */
	public void log(String level, String message) {
		Date date = new Date();
		String result = "%s [ %s ] : %s".formatted(
				dateFormat.format(date), center(level, 9), message);
		System.out.println(result);
		writer.println(result);
	}

	/**
	 * Log a message, with no arguments.
	 * 
	 * @param level Log level.
	 * @param message Log message.
	 */
	public void log(Level level, String message) {
		this.log(level.getName(), message);
	}

	/**
	 * Log an information message.
	 * 
	 * @param message
	 */
	public void info(String message) {
		this.log(Level.INFO, message);
	}

	/**
	 * Log a warning message.
	 * 
	 * @param message
	 */
	public void warning(String message) {
		this.log(Level.WARNING, message);
	}

	/**
	 * Log an error message.
	 * 
	 * @param message
	 */
	public void error(String message) {
		this.log("ERROR", message);
	}

	/**
	 * Log an exception message.
	 * 
	 * @param message
	 * @param e
	 */
	public void exception(String message, Exception e) {
		String error = "    " + e.getMessage() + "\n";
		for (var stackTrace : e.getStackTrace()) {
			error += "    at " + stackTrace + "\n";
		}
		this.log("EXCEPTION", message + ":\n" + error);
	}

	@Override
	public void finalize() {
		close();
	}
}
