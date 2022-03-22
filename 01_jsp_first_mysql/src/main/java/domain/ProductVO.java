package domain;
// domain: 칼럼이 가질수 있는 데이터 범위
// VO가 기준으로 움직이기 때문에 domain이라고 이름을 지었다
// 데이터베이스에 연결하는 역할을 하지만 db는 자바가 아니다 결국 데이터는 DAO에서 나오는 것처럼 보여진다 따라서 repository라고 짓는다
public class ProductVO {
	private int pno;
	private String pname;
	private int price;
	private String regDate;
	private String madeBy;
	
	public ProductVO() {}

	// 상품 등록용 생성자
	public ProductVO(String pname, int price, String madeBy) {
		this.pname = pname;
		this.price = price;
		this.madeBy = madeBy;
	}

	// 상품 리스트용 생성자
	public ProductVO(int pno, String pname, int price) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}

	// 상품 수정용 생성자
	public ProductVO(int pno, String pname, int price, String madeBy) {
		this(pno, pname, price);
		this.madeBy = madeBy;
	}

	// 상품 디테일용 생성자 -> 어차피 다 나와야하기 때문에 마지막에 하는 것이 좋다
	public ProductVO(int pno, String pname, int price, String regDate, String madeBy) {
		this(pno, pname, price, madeBy);
		this.regDate = regDate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMadeBy() {
		return madeBy;
	}

	public void setMadeBy(String madeBy) {
		this.madeBy = madeBy;
	}

	@Override
	public String toString() {
		return "ProductVO [pno=" + pno + ", pname=" + pname + ", price=" + price + ", regDate=" + regDate + ", madeBy="
				+ madeBy + "]";
	}

	
	
}
