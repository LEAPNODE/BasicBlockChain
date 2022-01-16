package com.leapnode.status;

public class LedgerStatus {

    public static final int ACTIVE = 0;     // Blockchain is not empty and blocks are available
    public static final int NOT_ACTIVE = 1; // Blockchain may be empty or unavailable to process blocks
    public static final int IDLE = 2;       // Blockchain is not empty but no blocks are being processed
    public static final int IS_EMPTY = 3;   // Blockchain has no blocks
    public static final int UNKNOWN = 4;    // Something is bad

}
