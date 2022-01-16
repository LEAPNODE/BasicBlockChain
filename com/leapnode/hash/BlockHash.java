package com.leapnode.hash;

import java.security.MessageDigest;

/**
 * BlockHash leverages built in hashing classes in Java.  MessageDigest can use SHA-1 and SHA-256
 * and would assume others.  For this example, SHA-256 will be used.
 *
 * @author brandon@solanaleap.com
 * @since 0.1
 * @version 0.1
 */
public class BlockHash {
    /**
     * Static method returning a SHA-356 hash value.  The input can include contents of the block
     * including transaction data, date and timestamp.
     * @param input - Block input data.  This is up to the implementor as to what is included.
     * @return - SHA-256 hash value of the block input data
     */
    public static String sha256(String input)
    {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");

            int i = 0;

            byte[] hash = sha.digest(input.getBytes("UTF-8"));

            // hexHash will contain the hexadecimal (base 16) hash
            StringBuffer hexHash = new StringBuffer();

            while (i < hash.length) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1)
                    hexHash.append('0'); // why is '0' used?
                hexHash.append(hex);
                i++;
            }

            return hexHash.toString();
        }
        catch (NullPointerException npe){
            throw new NullPointerException("Input cannot be null - The block value to have the has applied is null." + npe.getMessage());
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
