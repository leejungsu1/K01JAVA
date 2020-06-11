package ex21jdbc.shopping;

import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class UpdateShop extends IConnectImpl{
	
	public UpdateShop() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		try {
			csmt = con.prepareCall("{call ShopUpdateGoods(?,?,?,?,?)}");
			csmt.setString(1, scanValue("상품명"));
			csmt.setString(2, scanValue("상품가격"));
			csmt.setString(3, scanValue("상품코드"));
			csmt.setString(4, scanValue("일련번호"));
			csmt.registerOutParameter(5, Types.NUMERIC);
			csmt.execute();
			int affected = 0;
			if(affected==1) {
				System.out.println("입력실패");
			}
			else {
				System.out.println("입력성공");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	public static void main(String[] args) {

		new UpdateShop().execute();
	}

}
