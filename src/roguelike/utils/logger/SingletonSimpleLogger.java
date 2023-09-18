package roguelike.utils.logger;

import roguelike.utils.Singleton;

/**
 * Singleton Sinmle Logger
 * @author USER
 *
 */
public class SingletonSimpleLogger implements Singleton {
	private static SingletonSimpleLogger _instance = null;

	private SimpleLogger logger = null;

	private SingletonSimpleLogger(String logFileDirectory) {
		logger = new SimpleLogger(logFileDirectory);
	}

	public static void Initialize(String logFileDirectory) {
		if (_instance == null) {
			_instance = new SingletonSimpleLogger(logFileDirectory);
		}
	}

	public static void Finalize() {
		if (_instance != null) {
			_instance.finalize();
			_instance = null;
		}
	}

	private static SingletonSimpleLogger _getInstance() throws NullPointerException {
		if (_instance == null) {
			throw new NullPointerException();
		}
		return _instance;
	}

	private SimpleLogger _getLogger() {
		if (logger == null) {
			throw new NullPointerException("Initialize is not called.");
		}
		return logger;
	}

	public static SimpleLogger getLogger() {
		return _getInstance()._getLogger();
	}

	@Override
	public void finalize() {
		if (logger != null) {
			logger.close();
			logger = null;
		}
	}
}
