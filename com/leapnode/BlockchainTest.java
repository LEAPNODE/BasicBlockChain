package com.leapnode;

import com.leapnode.block.GenesisBlock;
import com.leapnode.block.LNBlock;
import com.leapnode.status.LedgerStatus;
import com.leapnode.store.LNLedger;

/**
 *  Main class for Blockchain Testing.  This is to get a basic idea of blockchains at
 *  a programatic level. This was started with source
 *  <a href="from https://www.geeksforgeeks.org/implementation-of-blockchain-in-java/">GeeksForGeeks.com</a>
 *
 * @author brandon@solanaleap.com
 * @since 0.1
 * @version 0.1
 */

public class BlockchainTest {
 
    public static void main(String[] args) {

        System.out.println("Basic Blockchain for Testing");

        // Create genesis block
        GenesisBlock genesisBlock = GenesisBlock.getGenesisBlock();


        // Get LNLedger instance
        LNLedger ledger = LNLedger.getInstance();

        // Adding blocks to the ledger
        for (int i = 0; i < 10; i++) {
            System.out.println("count = " + i + ", status = " + ledger.getLedgerStatus());
            if (ledger.getLedgerStatus() == LedgerStatus.IS_EMPTY) {
                ledger.addGenesisBlock(genesisBlock);
            } else if (ledger.getLedgerStatus() == LedgerStatus.ACTIVE) {
                ledger.addBlock(new LNBlock("Test" + Integer.toString(i), genesisBlock.getHash()));
            }
        }

    }
  
}
