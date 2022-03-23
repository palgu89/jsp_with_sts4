package domain;

public class EmpVO {
	// 데이터베이스의 컬럼과 같은 이름으로 변수 정의
	// CRUD에 필요한 형태의 생성자 정의
	// 겟터, 셋터
	// toString()
	
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private String hireDate;
	private int sal;
	private int comm;
	private int deptno;
		
	// insert
	public EmpVO(int empno, String ename, int sal) {
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
	}

	// list
	public EmpVO(int empno, String ename, String hireDate, int deptno) {
		this.empno = empno;
		this.ename = ename;
		this.hireDate = hireDate;
		this.deptno = deptno;
	}

	// update
	public EmpVO(int empno, String job, int mgr, int sal, int comm, int deptno) {
		this.empno = empno;
		this.job = job;
		this.mgr = mgr;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	// detail
	public EmpVO(int empno, String ename, String job, int mgr, String hireDate, int sal, int comm, int deptno) {
		this(empno, job, mgr, sal, comm, deptno);
		this.ename = ename;
		this.hireDate = hireDate;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMgr() {
		return mgr;
	}

	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hireDate=" + hireDate
				+ ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + "]";
	}

	
	
}
