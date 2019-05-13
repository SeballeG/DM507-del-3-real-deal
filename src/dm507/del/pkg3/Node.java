/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dm507.del.pkg3;

/**
 *
 * @author sebastian
 */
    public class Node {

        private int key;
        private Node leftChild = null;
        private Node rightChild = null;
        private int frequency = 0;

        public Node(int key) {
            this.key = key;
            
        }

        public int getKey() {
            return key;
        }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

        public void setKey(int key) {
            this.key = key;
        }

        public boolean hasLeftChield() {
            if (leftChild == null) {
                return false;
            }
            return true;
        }

        public Node getLeftChield() {
            return leftChild;
        }

        public void setLeftChield(Node leftChield) {
            this.leftChild = leftChield;
        }

        public boolean hasRightChield() {
            if (rightChild == null) {
                return false;
            }
            return true;
        }

        public Node getRightChield() {
            return rightChild;
        }

        public void setRightChield(Node rightChield) {
            this.rightChild = rightChield;
        }

    }

