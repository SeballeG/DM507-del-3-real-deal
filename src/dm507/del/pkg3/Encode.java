/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package dm507.del.pkg3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author sebastian
 */
public class Encode {

    
    private static int length; //the max number of knots
    private static int heapSize = 255; // the current amount of knots
    private static int[] inputArray; //the array filled with the input gathered from the file
    PQ heap = new PQHeap(256); //The heap (convert the array of integers to a heap in hoffman?)
    private static final int SIZE = 255;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        inputArray = new int[SIZE];
        //doesnt read properly might be me typing wrong?
        File textFile = new File("/Users/sebastian/Documents/TextFiles/TextFileTest.txt"); 
        
	FileInputStream inFile = new FileInputStream(textFile);
	FileOutputStream outFile = new FileOutputStream(textFile);

	BitInputStream in = new BitInputStream(inFile);
	BitOutputStream out = new BitOutputStream(outFile);
        
        //scanner tool okay?
        Scanner sc = new Scanner(textFile);
        
        // muligvis bruge while(in.readInt == instanceOf.Integer)
        
        while(sc.hasNext()) {
            System.out.println(in.readInt());
            int i = in.readInt(); 
            inputArray[i]++;
            
        }
        //is this okay? if not use minHeapify/minSort and maybe convert it to a heap?
        Arrays.sort(inputArray);
        System.out.println(inputArray[0]);
        System.out.println(inputArray[1]);
        
        HoffmanOrganizer(inputArray);
        
        
    }
    
    public static void HoffmanOrganizer(int[] C){
        
        
        int[] Q = C;
        int n = C.length;
        int i;
        //specified for loop for itteration
        for(i = 1 ;i<=n-1;i++){
        Node[] binaryTree = new Node[255];
        Element F = new Element(0,binaryTree);
        //counter necessary?
        int counter = i;
        //creating node the parent node
        Node z = new Node(0);
        
        //creating the node and setting their frequency
        Node x = new Node(MinExtract(Q));
        z.setLeftChield(x);
        
        Node y = new Node(MinExtract(Q));
        z.setRightChield(y);
        //test
        //setting the parents frequency to be equal to both the childrens added together
        z.setFrequency(x.getFrequency() + y.getFrequency());
        
        //set nodes to the buttom of the binary tree (note to group: is this necessary?)
        binaryTree[counter] = z;
        binaryTree[counter] = x;
        binaryTree[counter] = y;
        
        //Setting the key for our element so it is the added amount of the frequency of both the nodes
        F.setKey(z.getFrequency());
        
        //inserting the frequency into the array so further nodes can be added to that sub-tree
        insert(z.getFrequency(),Q);
        
        }
   
    }
    //this method is rewritten from PQHeap to be able to sort a array of integers instead of an array of Elements (also removed the sorting)
    public static int MinExtract(int[] C){
        int min = C[1];
        C[1] = C[heapSize-1];
        heapSize = heapSize - 1;
//         minHeapify(1);
         return min;
        
    }
    //this method is rewritten from PQHeap to be able to sort a array of integers instead of an array of Elements (also removed the sorting)
    public static void insert(int e, int[] i ) {
        //checks if size limit is reached
        if (heapSize >= i.length) {
            return;
        }
        //insert new element
        i[heapSize] = e;

        //sort
//        minHeapify(heapSize);
        heapSize++;
    }
    //converting the hoffman tree into a table of the values and they codenames 
    public static void convert(Node[] tree){
        //TODO
        
    }
}