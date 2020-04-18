package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u1;

public class cpReader {
	//toIMP { "CONSTANT_InterfaceMethodref"}
	public static final String[] tags = {"", "CONSTANT_Utf8", "", "CONSTANT_Integer", "CONSTANT_Float", "CONSTANT_Long", "CONSTANT_Double", "CONSTANT_Class","CONSTANT_String", "CONSTANT_Fieldref", "CONSTANT_Methodref", "CONSTANT_InterfaceMethodref", "CONSTANT_NameAndType", "", "CONSTANT_MethodHandle", "CONSTANT_MethodType", "", "CONSTANT_InvokeDynamic"};
	public static cp_info readNext(FileInputStream FIS) throws IOException {
		u1 tag = new u1(FIS);
		cp_info toRet = new cp_info();
		String tagStr = tags[tag.d];
		if (tagStr.contentEquals("CONSTANT_Class"))
			toRet = new CONSTANT_Class_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_Methodref")) 
			toRet = new CONSTANT_Methodref_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_NameAndType"))
			toRet = new CONSTANT_NameAndType_info(FIS);
		if (tagStr.contentEquals("CONSTANT_Utf8"))
			toRet = new CONSTANT_Utf8_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_Fieldref"))
			toRet = new CONSTANT_Fieldref_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_String"))
			toRet = new CONSTANT_String_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_Integer"))
			toRet = new CONSTANT_Integer_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_Float"))
			toRet = new CONSTANT_Float_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_Long"))
			toRet = new CONSTANT_Long_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_Double"))
			toRet = new CONSTANT_Double_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_MethodHandle"))
			toRet = new CONSTANT_MethodHandle_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_MethodType"))
			toRet = new CONSTANT_MethodType_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_InvokeDynamic"))
			toRet = new CONSTANT_InvokeDynamic_Info(FIS);
		if (tagStr.contentEquals("CONSTANT_InterfaceMethodref"))
			toRet = new CONSTANT_InterfaceMethodref_Info(FIS);
		toRet.tag = tag;
		return toRet;
	}
}
