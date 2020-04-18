package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u2;

public class CONSTANT_MethodType_Info extends cp_info{
	public u2 descriptor_index;
	public CONSTANT_MethodType_Info(FileInputStream FIS) throws IOException {
		this.descriptor_index = new u2(FIS);
	}
	public String toString() {
		return "CONSTANT_MethodType : di = " + descriptor_index.d;
	}
}
