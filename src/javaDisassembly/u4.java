package javaDisassembly;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

public class u4 {
	public long d;// data
	public u4(byte[] b) {
		this.d = 0;
		for (int i = 0; i < 4; i++) {
			long t = b[i];
			t = (t < 0) ? 256 + t : t;
			this.d *= 256;
			this.d += t;
		}
	}
	public void setu4(byte[] b){
		this.d = 0;
		for (int i = 0; i < 4; i++) {
			long t = b[i];
			t = (t < 0) ? 256 + t : t;
			this.d *= 256;
			this.d += t;
		}
	}
	public u4 (FileInputStream fis) throws IOException {
		byte[] b4 = new byte[4];
		fis.read(b4);
		this.setu4(b4);
	}
	public String toString() {
		String allHex = "0123456789abcdef";
		Vector<String> hex = new Vector<String>();
		long actuel = this.d;
		for (int i = 0; i < 8; i++) {
			hex.add(0, ""+ allHex.charAt((int)(actuel%16)));
			actuel /= 16;
		}
		return String.join("", hex.toArray(new String[0]));
	}
}
