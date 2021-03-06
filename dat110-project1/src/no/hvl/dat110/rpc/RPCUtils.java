package no.hvl.dat110.rpc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded = new byte[str.getBytes().length + 1];

		encoded[0] = rpcid;
		for(int i = 0; i < str.getBytes().length; i++) {
			encoded[i + 1] = str.getBytes()[i];
		}
		

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded = new String(Arrays.copyOfRange(data, 1, data.length));

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded = new byte[1];
		encoded[0] = rpcid;

		// TODO: marshall RPC identifier in case of void type

		

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] temp = ByteBuffer.allocate(4).putInt(x).array();
		byte[] encoded = new byte[temp.length + 1];
		encoded[0] = rpcid;
		for(int i = 0; i < temp.length; i++) {
			encoded[i + 1] = temp[i];
		}
		// TODO: marshall RPC identifier and string into byte array

		

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {
		byte[] temp = new byte[data.length - 1];
		for(int i = 1; i < data.length; i++) {
			temp[i - 1] = data[i];
		}
		int decoded = ByteBuffer.wrap(temp).getInt();

		// TODO: unmarshall integer contained in data

		

		return decoded;

	}
}
