package javaDisassembly;

import java.io.FileInputStream;
import java.io.IOException;

import attribute_info.attribute_info;

public class method_info {
	 u2             access_flags;
	 u2             name_index;
	 u2             descriptor_index;
	 u2             attributes_count;
	 attribute_info[] attributes;
	 public method_info(FileInputStream FIS) throws IOException{
		 access_flags     = new u2(FIS);
		 name_index       = new u2(FIS);
		 descriptor_index = new u2(FIS);
		 attributes_count = new u2(FIS);
		 attributes       = new attribute_info[attributes_count.d];
	 }
}
