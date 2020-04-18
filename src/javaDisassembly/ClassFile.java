package javaDisassembly;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import cp_info.*;

public class ClassFile {
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
	    	magic = new u4(fis);
	    	minor_version = new u2(fis);
	    	major_version = new u2(fis);
	    	constant_pool_count = new u2(fis);
	    	constant_pool = new cp_info[constant_pool_count.d - 1];
	    	for (int i = 0; i < constant_pool_count.d - 1; i++) {
	    		constant_pool[i] = cpReader.readNext(fis);
	    	}
	    	fis.close();
	    }
	    public void printMe() {
	    	System.out.println("magic      : " + magic.toString()); // normal must be cafe babe
	    	System.out.println("minor      : " + minor_version.d);
	    	System.out.println("major      : " + major_version.d);
	    	System.out.println("pool count : " + constant_pool_count.d);
	    	for (int i = 0; i < constant_pool_count.d - 1; i++) {
	    		System.out.println("" + (i+1) + " : " + constant_pool[i].toString());
	    	}
	    }
	    public static void main(String...strings) throws IOException {
	    	ClassFile cf = new ClassFile("D:/Projets/javaBin/desassembleur/test.class");
	    	cf.printMe();
	    }
}

