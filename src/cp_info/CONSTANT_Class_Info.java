package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u2;

public class CONSTANT_Class_Info extends cp_info {
	public u2 name_index;
	public CONSTANT_Class_Info(FileInputStream FIS) throws IOException {
		this.name_index = new u2(FIS);
	}
	public String toString() {
		return "CONSTANT_Class : ni = " + name_index.d;
	}
}
