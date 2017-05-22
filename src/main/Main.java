package main;

import java.util.ArrayList;
import java.util.Arrays;

import components.Network;
import components.Node;

public class Main {
	private static double weight = 0.5;
	private static double extendedWeight = 0.6;
	private static String[] nodes = {"q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "eT","eB","tT","tB", "t", "d", "e"};
	private static String[] extendedNodes = {"c0", "c1", "c2", "c3"};
	
	public static void main(String[] args) {
		//Network network = createNetwork();
		Network network = createExtendedNetwork();
		
		network.activate("q0");
		network.update();
		System.out.println(network);
		
		for (int i = 0; i < 20; i++) {
			if (i%2==0) network.activate("t");
			if(i==5) network.activate("e");
			network.update();
			System.out.println(network);
		}
		
	}
	
	private static Network createNetwork() {
		Network network = new Network();
		for (int i = 0; i < nodes.length; i++) {
			network.addNode(new Node(nodes[i], weight));
		}
		
		for (int i = 0; i < 9; i++) {
			network.addConnection(nodes[i], nodes[i], new ArrayList<String>(Arrays.asList("t")), false);
			network.addConnection(nodes[(i+1)%9], nodes[i], new ArrayList<String>(Arrays.asList("t")), true);
		}
		
		network.addConnection("eT", "q1");
		network.addConnection("eT", "q5");
		network.addConnection("eT", "q6");
		
		network.addConnection("eT", "q2");
		network.addConnection("eB", "q7");
		network.addConnection("eB", "q8");
		
		network.addConnection("tT", "q3");
		network.addConnection("tT", "q5");
		network.addConnection("tT", "q7");
		
		network.addConnection("tB", "q4");
		network.addConnection("tB", "q6");
		network.addConnection("tB", "q8");
		
		network.addConnection("d", "q8");
		network.addConnection("d", "d", new ArrayList<String>(Arrays.asList("t")), false);
		
		return network;
	}
	
	private static Network createExtendedNetwork() {
		Network network = new Network();
		for (int i = 0; i < nodes.length; i++) {
			network.addNode(new Node(nodes[i], weight));
		}
		for (int i = 0; i < extendedNodes.length; i++) {
			network.addNode(new Node(extendedNodes[i], extendedWeight));
		}
		
		for (int i = 0; i < 9; i++) {
			network.addConnection(nodes[i], nodes[i], new ArrayList<String>(Arrays.asList("t")), false);
			network.addConnection(nodes[(i+1)%9], nodes[i], new ArrayList<String>(Arrays.asList("t")), true);
		}
		
		network.addConnection("c0", "q2");
		network.addConnection("c0", "e");
		network.addConnection("c0", "c0", new ArrayList<String>(Arrays.asList("d")), false);
		network.addConnection("c1", "q3");
		network.addConnection("c1", "e");
		network.addConnection("c1", "c1", new ArrayList<String>(Arrays.asList("d")), false);
		network.addConnection("c2", "q4");
		network.addConnection("c2", "e");
		network.addConnection("c2", "c2", new ArrayList<String>(Arrays.asList("d")), false);
		network.addConnection("c3", "q5");
		network.addConnection("c3", "e");
		network.addConnection("c3", "c3", new ArrayList<String>(Arrays.asList("d")), false);
		
		network.addConnection("eT", "q1");
		network.addConnection("eT", "q5", new ArrayList<String>(Arrays.asList("c0", "c2")), false);
		network.addConnection("eT", "q6", new ArrayList<String>(Arrays.asList("c0", "c3")), false);
		
		network.addConnection("eB", "q2");
		network.addConnection("eB", "q7", new ArrayList<String>(Arrays.asList("c1", "c2")), false);
		network.addConnection("eB", "q8", new ArrayList<String>(Arrays.asList("c1", "c3")), false);
		
		network.addConnection("tT", "q3");
		network.addConnection("tT", "q5", new ArrayList<String>(Arrays.asList("c0", "c2")), false);
		network.addConnection("tT", "q7", new ArrayList<String>(Arrays.asList("c1", "c2")), false);
		
		network.addConnection("tB", "q4");
		network.addConnection("tB", "q6", new ArrayList<String>(Arrays.asList("c0", "c3")), false);
		network.addConnection("tB", "q8", new ArrayList<String>(Arrays.asList("c1", "c3")), false);
		
		network.addConnection("d", "q8");
		network.addConnection("d", "d", new ArrayList<String>(Arrays.asList("t")), false);
		
		return network;
	}
}
