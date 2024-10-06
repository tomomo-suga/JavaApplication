import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsoleLog {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(ConsoleLog.class.getName());
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.INFO);
		logger.addHandler(consoleHandler);
		logger.info("処理を開始しました。");
		logger.info("処理を終了しました。");
	}
}
