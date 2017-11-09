import java.util.ArrayList;
import java.util.List;

interface TextTag {
	public void startWrite();
	public void endWrite();
}

interface TextTagComposite extends TextTag {
	public List<TextTag> getTags();
	public void addTag(TextTag tag);
}

class PTag implements TextTagComposite {
	private List<TextTag> tags = new ArrayList<TextTag>();

	@Override
	public void startWrite() {
		System.out.println("<p>");
	}

	@Override
	public void endWrite() {
		System.out.println("</p>");
	}

	@Override
	public List<TextTag> getTags() {
		return tags;
	}

	@Override
	public void addTag(TextTag tag) {
		tags.add(tag);
	}
}

class SpanTag implements TextTag {

	@Override
	public void startWrite() {
		System.out.println("<span>");
	}

	@Override
	public void endWrite() {
		System.out.println("</span>");
	}

}

class EmTag implements TextTag {

	@Override
	public void startWrite() {
		System.out.println("<em>");
	}

	@Override
	public void endWrite() {
		System.out.println("</em>");
	}

}

public class CompositeDemo {
	public static void main(String[] args) {
		TextTagComposite composite = new PTag();
		composite.addTag(new SpanTag());
		composite.addTag(new EmTag());

		composite.startWrite();
		for (TextTag tag : composite.getTags()) {
			tag.startWrite();
			tag.endWrite();
		}
		composite.endWrite();
	}
}
