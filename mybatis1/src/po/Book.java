package po;

public class Book {

	private Long book_id;
	private String name;
	private int number;
	public Long getBook_id() {
		return book_id;
	}
	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "book [book_id=" + book_id + ", name=" + name + ", number=" + number + "]";
	}
	
	
}
