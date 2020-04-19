package Util;

public class AccessGetter {
	public static final String[] ACCESS_LOOKUP = {"public", "private", "protected","static", "final", "synchronized", "bidged", "varargs","native", "abstract", "strict", "synthetic"};
	public static String get(int attr) {
		String toRet = "";
		for (String access:ACCESS_LOOKUP) {
			if (attr % 2 == 1) {
				toRet += access + " ";
			}
			attr /= 2;
		}
		return toRet;
	}
}
