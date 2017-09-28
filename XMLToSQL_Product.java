import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLToSQL_Product {
	static Connection con;
	static String PDPD_KY, PDPD_CODE, PDPD_ID, SYSV_PDPD_TYPE, PDPD_LONG_NAME,
			PDPD_SHORT_NAME, PDPD_ORG_NAME, SYSV_PDPD_TYPE_CODE,
			SYSV_PDPD_TYPE_DESC, sql;

	public static void main(String args[]) {
		try {
			con = DriverManager
					.getConnection(
							"jdbc:sqlserver://127.0.0.1:1433;databaseName=EH21_PROD_XINDA",
							"sa", "1q2w3e4R");
			Statement stmt = con.createStatement();
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("TBEH_PDPD_PRODUCT_INFO10.xml");
			NodeList n1 = doc.getElementsByTagName("Log_list");
			for (int i = 0; i < n1.getLength(); i++) {
				Element node = (Element) n1.item(i);
				PDPD_KY = node.getElementsByTagName("PDPD_KY").item(0)
						.getTextContent();
				PDPD_CODE = node.getElementsByTagName("PDPD_CODE").item(0)
						.getTextContent();
				PDPD_ID = node.getElementsByTagName("PDPD_ID").item(0)
						.getTextContent();
				SYSV_PDPD_TYPE = node.getElementsByTagName("SYSV_PDPD_TYPE")
						.item(0).getTextContent();
				PDPD_LONG_NAME = node.getElementsByTagName("PDPD_LONG_NAME")
						.item(0).getTextContent();
				PDPD_SHORT_NAME = node.getElementsByTagName("PDPD_SHORT_NAME")
						.item(0).getTextContent();
				PDPD_ORG_NAME = node.getElementsByTagName("PDPD_ORG_NAME")
						.item(0).getTextContent();
				SYSV_PDPD_TYPE_CODE = node
						.getElementsByTagName("SYSV_PDPD_TYPE_CODE").item(0)
						.getTextContent();
				SYSV_PDPD_TYPE_DESC = node
						.getElementsByTagName("SYSV_PDPD_TYPE_DESC").item(0)
						.getTextContent();
				sql = "insert into TBEH_PDPD_PRODUCT_INFO(PDPD_KY,PDPD_CODE,PDPD_ID,SYSV_PDPD_TYPE,PDPD_LONG_NAME,PDPD_SHORT_NAME,PDPD_ORG_NAME,SYSV_PDPD_TYPE_CODE,SYSV_PDPD_TYPE_DESC) values('"
						+ PDPD_KY
						+ "','"
						+ PDPD_CODE
						+ "','"
						+ PDPD_ID
						+ "','"
						+ SYSV_PDPD_TYPE
						+ "','"
						+ PDPD_LONG_NAME
						+ "','"
						+ PDPD_SHORT_NAME
						+ "','"
						+ PDPD_ORG_NAME
						+ "','"
						+ SYSV_PDPD_TYPE_CODE
						+ "','"
						+ SYSV_PDPD_TYPE_DESC
						+ "')";
				stmt.executeUpdate(sql);

			}
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
