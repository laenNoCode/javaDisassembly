package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u2;


public class CONSTANT_InvokeDynamic_Info extends cp_info {
	public u2 bootstrap_method_attr_index;
	public u2 name_and_type_index;
	public CONSTANT_InvokeDynamic_Info(FileInputStream FIS) throws IOException {
		this.bootstrap_method_attr_index = new u2(FIS);
		this.name_and_type_index         = new u2(FIS);
	}
	public String toString() {
		return "CONSTANT_InvokeDynamic : bmai = " + bootstrap_method_attr_index.d + "nti : " + name_and_type_index.d;
	}
}
