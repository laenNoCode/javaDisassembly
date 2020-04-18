package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u2;

public class CONSTANT_Utf8_Info extends cp_info {
	public u2 length;
	public String value;
	public CONSTANT_Utf8_Info(FileInputStream FIS) throws IOException {
		this.length = new u2(FIS);
		byte[] b = new byte[length.d];
		FIS.read(b);
		this.value = new String(b);
	}
	public String toString() {
		return "CONSTANT_UTF8 : length = " + length.d + " (" + value + ")";
	}
}
