/**
 * 
 */
package gaydadsLab1;

/**
 * @author David Gayda
 *
 */
import java.io.*;
import java.net.*;


public class ReadingWritingData {

	//Change
	protected String filename;
	protected int int1, int2;
	protected float float1, float2;
	protected double double1, double2;
	protected long long1, long2;

	public ReadingWritingData(String filename) throws Exception {
		this.filename = filename;
		// Call reading method
		// TODO
		readFile();

		// Call writing methods
		// TODO
		writeNumericValues();
		writeStringValues();

		// Socket Work
		writeToSocket();
	} // end constructor

	public void readFile() throws Exception {
		FileInputStream fis = new FileInputStream(ReadingWritingData.this.filename);
		DataInputStream dis = new DataInputStream(fis);
		System.out.println("Values read from " + ReadingWritingData.this.filename);



		System.out.print( dis.readInt() + " " );
		System.out.print( dis.readInt() + " " );
		System.out.print( dis.readFloat() + " " );
		System.out.print( dis.readFloat() + " " );
		System.out.print( dis.readDouble() + " " );
		System.out.print( dis.readDouble() + " " );
		System.out.print( dis.readLong() + " " );
		System.out.print( dis.readLong() + " " );


		dis.close();
		fis.close();
	} // end readFile

	public void writeNumericValues() throws IOException {
		FileOutputStream fos = new FileOutputStream("numericTypes.dat");
		DataOutputStream dos = new DataOutputStream(fos);

		dos.writeInt(3);
		dos.writeInt(5);
		dos.writeFloat(2.67f);
		dos.writeFloat(-8.5f);
		dos.writeDouble(123.0);
		dos.writeDouble(33.3);
		dos.writeLong(1000044);
		dos.writeLong(1500);

		dos.close();
		fos.close();


	} // end writeIntValues

	public void writeStringValues() throws IOException {
		FileWriter fw = new FileWriter("textTypes.dat");
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write("3 5 2.67 -8.5 123.0 33.3 1000044 1500");

		bw.close();
		fw.close();
	} // end writeStringValues

	public void writeToSocket() {
		DataOutputStream dos;
		Socket socket = null;
		
		try {
			//Replace IP Address
			socket = new Socket( InetAddress.getByName("192.168.0.16"), 32100);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("\nException Caught");
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("\nException Caught");
			e.printStackTrace();
		}

		try {
			dos = new DataOutputStream( socket.getOutputStream());
			
			dos.writeInt(3);
			dos.writeInt(5);
			dos.writeFloat(2.67f);
			dos.writeFloat(-8.5f);
			dos.writeDouble(123.0);
			dos.writeDouble(33.3);
			dos.writeLong(1000044);
			dos.writeLong(1500);
			
			dos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws Exception {
		System.out.println("HelloWorld!");
		new ReadingWritingData("numericTypes.dat");


	} // end main
} // end ReadingWritingData class