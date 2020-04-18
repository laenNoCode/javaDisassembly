package cp_info;

import java.io.FileInputStream;
import java.io.IOException;

import javaDisassembly.u4;

public class CONSTANT_Double_Info extends cp_info {
	public u4 high;
	public u4 low;
	public double computedValue;
	public CONSTANT_Double_Info(FileInputStream FIS) throws IOException {
		this.high = new u4(FIS);
		this.low = new u4(FIS);
		long bits = ((long) high.d << 32) + low.d;
		int s = ((bits >> 63) == 0) ? 1 : -1;
		int e = (int)((bits >> 52) & 0x7ffL);
		long m = (e == 0) ?
		           (bits & 0xfffffffffffffL) << 1 :
		           (bits & 0xfffffffffffffL) | 0x10000000000000L;
		int te = e - 1075;
		this.computedValue = s * m;
		if (te >= 0) {
			for (int i = 0 ; i < te; i++)
				this.computedValue *= 2.0d;
		}
		else {
			for (int i = 0; i < - te; i++) {
				this.computedValue /= 2.0d;
			} 
		}
	}
	public String toString() {
		return "CONSTANT_Double : high = " + high.d  + "low = " + low.d + "parsed : " + computedValue;
	}
}
