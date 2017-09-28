import java.sql.*;
import java.io.*;

public class SQLToXML_Product {
	public static void main(String args[]) {
		try {
			File file = new File("TBEH_PDPD_PRODUCT_INFO12.xml");
			file.createNewFile();
			Writer fw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8"));
			Connection con = DriverManager
					.getConnection(
							"jdbc:sqlserver://127.0.0.1:1433;databaseName=XXX",
							"sa", "XXX");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st
					.executeQuery("select * from TBEH_PDPD_PRODUCT_INFO");
			fw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n");
			fw.write("<Begin>\r\n");
			while (rs.next()) {
				fw.write("<Log_list>\r\n");
				String PDPD_KY = rs.getString("PDPD_KY");
				if (PDPD_KY.equals("")) {
					fw.write("<PDPD_KY/>\r\n");
				} else {
					fw.write("<PDPD_KY>");
					fw.write(PDPD_KY);
					fw.write("</PDPD_KY>\r\n");
				}
				String PDPD_CODE = rs.getString("PDPD_CODE");
				if (PDPD_CODE.equals("")) {
					fw.write("<PDPD_CODE/>\r\n");
				} else {
					fw.write("<PDPD_CODE>");
					fw.write(PDPD_CODE);
					fw.write("</PDPD_CODE>\r\n");
				}
				String PDPD_ID = rs.getString("PDPD_ID");
				if (PDPD_ID.equals("")) {
					fw.write("<PDPD_ID/>\r\n");
				} else {
					fw.write("<PDPD_ID>");
					fw.write(PDPD_ID);
					fw.write("</PDPD_ID>\r\n");
				}
				String SYSV_PDPD_TYPE = rs.getString("SYSV_PDPD_TYPE");
				if (SYSV_PDPD_TYPE.equals("")) {
					fw.write("<SYSV_PDPD_TYPE/>\r\n");
				} else {
					fw.write("<SYSV_PDPD_TYPE>");
					fw.write(SYSV_PDPD_TYPE);
					fw.write("</SYSV_PDPD_TYPE>\r\n");
				}
				String PDPD_LONG_NAME = rs.getString("PDPD_LONG_NAME");
				if (PDPD_LONG_NAME.equals("")) {
					fw.write("<PDPD_LONG_NAME/>\r\n");
				} else {
					fw.write("<PDPD_LONG_NAME>");
					fw.write(PDPD_LONG_NAME);
					fw.write("</PDPD_LONG_NAME>\r\n");
				}
				String PDPD_SHORT_NAME = rs.getString("PDPD_SHORT_NAME");
				if (PDPD_SHORT_NAME.equals("")) {
					fw.write("<PDPD_SHORT_NAME/>\r\n");
				} else {
					fw.write("<PDPD_SHORT_NAME>");
					fw.write(PDPD_SHORT_NAME);
					fw.write("</PDPD_SHORT_NAME>\r\n");
				}
				String PDPD_ORG_NAME = rs.getString("PDPD_ORG_NAME");
				if (PDPD_ORG_NAME.equals("")) {
					fw.write("<PDPD_ORG_NAME/>\r\n");
				} else {
					fw.write("<PDPD_ORG_NAME>");
					fw.write(PDPD_ORG_NAME);
					fw.write("</PDPD_ORG_NAME>\r\n");
				}
				String SYSV_PDPD_TYPE_CODE = rs
						.getString("SYSV_PDPD_TYPE_CODE");
				if (SYSV_PDPD_TYPE_CODE.equals("")) {
					fw.write("<SYSV_PDPD_TYPE_CODE/>\r\n");
				} else {
					fw.write("<SYSV_PDPD_TYPE_CODE>");
					fw.write(SYSV_PDPD_TYPE_CODE);
					fw.write("</SYSV_PDPD_TYPE_CODE>\r\n");
				}
				String SYSV_PDPD_TYPE_DESC = rs
						.getString("SYSV_PDPD_TYPE_DESC");
				if (SYSV_PDPD_TYPE_DESC.equals("")) {
					fw.write("<SYSV_PDPD_TYPE_DESC/>\r\n");
				} else {
					fw.write("<SYSV_PDPD_TYPE_DESC>");
					fw.write(SYSV_PDPD_TYPE_DESC);
					fw.write("</SYSV_PDPD_TYPE_DESC>\r\n");
				}
				fw.write("</Log_list>\r\n");
			}
			fw.write("</Begin>");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
