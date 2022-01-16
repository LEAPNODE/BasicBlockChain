package com.leapnode.block;

import java.util.Date;
import com.leapnode.hash.BlockHash;

/**
 * Basics of building a block linked with other blocks (chain).
 * Each block in the LNBlock data structure contains a hash, the hash of the previous hash
 * (in another block) and data to be included in the transaction.
 *
 * Each new block is appended to the end of the chain, hence only the previous block
 * hash is used.
 *
 * This hash will include a timestamp.  The origins I believe are from Bitcoin and Solana
 * uses something similar for "Proof of History".
 *
 * @author brandon@solanaleap.com
 * @since 0.1
 * @version 0.1
 */

public class LNBlock extends Block {

    public String hash, previousHash;
    private String data;
    private long timeStamp;

    /**
     * Class constructor setting up the data structure with values.
     * @param data - What data is included in the block, or transaction.
     * @param previousHash - Link to the previous blocks hash.  This block extends the blockchain.
     */
    public LNBlock (String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash(this.previousHash, this.timeStamp, this.data);
    }

    /**
     * Provides a hash that will be used in the transaction to help validate the block.
     * SHA256 is currently used and aligns with Bitcoin but will consider future
     * cryptographic hashes.
     *
     * There is a call to BlockHash that will perform the hashing.
     *
     * @param previousHash - Previous block hash - this is kept to link blocks in a chain.
     * @param timeStamp - Stores a time but unsure how this will be used beyond a test.
     * @param data - Data in the block and transaction.
     * @return - The blocks hash to be used to validate the block by a miner and/or validator
     */
    public String calculateHash(String previousHash, long timeStamp, String data){
        try{
            return new String(BlockHash.sha256(this.previousHash + Long.toString(this.timeStamp) + this.data));
        }
        catch(NullPointerException npe){
            return new String("NullPointerException Hashing " + npe.getMessage());
        }
        catch (Exception e){
            return new String("General Exception " + e.getMessage());
        }
    }

    public String getHash(){
        return hash;
    }
}
