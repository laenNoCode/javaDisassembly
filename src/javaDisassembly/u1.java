package javaDisassembly;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;

public class u1 {
	public short d;
	public u1(byte b) {
		if (b < 0) {
			this.d = (short) (((short) b) + 256);
		}
		else {
			this.d = b;
		}
	}
	public void setu1(byte b) {
		if (b < 0) {
			this.d = (short) (((short) b) + 256);
		}
		else {
			this.d = b;
		}
	}
	public u1(FileInputStream FIS) throws IOException {
		byte[] b = new byte[1];
		FIS.read(b);
		this.setu1(b[0]);
	}
	public String toString() {
		String allHex = "0123456789abcdef";
		Vector<String> hex = new Vector<String>();
		short actuel = this.d;
		for (int i = 0; i < 2; i++) {
			hex.add(0, ""+ allHex.charAt(actuel%16));
			actuel /= 16;
		}
		return String.join("", hex.toArray(new String[0]));
	}
}
