package cp_info;

import java.io.FileInputStream;
import java.io.IOException;


import javaDisassembly.u4;

public class CONSTANT_Integer_Info extends cp_info {
	public u4 value;
	public CONSTANT_Integer_Info(FileInputStream FIS) throws IOException {
		this.value = new u4(FIS);
	}
	public String toString() {
		return "CONSTANT_Integer : unsigned = " + value.d + "signed : " + ((int) value.d);
	}
}
