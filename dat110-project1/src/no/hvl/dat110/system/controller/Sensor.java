package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.*;

public class Sensor extends RPCStub {

	private byte RPCID = 1;
	
	public int read() {
		
		// TODO
		// implement marshalling, call and unmarshalling for read RPC method
		rmiclient.connect();
		byte[] bSend = RPCUtils.marshallInteger(RPCID, 0);
		byte[] bReceived = rmiclient.call(bSend);
		int temp = RPCUtils.unmarshallInteger(bReceived);
		
		return temp;
	}
	
}
