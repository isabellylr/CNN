package components;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;
	private double weight;
	private List<Input> input;
	private boolean activePrevious;
	private boolean activeCurrent;

	public Node(String name, double weight) {
		this.name = name;
		this.weight = weight;
		input = new ArrayList<>();
	}

	public void addInput(Input input) {
		this.input.add(input);
	}
	
	public String name() {
		return this.name;
	}

	public void update() {
		double totalInput = 0;
		for (Input input : this.input) {
			if (input.node().activePrevious) {
				if ((!input.hasDependency()) || input.feetsDependency()) {
					totalInput += input.node().weight;
				}
			}
		}
		this.activeCurrent = totalInput >= this.weight;
	}
	
	public double weight() {
		return this.weight;
	}

	public boolean active() {
		return this.activePrevious;
	}

	public void activate() {
		this.activeCurrent = true;
	}
	
	public void clearCurrent() {
		this.activePrevious = this.activeCurrent;
		this.activeCurrent = false;
	}

	@Override
	public String toString(){
		return this.name;
	}
}