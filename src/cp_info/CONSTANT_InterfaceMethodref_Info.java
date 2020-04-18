package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u2;

public class CONSTANT_InterfaceMethodref_Info extends cp_info {
	public u2 class_index;
	public u2 name_and_type_index;
	public CONSTANT_InterfaceMethodref_Info(FileInputStream FIS) throws IOException {
		this.class_index = new u2(FIS);
		this.name_and_type_index = new u2(FIS);
	}
	public String toString() {
		return "CONSTANT_InterfaceMethodref : ci = " + class_index.d + " nti = " + name_and_type_index.d;
	}
}
