package attribute_info;

import java.io.FileInputStream;
import java.io.IOException;

import cp_info.CONSTANT_Utf8_Info;
import cp_info.cp_info;
import javaDisassembly.u1;
import javaDisassembly.u2;
import javaDisassembly.u4;

public class attribute_info {
	public u2 attribute_name_index;
	public String attribute_name = "";
    public u4 attribute_length;
    public u1[] info;
    public attribute_info(FileInputStream fis) throws IOException{
    	attribute_name_index = new u2(fis);
    	attribute_length     = new u4(fis);
    	info = new u1[(int) attribute_length.d];
    	for (int i = 0; i < attribute_length.d; i++) {
    		info[i]          = new u1(fis);
    	}
    }
    public attribute_info(FileInputStream fis,cp_info[] constant_pool) throws IOException{
    	attribute_name_index = new u2(fis);
    	attribute_length     = new u4(fis);
    	info = new u1[(int) attribute_length.d];
    	for (int i = 0; i < attribute_length.d; i++) {
    		info[i]          = new u1(fis);
    	}
    	attribute_name = ((CONSTANT_Utf8_Info) constant_pool[attribute_name_index.d]).value;
    }
    public String toString() {
    	return "UNKNOWN index=" + attribute_name_index.d + " (" + attribute_name + ")";
    }
}
