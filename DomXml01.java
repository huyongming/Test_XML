//import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DomXml01 {
	static String CLMNO, SubType, NumPages, Pages, PageCount;
	
    //获取Peihe_CLAIM_20170926_9858.xml TranData/Claim/images/image节点下指定结点值
	public static void main(String args[]) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Peihe_CLAIM_20170926_9858.xml");
			NodeList n1 = doc.getElementsByTagName("Image");
			for (int i = 0; i < n1.getLength(); i++) {
				Element node = (Element) n1.item(i);
				CLMNO = node.getElementsByTagName("CLMNO").item(0)
						.getFirstChild().getNodeValue();
				SubType = node.getElementsByTagName("SubType").item(0)
						.getFirstChild().getNodeValue();
				NumPages = node.getElementsByTagName("NumPages").item(0)
						.getFirstChild().getNodeValue();
				Pages = node.getElementsByTagName("Pages").item(0)
						.getFirstChild().getNodeValue();
				PageCount = node.getElementsByTagName("PageCount").item(0)
						.getFirstChild().getNodeValue();

				System.out.println("CLMNO=" + CLMNO);
				System.out.println("SubType=" + SubType);
				System.out.println("NumPages=" + NumPages);
				System.out.println("Pages=" + Pages);
				System.out.println("PageCount=" + PageCount);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
