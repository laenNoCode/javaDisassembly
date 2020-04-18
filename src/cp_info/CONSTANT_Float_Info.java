package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u4;

public class CONSTANT_Float_Info extends cp_info {
	//computation method found here : https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.4.4
	public u4 value;
	public float computedValue;
	public CONSTANT_Float_Info(FileInputStream FIS) throws IOException {
		this.value = new u4(FIS);
		long bits = value.d;
		int s = ((bits >> 31) == 0) ? 1 : -1;
		int e = (int) ((bits >> 23) & 0xff);
		int m = (int) ((e == 0) ?(bits & 0x7fffff) << 1 :(bits & 0x7fffff) | 0x800000);
		int te = e - 150;
		this.computedValue = s * m;
		if (te >= 0) {
			for (int i = 0 ; i < te; i++)
				this.computedValue *= 2.0f;
		}
		else {
			for (int i = 0; i < - te; i++) {
				this.computedValue /= 2.0f;
			} 
		}
	}
	public String toString() {
		return "CONSTANT_Float : raw = " + value.d + "parsed : " + computedValue;
	}
}
