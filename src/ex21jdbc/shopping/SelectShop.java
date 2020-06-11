package ex21jdbc.shopping;

import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;

public class SelectShop extends IConnectImpl{
	String goods_name = scanValue("상품이름");
	int g_idx;
	String goods_price;
	String regidate;
	String p_code;
	public SelectShop() {
		super("kosmo", "1234");
	}
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			String sql = "SELECT g_idx, goods_name, ltrim(to_char(goods_price, '999,999,000')), "
					+ " to_char(regidate, 'yyyy-mm-dd HH:mi'), p_code FROM sh_goods "
					+ " WHERE goods_name LIKE '%'||'"+ goods_name +"'||'%'";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				g_idx = rs.getInt(1);
				goods_name = rs.getString(2);
				goods_price = rs.getString(3);
				regidate = rs.getString(4);
				p_code = rs.getString(5);
				System.out.printf("%d, %s, %s, %s, %s"
						+ "", g_idx, goods_name, goods_price, regidate, p_code);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
				
		new SelectShop().execute();
	}

}
