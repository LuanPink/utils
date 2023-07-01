package model;

public class ModelRatingComment {
	private String image;
	private String name;
	private String email;
	private String title;
	private String product;
	private String content;
	private String time;
	
public ModelRatingComment() {
	// TODO Auto-generated constructor stub
}	
	
	public ModelRatingComment(String image,String name, String email, String title, String product,
			String content,String time) {
		this.image = image;
		this.email = email;
		this.title = title;
		this.name = name;
		this.product = product;
		this.content = content;
		this.time = time;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return "Nhận xét về";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
	
	
}
