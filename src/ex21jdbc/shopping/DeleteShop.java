package ex21jdbc.shopping;

import java.sql.Types;

import ex21jdbc.connect.IConnectImpl;

public class DeleteShop extends IConnectImpl{

	public DeleteShop() {
		super("kosmo", "1234");
	}
	@Override
	public void execute() {
		try {
			csmt = con.prepareCall("{call ShopDeleteGoods(?,?)}");
			csmt.setString(1, scanValue("삭제할 상품의 일련번호"));
			csmt.registerOutParameter(2, Types.NUMERIC);
			csmt.execute();
			int affected = 0;
			if(affected==1) {
				System.out.println("삭제실패");
			}
			else {
				System.out.println("삭제성공");
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

		new DeleteShop().execute();
	}

}
