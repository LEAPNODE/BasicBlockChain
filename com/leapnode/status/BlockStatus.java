package com.leapnode.status;

public class BlockStatus {
    public static final int VALID = 50;   // Block is valid
    public static final int INVALID = 51; // Block is invalid.  This may be due to lack of a parameter required to create the hash.
    public static final int ERROR = 52;   // There is an error with the block.  Perhaps not added to the Blockchain
    public static final int NULL = 53;    // Block contains null values.

    private static int currentStatus = NULL;

    public static int getStatus(){
        return currentStatus;
    }
}
