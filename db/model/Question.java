package db.model;

public class Question {
	private Integer qid;
	private Integer cid;
	private String qname;
	private String description;
	
    public Question() {
    	
    }
    public Question(Integer qid, Integer cid, String qname, String description) {
    	this.qid=qid; this.cid=cid;
    	this.qname=qname; this.description=description;
    }
    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer id) {
        this.qid = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    

    public String getName() {
        return qname;
    }

    public void setName(String name) {
        this.qname = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    @Override
    public String toString() {
        return  "{"+
                "qid:\"" + qid + '\"'+ 
                ", cid:\"" + cid + '\"'+
                ", name:\"" + qname + '\"' +
                ", description:\"" + description + '\"'+
                "}";
    }
}
