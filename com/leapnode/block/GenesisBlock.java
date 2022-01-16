package com.leapnode.block;

import com.leapnode.hash.BlockHash;

import java.util.Date;

public class GenesisBlock extends Block{

    private String data = "Created " + new Date().getTime() + " this is fun.";
    private long timeStamp;
    private static GenesisBlock instance;

    public static String hash;

    /**
     * Private constructor so only the main class or controller should call.
     */
    private GenesisBlock (){
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(this.timeStamp, this.data);
    }

    static { instance = new GenesisBlock(); }

    /**
     * Allows the main or controller class to get the GenesisBlock and add to the Ledger.
     * @return
     */
    public static GenesisBlock getGenesisBlock(){ return instance; }

    /**
     * Get the genesis block hash.  This value is added to the ledger first.
     * @return Hash value for the Genesis block
     */
    public static String getHash() {
        return hash;
    }

    /**
     * Creates the hash for the genesis block.
     *
     * There is a call to BlockHash that will perform the hashing.
     *
     * @param timeStamp - Stores a time but unsure how this will be used beyond a test.
     * @param data - Data in the block and transaction.
     * @return - The blocks hash to be used to validate the block by a miner and/or validator
     */
    private String calculateHash(long timeStamp, String data){
        try{
            return new String(BlockHash.sha256(Long.toString(this.timeStamp) + this.data));
        }
        catch(NullPointerException npe){
            return new String("NullPointerException Hashing " + npe.getMessage());
        }
        catch (Exception e){
            return new String("General Exception " + e.getMessage());
        }
    }
}
