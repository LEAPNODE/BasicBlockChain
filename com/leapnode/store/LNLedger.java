package com.leapnode.store;

import com.leapnode.block.Block;
import com.leapnode.block.GenesisBlock;
import com.leapnode.block.LNBlock;
import com.leapnode.status.LedgerStatus;

import java.util.ArrayList;

/**
 * Singleton class to manage the ledger.  A single instance with all Ledger requests will help maintain
 * control of the Ledger.
 *
 * For test purposes, an ArrayList of blocks with a hash value.  Essentially a linked list
 * from the early Computer Science courses.
 *
 * Future - persistent storage of a block
 *
 * @author brandon@solanaleap.com
 * @since 0.1
 * @version 0.1
 * @see LedgerStatus - The ledger (blockchain) status is returned containing a value matching in this class.
 * @see LNBlock - This is the block entered into the ledger
 */

public class LNLedger {

    private static LNLedger instance;
    private static int ledgerStatus = LedgerStatus.IS_EMPTY;

    public static ArrayList<Block> ledger = new ArrayList<>();

    // Construct the instance at class loading time
    static { instance = new LNLedger(); }

    private LNLedger(){}

    /**
     * Must be called by the main application or controller (depending on design pattern)
     * @return instance of LNLedger
     */
    public static LNLedger getInstance(){
        return instance;
    }

    /**
     * Need to revise this to have a single addBlock.
     * @param genesisBlock - Actual GenesisBlock
     * @return Ledger Status
     */
    public int addGenesisBlock(GenesisBlock genesisBlock){
        ledger.add(genesisBlock);
        System.out.println("Genesis Block " + ledger.size() + ": " + genesisBlock.getHash());
        ledgerStatus = LedgerStatus.ACTIVE;
        return ledgerStatus;
    }

    /**
     * Adds a block to the ledger and returns the Ledger status.
     *
     * @param lnBlock LNBlock Data Structure
     * @return BlockChainStatus int code
     */
    public int addBlock(LNBlock lnBlock){
        ledger.add(lnBlock);
        System.out.println("Block " + ledger.size() + ": " + lnBlock.getHash());
        return LedgerStatus.ACTIVE;
    }

    /**
     * This is very much for testing as an individual.  Can't imagine this being
     * accurate in a real distributed blockchain that has any type of decent speed.
     * @return LNBlock of the last known index at the time this method is called.
     */
    public LNBlock getLastBlock(){
        return (LNBlock) ledger.get(ledger.size());
    }

    public long getLedgerSize(){
        return ledger.size();
    }

    /**
     * Method notifies the caller of the current BlockchainStatus status.
     * @return BlockchainStatus value
     */
    public int getLedgerStatus(){
        return ledgerStatus;
    }
}
