package com.isep.blockchain;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class Blockchain
 */
public class Blockchain {

    //
    // Fields
    //
    public ArrayList<Block> blocks;

    public Blockchain(){
        blocks = new ArrayList<>();
    }

    public void addBlock() {
        this.blocks.add(new Block());
    }

    public void simulation(){
        addBlock();
        ArrayList<Wallet> wallets = new ArrayList<>();
        String[] users = new String[] {"Yannick", "Jean-Baptiste", "Pierre", "Thibault", "Amaury"};
        for (int i = 0; i < users.length; ++i) {
            Wallet wallet = new Wallet(users[i]);
            wallet.setIsepCoins(10);
            wallets.add(wallet);
        }
        for (int i = 0; i < 20; ++i) {
            int rand1 = new Random().nextInt(users.length);
            int rand2 = new Random().nextInt(users.length);
            if (blocks.get(blocks.size()-1).addTransaction(wallets.get(rand1), wallets.get(rand2), 1) != 0) {
                addBlock();
                blocks.get(blocks.size()-1).addTransaction(wallets.get(rand1), wallets.get(rand2), 1);
            }
            for (int j = 0; j < blocks.get(blocks.size()-1).getTransactions().size(); ++j) {
                blocks.get(blocks.size()-1).getTransactions().get(j).processTransaction();
            }

        }
    }

    public void display(){
        for (int i = 0; i < blocks.size(); ++i) {
            System.out.println("\n\nBLOCK N°"+(i+1));
            for (int y = 0; y < blocks.get(i).getTransactions().size(); ++y) {
                System.out.println("\nTRANSACTION N°"+(y+1));
                System.out.println("FROM ? "+blocks.get(i).getTransactions().get(y).getOriginWallet().getOwner());
                System.out.println("TO ? "+blocks.get(i).getTransactions().get(y).getDestinationWallet().getOwner());
                System.out.println("HOW MANY ? "+blocks.get(i).getTransactions().get(y).getIsepCoins());
                System.out.println("PAYED ? "+blocks.get(i).getTransactions().get(y).isPayed());
            }
        }
    }

}
