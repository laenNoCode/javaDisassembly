package javaDisassembly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import attribute_info.attribute_info;
import cp_info.*;

public class ClassFile {
		public static final String[] ACCESS_LOOKUP = {"public", "private", "protected","static", "final", "synchronized", "bidged", "varargs","native", "abstract", "strict", "synthetic"};
	    public u4               magic;
	    public u2               minor_version;
	    public u2               major_version;
	    public u2               constant_pool_count;
	    public cp_info[]        constant_pool;
	    public u2               access_flags;
	    public u2               this_class;
	    public u2               super_class;
	    public u2               interfaces_count;
	    public u2[]             interfaces;
	    public u2               fields_count;
	    public field_info[]     fields;
	    public u2               methods_count;
	    public method_info[]    methods;
	    public u2               attributes_count;
	    public attribute_info[] attributes;
	    public ClassFile(String Path) throws IOException {
	    	FileInputStream fis = new FileInputStream(new File (Path));	
	    	magic               = new u4(fis);
	    	minor_version       = new u2(fis);
	    	major_version       = new u2(fis);
	    	constant_pool_count = new u2(fis);
	    	constant_pool       = new cp_info[constant_pool_count.d - 1];
	    	for (int i = 0; i < constant_pool_count.d - 1; i++) {
	    		constant_pool[i] = cpReader.readNext(fis);
	    	}
	    	access_flags        = new u2(fis);
	    	this_class          = new u2(fis);
	    	super_class         = new u2(fis);
	    	interfaces_count    = new u2(fis);
	    	interfaces          = new u2[interfaces_count.d];
	    	for (int i = 0; i < interfaces_count.d; i++) {
	    		interfaces[i]   = new u2(fis);
	    	}
	    	fields_count        = new u2(fis);
	    	fields              = new field_info[fields_count.d];
	    	for (int i = 0; i < fields_count.d; i++) 
	    	{
	    		fields[i] = new field_info(fis, constant_pool);
	    	}
	    	fis.close();
	    }
	    public void printMe() {
	    	System.out.println("magic      : " + magic.toString()); // normal must be cafe babe
	    	System.out.println("minor      : " + minor_version.d);
	    	System.out.println("major      : " + major_version.d);
	    	System.out.println("pool count : " + constant_pool_count.d);
	    	System.out.println("------------ start of pool -------------");
	    	for (int i = 0; i < constant_pool_count.d - 1; i++) {
	    		System.out.println("" + (i+1) + " : " + constant_pool[i].toString());
	    	}
	    	System.out.println("------------ end of pool ---------------");
	    	int tmpflags = access_flags.d;
	    	for (String access:ACCESS_LOOKUP) {
	    		if (tmpflags%2 == 1)
	    			System.out.print(access + " ");
	            tmpflags /= 2;
	    	}
	    	CONSTANT_Class_Info thisclass  = (CONSTANT_Class_Info) (constant_pool[this_class.d  - 1]);
	    	CONSTANT_Class_Info superclass = (CONSTANT_Class_Info) (constant_pool[super_class.d - 1]);;
	    	System.out.print(((CONSTANT_Utf8_Info) constant_pool[thisclass.name_index.d  - 1]).value + " extends ");
	    	System.out.print(((CONSTANT_Utf8_Info) constant_pool[superclass.name_index.d - 1]).value + " implements ");
	    	for (int i = 0; i < interfaces_count.d; i++) {
	    		CONSTANT_Utf8_Info interfaceAct =(CONSTANT_Utf8_Info) constant_pool[interfaces[i].d]; 
	    		System.out.print(interfaceAct.value);
	    	}
	    	System.out.println();
	    	System.out.println("{");
	    	for (int i = 0; i < fields_count.d; i++) 
	    	{
	    		System.out.println("\t" + i + " : " + fields[i]);
	    	}
	    	System.out.println("}");
	    }
	    public static void main(String...strings) throws IOException {
	    	ClassFile cf = new ClassFile("D:/Projets/javaBin/desassembleur/test.class");
	    	cf.printMe();
	    }
}

