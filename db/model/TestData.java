package db.model;

public class TestData {
    private Integer tid;
	private Integer qid;
	private String input;
	private String output;
	
	public TestData(){
		
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid=tid;
	}
	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
	// public ArrayList<InputOutput> getInputOutputs() {
	// return inputOutputs;
	// }
	//
	// public void setInputOutputs(ArrayList<InputOutput> inputOutputs) {
	// this.inputOutputs = inputOutputs;
	// }

	@Override
	public String toString() {
		return "TestData{" + "qid=" + qid + ", input=" + input + ", output=" + output + '}';
	}

}
