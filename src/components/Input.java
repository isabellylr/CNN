package components;

import java.util.List;

public class Input {
	private Node node;
	private List<Node> dependentNodes;
	private boolean dependency;
	
	public Input(Node node, List<Node> dependtNodes, boolean dependency) {
			this.node = node;
			this.dependentNodes = dependtNodes;
			this.dependency = dependency;
	}
	
	public Input(Node node) {
		this.node = node;
	}

	public Node node() {
		return node;
	}

	public List<Node> dependentNode() {
		return dependentNodes;
	}

	public boolean dependency() {
		return dependency;
	}
	
	public boolean hasDependency() {
		return this.dependentNodes != null;
	}
	
	public boolean feetsDependency() {
		for (Node node : dependentNodes) {
			if (this.dependency != node.active()) {
				return false;
			}
		}
		return true;
	}
}