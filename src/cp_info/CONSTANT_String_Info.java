package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u2;

public class CONSTANT_String_Info extends cp_info {
	public u2 string_index;
	public CONSTANT_String_Info(FileInputStream FIS) throws IOException {
		this.string_index = new u2(FIS);
	}
	public String toString() {
		return "CONSTANT_String : si = " + string_index.d;
	}
}
