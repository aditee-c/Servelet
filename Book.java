class Book{
	private int bookId;
	private String name;
	
	public void getBookId(int bookId){
		this.bookId= bookId;
	}
	public setBookId(int bookId){
		System.out.println("Book Id is set");
		return bookId;
	}
	
	public void getBookId(String name){
		this.name= name;
	}
	public setBookId(String name){
		return name;
	}
}