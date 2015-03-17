interface Image {
	public void showImage();
}

class RealImage implements Image {
	private String filename;
	
	public RealImage(String filename) {
		this.filename = filename;
		load();
	}
	
	private void load() {
		System.out.println("Loading image " + filename);
	}
	
	public void showImage() {
		System.out.println("Rendering image " + filename);
	}
}

class ImageProxy implements Image {
	private String filename;
	private Image realImage;
	
	public ImageProxy(String filename) {
		this.filename = filename;
	}
	
	public void showImage() {
		if (realImage == null)
			realImage = new RealImage(filename);
		realImage.showImage();
	}
}

public class ProxyPattern {
	public static void main(String[] args) {
		Image image1 = new RealImage("image1");
		Image image2 = new RealImage("image2");
		Image image3 = new ImageProxy("image3");
		Image image4 = new ImageProxy("image4");
		image1.showImage();
		image4.showImage();
	}
}
