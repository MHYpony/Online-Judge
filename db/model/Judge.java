package db.model;

public class Judge {
	
	private Integer qid;
	private String code;
	private Integer uid;
	public Judge() {}
	public Judge(Integer qid, String code, Integer uid) {
		this.qid = qid;
		this.code = code;
		this.uid = uid;
	}
	public Integer getqid() {
		return qid;
	}
	public void setqid(Integer qid) {
		this.qid = qid;
	}
	public String getcode() {
		return code;
	}
	public void setcode(String code) {
		this.code = code;
	}
	public Integer getuid() {
		return uid;
	}
	public void setuid(Integer uid) {
		this.uid = uid;
	}
	
}
