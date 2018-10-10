package db.model;


import java.sql.Timestamp;

public class Run_status {
	private Integer run_id ;
	private Timestamp  sub_time ;
	private String judge_status ;
	private Integer qid ;
	private String language;
	private Integer run_time ;
	private Integer run_memory ;
	private Integer uid ;
	private String code ;

	public Run_status() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRun_id() {
		return run_id;
	}

	public void setRun_id(Integer run_id) {
		this.run_id = run_id;
	}

	public Timestamp getSub_time() {
		return sub_time;
	}

	public void setSub_time(Timestamp sub_time) {
		this.sub_time = sub_time;
	}

	public String getJudge_status() {
		return judge_status;
	}

	public void setJudge_status(String judge_status) {
		this.judge_status = judge_status;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getRun_time() {
		return run_time;
	}

	public void setRun_time(Integer run_time) {
		this.run_time = run_time;
	}
   public  Integer getRun_memory() {
		return run_memory;
	}

	public void setRun_memory(Integer run_memory) {
		this.run_memory = run_memory;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "{run_id=" + run_id + ", sub_time=" + sub_time + ", judge_status=" + judge_status + ", qid="
				+ qid + ", language=" + language + ", run_time=" + run_time + ", run_memory=" + run_memory + ", uid="
				+ uid + ", code=" + code + "}";
	}
	
   /* public String toString(){
	return "judge_status: "+judge_status+"  language: "+language+" subTime"+sub_time.toString();
    }*/

}
