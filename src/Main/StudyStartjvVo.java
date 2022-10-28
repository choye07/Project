package Main;

public class StudyStartjvVo {

	String Sname;
	String jvStudy1;
	String jvStudy2;
	String jvStudy3;
	String jvstdt;
	String jvstt;

	public String toString() {
		return "Vo [id=" + LoginVo.userid.getId() + ", sname=" + Sname + ", jvstdt=" + jvstdt+", jvStudy1=" +  jvStudy1 + ", jvStudy2="
				+ jvStudy2 + ", jvStudy3=" + jvStudy3  + ", jvstt=" + jvstt + "]";
	}

	public StudyStartjvVo(String Sname, String jvstdt,String jvStudy1, String jvStudy2, String jvStudy3, String jvstt) {
		this.Sname = Sname;
		this.jvstdt = jvstdt;
		this.jvStudy1 = jvStudy1;
		this.jvStudy2 = jvStudy2;
		this.jvStudy3 = jvStudy3;
		this.jvstt = jvstt;

	}

	public String getSname() {
		return Sname;
	}

	public String getJvStudy1() {
		return jvStudy1;
	}

	public void setJvStudy1(String jvStudy1) {
		this.jvStudy1 = jvStudy1;
	}

	public String getJvStudy2() {
		return jvStudy2;
	}

	public void setJvStudy2(String jvStudy2) {
		this.jvStudy2 = jvStudy2;
	}

	public String getJvStudy3() {
		return jvStudy3;
	}

	public void setJvStudy3(String jvStudy3) {
		this.jvStudy3 = jvStudy3;
	}

	public String getJvstdt() {
		return jvstdt;
	}

	public void setJvstdt(String jvstdt) {
		this.jvstdt = jvstdt;
	}

	public String getJvstt() {
		return jvstt;
	}

	public void setJvstt(String jvstt) {
		this.jvstt = jvstt;
	}

	public void setSname(String sname) {
		Sname = sname;
	}


}
