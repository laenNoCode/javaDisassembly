package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u2;

public class CONSTANT_NameAndType_info extends cp_info {
	public u2 name_index;
	public u2 descriptor_index;
	public CONSTANT_NameAndType_info(FileInputStream FIS) throws IOException {
		this.name_index       = new u2(FIS);
		this.descriptor_index = new u2(FIS);
	}
	public String toString() {
		return "CONSTANT_NameAndType : ni = " + name_index.d + " di = " + descriptor_index.d;
	}
}
