package roguelike.utils.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * 
 * Formatter for simple logs.
 * 
 * @author unlucky0314
 *
 */
public class SimpleLogFormatter extends Formatter
{
	private SimpleDateFormat dateFormat = null;
	
	@Override
	public String format(LogRecord record)
	{
		if(dateFormat == null)
		{
			dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		}
		final String msg = formatMessage(record);
		
		return "%s [%s] : %s%n".formatted(
				dateFormat.format(Date.from(record.getInstant())), center(record.getLevel().getName(), 7), msg);
	}
	
	/**
	 * Aligns the string centered within the size range.
	 * 
	 * @param s string.
	 * @param size range.
	 * @return result
	 */
	private static String center(String s, int size)
	{
		return center(s, size, ' ');
	}
	
	/**
	 * Aligns the string centered within the size range.
	 * 
	 * @param s string.
	 * @param size range.
	 * @return result
	 */
	private static String center(String s, int size, char pad)
	{
		if(s == null || size <= s.length())
		{
			return s;
		}
		
		StringBuilder builder = new StringBuilder(size);
		for(int i = 0; i < (size - s.length()) / 2; i++)
		{
			builder.append(pad);
		}
		builder.append(s);
		while(builder.length() < size)
		{
			builder.append(pad);
		}
		return builder.toString();
	}
}
