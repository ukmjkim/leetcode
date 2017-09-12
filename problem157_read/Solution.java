// I wrote this in Java to prove my logic using ByteBuffers
// Probably could have done similar with char[] or String
// It builds and executes correctly.

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.BufferOverflowException;


public class Solution {

	public static void main(String[] args) {

		// Read input from file to have some test data in buffer
        Path path = Paths.get("testfile13.jpg"); // 13.1k
        FileChannel fileChannel = null;
        try
        {
        	 fileChannel = fileChannel.open(path);
        }
        catch (IOException e)
        {
        	System.out.println("File open failed");
        	return;
        }
        ByteBuffer fbuffer = ByteBuffer.allocateDirect(1024 * 50);
        
        int nbytesfromfile = 0;
        try
        {
        	nbytesfromfile = fileChannel.read(fbuffer);
            fileChannel.close(); // clean up and close file handle
        }
        catch (IOException e)
        {
        	System.out.println("File read to fbuffer failed");
        	return;
        }
        
        System.out.println("Num bytes read from file = " + nbytesfromfile);
        
        // Allocate more than enough mybuffer to read everything that came in from file
		ByteBuffer mybuffer = ByteBuffer.allocate(2 * nbytesfromfile);
        
		// Read data from fbuffer into mybuffer
		// Note position is kept by the byteBuffer object and incremented on puts		
		// Assumes -1 comes back on error and 0 returns when done
		int nBytes = 5 * 1024; // 5k as our number of byte we want (could be any N > 0)
		int nread = 0;
		int total = 0;
		
		// FLIP sets the buffer limit to the current position and moves position to zero
		// We need to start at beginning of buffer and have lower levels know when at end.
		// the rewind() function does not set the limit, so would not work for us here.
		fbuffer.flip();
		
		// Keep reading until we hit end
		while(total < nbytesfromfile )
		{
			nread = myRead(nBytes, fbuffer, mybuffer);
			if(nread == -1)
			{
				System.out.println("ERROR: Failed to read all bytes.");
				System.out.println("ERROR: Nbyte read = " + total);
				break;
			}
			total += nread;			
		}
		
		// Total should equial nbytesfromfile ... if code works as expected
		System.out.println("Total number of copied to mybuff = " +  total);
		return;
	}

	public static int myRead(int nbytesToRead, ByteBuffer inbuff, ByteBuffer outbuff)
	{
		// Constraint that we use myRead4k
		// Figure out how many calls to myRead4k required
		int ncalls = (nbytesToRead / 4096) + 1; // Always need at least 1
		int total = 0;
		int nread = 0;
		for(int i = 0; i<ncalls; i++)
		{
			nread = myRead4k(inbuff, outbuff);
			if(nread == -1)
			{
				System.out.println("Error in myRead");
				return -1;
			}
			total += nread;
		}
		// Need to rewind when 4k chunks go further than needed
		if(total > nbytesToRead)
		{
			int nrewind = total - nbytesToRead;
			int inpos = inbuff.position();
			inbuff.position(inpos-nrewind); 

			int outpos = outbuff.position();
			outbuff.position(outpos-nrewind);
			
			total = nbytesToRead;
		}
		// else it was either perfect fit or we hit EOF

		return total;
	}

	public static int myRead4k(ByteBuffer inbuff, ByteBuffer outbuff)
	{
		/* As defined during the interview, this will ready in 4k chunks
		 * and return less then 4k when hitting final partial chuck of 
		 * input buffer. Number of bytes read is returned and can be 
		 * anything from 0 to 4096.
		 */
		int nbytesToRead = 4096; // fixed 4k chunks
		
		// Only go to end of input if it does not contain 4096
		// Assumes limit of the inbuff has been set to desired stopping  point		
		if(inbuff.remaining() < nbytesToRead)
		{
			nbytesToRead = inbuff.remaining();		
		}
		// copy 
		int cnt = 0;
		for(; cnt<nbytesToRead; cnt++)
		{
			// position in both buffers in object instance
			try	{ outbuff.put(inbuff.get()); }
			catch (BufferOverflowException e) 
			{
				System.out.println("Error in myRead4k");
				System.out.println("Ran past end of output buffer");
				return -1; 
			}
		}		
		return cnt;
	}	
}
