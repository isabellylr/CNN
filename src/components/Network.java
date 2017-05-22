package components;

import java.util.ArrayList;
import java.util.List;

public class Network {
	private List<Node> nodes;

	public Network() {
		this.nodes = new ArrayList<>();
	}
	
	public void addNode(Node node) {
		this.nodes.add(node);
	}
	
	public void activate(String node) {
		getNode(node).activate();
	}
	
	public void addConnection(String node, String inputNode, List<String> dependentNodes, boolean dependency) {
		getNode(node).addInput(new Input(getNode(inputNode), getNodes(dependentNodes), dependency));
	}
	
	public void addConnection(String node, String inputNode) {
		getNode(node).addInput(new Input(getNode(inputNode)));
	}
	
	public void update() {
		for (Node node : this.nodes) node.clearCurrent();
		for (Node node : this.nodes) node.update();
	}
	
	public void print() {
		System.out.println("----");
		for (Node node : this.nodes) {
			if (node.active()) {
				System.out.println(node);
			}
		}
	}
	
	private Node getNode(String name) {
		for (Node node : this.nodes) {
			if (node.name().equals(name)) {
				return node;
			}
		}
		return null;
	}
	
	private List<Node> getNodes(List<String> names) {
		List<Node> nodes = new ArrayList<Node>();
		for (Node node : this.nodes) {
			if (names.contains(node.name())) {
				nodes.add(node);
			}
		}
		return nodes;
	}

}