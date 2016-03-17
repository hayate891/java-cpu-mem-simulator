import java.util.*;
import java.io.*;

public class Project1 {
	public static void main(String[] args) { 
		try {
			// set up the memory
			Process memory = Runtime.getRuntime().exec("java Memory " + args[0]);
			InputStream memInputStream = memory.getInputStream();
			OutputStream memOutputStream = memory.getOutputStream();
			int instructionsToInterrupt = Integer.parseInt(args[1]);

			// create a cpu, and give it the above streams and interrupt timer
			CPU cpu = new CPU(memInputStream, memOutputStream, instructionsToInterrupt);
			cpu.startCPU();			
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}