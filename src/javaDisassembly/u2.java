package javaDisassembly;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

public class u2 {
	public int d;//data
	public u2(byte[] b) {
		this.d = 0;
		for (int i = 0; i < 2; i++) {
			int t = b[i];
			t = (t < 0) ? 256 + t : t;
			this.d *= 256;
			this.d += t;
		}
	}
	public u2(FileInputStream fis) throws IOException {
		byte[] b2 = new byte[2];
		fis.read(b2);
		this.setu2(b2);
	}
	public void setu2(byte[] b) {
		this.d = 0;
		for (int i = 0; i < 2; i++) {
			int t = b[i];
			t = (t < 0) ? 256 + t : t;
			this.d *= 256;
			this.d += t;
		}
	}
	public String toString() {
		String allHex = "0123456789abcdef";
		Vector<String> hex = new Vector<String>();
		int actuel = this.d;
		for (int i = 0; i < 4; i++) {
			hex.add(0, ""+ allHex.charAt(actuel%16));
			actuel /= 16;
		}
		return String.join("", hex.toArray(new String[0]));
	}
}
