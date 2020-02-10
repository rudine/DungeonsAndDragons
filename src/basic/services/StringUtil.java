package basic.services;

public class StringUtil {

	public static String convertCamelCase(String camelCase)
	{
		if (camelCase == null)
			return null;

		StringBuilder builder = new StringBuilder(camelCase.length() + 10);
		builder.append(camelCase.charAt(0));
		char c;
		for (int i = 1; i < camelCase.length(); i++)
		{
			c = camelCase.charAt(i);
			if (c == '_')
				builder.append(' ');
			else if (Character.isUpperCase(c) && i + 1 < camelCase.length()
				&& !Character.isUpperCase(camelCase.charAt(i + 1))
				&& !Character.isUpperCase(camelCase.charAt(i - 1)))
			{
				builder.append(' ');
				builder.append(Character.toLowerCase(c));
			}
			else
				builder.append(c);
		}
		return builder.toString();
	}
}
