package javaDisassembly;

import java.io.FileInputStream;
import java.io.IOException;

import Util.AccessGetter;
import attribute_info.attribute_info;
import attribute_info.attribute_reader;
import cp_info.CONSTANT_Utf8_Info;
import cp_info.cp_info;

public class field_info {
	public u2               access_flags;
    public u2               name_index;
    public u2               descriptor_index;
    public u2               attributes_count;
    public attribute_info[] attributes;
    //additional info
    public String           name_str;
    public String           descriptor_str;
    public field_info(FileInputStream fis, cp_info[] constant_pool) throws IOException {
    	access_flags     = new u2(fis);
    	name_index       = new u2(fis);
    	descriptor_index = new u2(fis);
    	attributes_count = new u2(fis);
    	attributes       = new attribute_info[attributes_count.d];
    	for (int i = 0; i < attributes_count.d; i++) {
    		attributes[i] = attribute_reader.read(fis, constant_pool);
    	}
    	name_str       = ((CONSTANT_Utf8_Info) constant_pool[name_index.d       - 1]).value;
    	descriptor_str = ((CONSTANT_Utf8_Info) constant_pool[descriptor_index.d - 1]).value;
    }
    public String toString() {
    	String toRet = AccessGetter.get(access_flags.d);
    	toRet += descriptor_str + " " + name_str + " \n\t{\n";
    	for (int i = 0; i < attributes_count.d; i++) {
    		System.out.println("\t\t" + attributes[i]+ "\n");
    	}
    	toRet += "\t}";
    	return toRet;
    }
}
