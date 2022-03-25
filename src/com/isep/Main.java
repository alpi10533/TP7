package com.isep;

import com.isep.blockchain.Blockchain;

/**
 * Class Main
 */
public class Main {

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.simulation();
        blockchain.display();
    }

}
